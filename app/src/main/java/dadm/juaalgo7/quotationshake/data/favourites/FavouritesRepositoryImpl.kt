package dadm.juaalgo7.quotationshake.data.favourites

import dadm.juaalgo7.quotationshake.data.favourites.model.QuotationDto
import dadm.juaalgo7.quotationshake.data.favourites.model.toDomain
import dadm.juaalgo7.quotationshake.data.favourites.model.toDto
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(private val favoritesDataSource: FavouritesDataSource): FavouritesRepository {
    override suspend fun addQuotation(q: Quotation) {
        favoritesDataSource.addQuotation(q.toDto())
    }

    override suspend fun deleteQuotation(q: Quotation) {
        favoritesDataSource.deleteQuotation(q.toDto())
    }

    override fun getAllQuotations(): Flow<List<Quotation>> {
        return favoritesDataSource.getAllQuotations().map  { it ->
            it.map {it -> it.toDomain()}
        }
        }


    override fun getQuotationById(id: String): Flow<Quotation?> {
        return favoritesDataSource.getQuotationById(id).map { it?.toDomain() }
    }

    override fun deleteAllQuotations() {
        favoritesDataSource.deleteAllQuotations()
    }
}