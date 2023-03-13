package dadm.juaalgo7.quotationshake.data.newquotation

import dadm.juaalgo7.quotationshake.data.newquotation.model.QuotationDto
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import retrofit2.Response

interface NewQuotationRepository {
    suspend fun getNewQuotation(): Result<Quotation>
}