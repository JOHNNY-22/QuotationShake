package dadm.juaalgo7.quotationshake.data.newquotation

import dadm.juaalgo7.quotationshake.ui.model.Quotation

interface NewQuotationManager {
    suspend fun getNewQuotation(): Result<Quotation>;
}