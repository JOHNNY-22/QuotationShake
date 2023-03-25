package dadm.juaalgo7.quotationshake.di

import android.content.Context
import androidx.room.Room
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesContract
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesDao
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FavouritesProviderModule {
    @Provides
    @Singleton
    fun provideFavouritesDatabase(@ApplicationContext context: Context): FavouritesDatabase {
        return Room.databaseBuilder(context, (FavouritesDatabase::class.java) , FavouritesContract.database).build()
    }
    @Provides
    fun provideFavouritesDao(FavouritesDatabase: FavouritesDatabase): FavouritesDao {
        return FavouritesDatabase.favouritesDao()
    }
}