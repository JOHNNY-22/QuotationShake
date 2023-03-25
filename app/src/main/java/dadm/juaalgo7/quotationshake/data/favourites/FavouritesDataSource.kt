package dadm.juaalgo7.quotationshake.data.favourites

import dadm.juaalgo7.quotationshake.data.favourites.model.QuotationDto
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun addQuotation(q: QuotationDto)
    suspend fun deleteQuotation(q: QuotationDto)
    fun getAllQuotations() : Flow<List<QuotationDto>>
    fun getQuotationById(id: String): Flow<QuotationDto?>
    fun deleteAllQuotations()
}