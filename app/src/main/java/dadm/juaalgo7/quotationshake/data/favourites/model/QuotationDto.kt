package dadm.juaalgo7.quotationshake.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesContract

@Entity (FavouritesContract.Table.table)
class QuotationDto(@PrimaryKey  @ColumnInfo(name = FavouritesContract.Table.identifier) val identifier: String, @ColumnInfo(name = FavouritesContract.Table.text) val text: String, @ColumnInfo(name = FavouritesContract.Table.author)val author: String) {


}