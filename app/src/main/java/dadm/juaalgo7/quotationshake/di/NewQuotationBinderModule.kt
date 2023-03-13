package dadm.juaalgo7.quotationshake.di

import dadm.juaalgo7.quotationshake.data.newquotation.NewQuotationDataSource
import dadm.juaalgo7.quotationshake.data.newquotation.NewQuotationDataSourceImpl
import dadm.juaalgo7.quotationshake.data.newquotation.NewQuotationRepository
import dadm.juaalgo7.quotationshake.data.newquotation.NewQuotationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(newQuotationRepository: NewQuotationRepositoryImpl): NewQuotationRepository
    @Binds
    abstract  fun bindNewQuotationDataSource(newQoutationDataSource: NewQuotationDataSourceImpl): NewQuotationDataSource
}