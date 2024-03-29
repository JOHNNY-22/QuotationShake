package dadm.juaalgo7.quotationshake.data.newquotation.model

import dadm.juaalgo7.quotationshake.ui.model.Quotation
import okio.IOException
import retrofit2.Response

fun QuotationDto.toDomain() =
    Quotation(id = quoteLink, text = quoteText, author = quoteAuthor)

fun Response<QuotationDto>.toDomain() =
    if (isSuccessful) Result.success((body() as QuotationDto).toDomain())
    else Result.failure(IOException())
