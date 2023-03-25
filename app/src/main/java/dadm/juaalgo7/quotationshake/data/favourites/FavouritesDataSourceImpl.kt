package dadm.juaalgo7.quotationshake.data.favourites

import dadm.juaalgo7.quotationshake.data.favourites.model.QuotationDto
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesDataSourceImpl  @Inject constructor(private val FavouritesDao: FavouritesDao): FavouritesDataSource {
    override suspend fun addQuotation(q: QuotationDto) {
        FavouritesDao.addQuotation(q)
    }

    override suspend fun deleteQuotation(q: QuotationDto) {
        FavouritesDao.deleteQuotation(q)
    }

    override fun getAllQuotations(): Flow<List<QuotationDto>> {
        return FavouritesDao.getAllQuotations()
    }

    override fun getQuotationById(id: String): Flow<QuotationDto?> {
        return FavouritesDao.getQuotationById(id)
    }


    override fun deleteAllQuotations() {
        FavouritesDao.deleteAllQuotations()
    }
}