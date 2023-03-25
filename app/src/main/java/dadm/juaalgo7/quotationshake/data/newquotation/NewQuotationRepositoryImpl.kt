package dadm.juaalgo7.quotationshake.data.newquotation


import dadm.juaalgo7.quotationshake.data.newquotation.model.toDomain
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import dadm.juaalgo7.quotationshake.utils.NoInternetException
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(private val DataSource: NewQuotationDataSourceImpl, private var Conectivy: ConnectivityChecker) : NewQuotationRepository {

    override suspend fun getNewQuotation(): Result<Quotation> {
        return if (Conectivy.isConnectionAvailable()) {
           val xxx =  DataSource.getQuotation(arrayOf("en", "ru", "xx").random())
            xxx.toDomain()
        } else {
            Result.failure(exception = NoInternetException())
        }
    }

}