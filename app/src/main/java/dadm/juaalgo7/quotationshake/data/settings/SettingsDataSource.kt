package dadm.juaalgo7.quotationshake.data.settings

import kotlinx.coroutines.flow.Flow


interface SettingsDataSource {
    fun getUsername(): Flow<String>

    fun getLanguage() :Flow<String>
}