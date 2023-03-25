package dadm.juaalgo7.quotationshake.data.newquotation

import dadm.juaalgo7.quotationshake.data.settings.SettingsRepository
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewQuotationManagerImpl @Inject constructor(private val SettingsRepository: SettingsRepository, private val NewQuotationRepository: NewQuotationRepository): NewQuotationManager {
    private lateinit var language: String
    init {
        CoroutineScope(SupervisorJob()).launch {
            SettingsRepository.getLanguage().collect { languageCode ->
                language = languageCode
            }
        }
    }

    override suspend fun getNewQuotation(): Result<Quotation> {
        return NewQuotationRepository.getNewQuotation(language)
    }
}