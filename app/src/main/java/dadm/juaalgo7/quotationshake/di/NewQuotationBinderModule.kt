package dadm.juaalgo7.quotationshake.di

import dadm.juaalgo7.quotationshake.data.newquotation.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun provideNewQuotationManager(newQuotationManager: NewQuotationManagerImpl): NewQuotationManager
    @Binds
    abstract fun bindNewQuotationRepository(newQuotationRepository: NewQuotationRepositoryImpl): NewQuotationRepository
    @Binds
    abstract  fun bindNewQuotationDataSource(newQoutationDataSource: NewQuotationDataSourceImpl): NewQuotationDataSource
}