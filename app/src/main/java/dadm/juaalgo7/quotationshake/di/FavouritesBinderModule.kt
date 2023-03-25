package dadm.juaalgo7.quotationshake.di

import dadm.juaalgo7.quotationshake.data.favourites.FavouritesDataSource
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesDataSourceImpl
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesRepository
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {
    @Binds
 abstract fun bindFavouritesDataSource(FavouritesDataSourceImpl: FavouritesDataSourceImpl): FavouritesDataSource
    @Binds
 abstract fun bindFavouritesRepository(FavouriteRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository
}