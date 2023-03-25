package dadm.juaalgo7.quotationshake.data.newquotation

import dadm.juaalgo7.quotationshake.data.newquotation.model.QuotationDto
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(retrofit: Retrofit): NewQuotationDataSource {
    private val retrofitQuotationService = retrofit.create(NewQuotationRetrofit::class.java)

    override suspend fun getQuotation(lenguaje: String): Response<QuotationDto> {
        return try {
            retrofitQuotationService.getQuotation(lenguaje)
        } catch (e: Exception) {
            Response.error(
                400, // Could be any other code and text, because we are not using it
                ResponseBody.create(MediaType.parse("text/plain"), e.toString()))
        }
    }

    interface NewQuotationRetrofit {
        @GET("api/1.0/?method=getQuote&format=json")
        suspend fun getQuotation(@Query("lang") lenguaje: String): Response<QuotationDto>
    }
}