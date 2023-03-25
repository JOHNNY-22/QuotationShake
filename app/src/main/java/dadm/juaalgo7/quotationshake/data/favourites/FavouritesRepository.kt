package dadm.juaalgo7.quotationshake.data.favourites

import dadm.juaalgo7.quotationshake.data.favourites.model.QuotationDto
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    suspend fun addQuotation(q: Quotation)
    suspend fun deleteQuotation(q: Quotation)
    fun getAllQuotations() : Flow<List<Quotation>>
    fun getQuotationById(id: String): Flow<Quotation?>
    fun deleteAllQuotations()
}