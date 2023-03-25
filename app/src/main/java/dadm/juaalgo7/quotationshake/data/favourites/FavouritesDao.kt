package dadm.juaalgo7.quotationshake.data.favourites

import androidx.room.*
import dadm.juaalgo7.quotationshake.data.favourites.model.QuotationDto
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotation(q: QuotationDto)

    @Delete
    suspend fun deleteQuotation(q: QuotationDto)

    @Query("SELECT * FROM ${FavouritesContract.Table.table}")
    fun getAllQuotations() : Flow<List<QuotationDto>>

    @Query("SELECT * FROM ${FavouritesContract.Table.table} WHERE ${FavouritesContract.Table.identifier} = :id")
    fun getQuotationById(id: String): Flow<QuotationDto?>

    @Query("DELETE FROM ${FavouritesContract.Table.table}")
    fun deleteAllQuotations()

}