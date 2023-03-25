package dadm.juaalgo7.quotationshake.data.settings

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsDataSourceImpl @Inject constructor(private val shared: SharedPreferences): SettingsDataSource {

    val preference = "EditTextPreference"
    val listpreference ="ListPreference"

    private fun getUsernamePreference() =shared.getString(preference, "") ?: ""

    override fun getUsername(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (preference == key) {
                    trySend(getUsernamePreference())
                }
            }
        }
        shared.registerOnSharedPreferenceChangeListener(listener)
        trySend(getUsernamePreference())
        awaitClose {
            shared.unregisterOnSharedPreferenceChangeListener(listener) }
    }.flowOn(Dispatchers.IO)

    override fun getLanguage(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (listpreference == key) {
                    trySend(getUsernamePreference())
                }
            }
        }
        shared.registerOnSharedPreferenceChangeListener(listener)
        trySend(getUsernamePreference())
        awaitClose {
            shared.unregisterOnSharedPreferenceChangeListener(listener) }
    }.flowOn(Dispatchers.IO)
}