package dadm.juaalgo7.quotationshake.ui.newquotation

import android.util.Log
import androidx.lifecycle.*
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesRepository
import dadm.juaalgo7.quotationshake.data.newquotation.NewQuotationManager
import dadm.juaalgo7.quotationshake.data.settings.SettingsRepository
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class NewQuotationViewModel @Inject constructor(private val NewQuotationManager: NewQuotationManager, settingsRepository: SettingsRepository, private val FavouritesRepository: FavouritesRepository) : ViewModel(){


    val userName: LiveData<String> = settingsRepository.getUsername().asLiveData();


    fun getUsername(): MutableLiveData<String> {
        return MutableLiveData(setOf("Alice", "Bob", "Charlie", "David", "Emma").random())
    }

    private val _Quatation = MutableLiveData<Quotation>();
    val Quotation: LiveData<Quotation>
        get() = _Quatation;

    private val _isRefreshing = MutableLiveData(false);
    val isRefreshing: LiveData<Boolean>
    get() = _isRefreshing;

    val isGreetingsVisible = Quotation.map { it.id.isEmpty()};


    val isAddToFavouritesVisible = Quotation.switchMap() { newQuotation ->
        FavouritesRepository.getQuotationById(newQuotation.id).asLiveData()
    }.map() { favourite ->
        favourite == null
    }


    private val _areError = MutableLiveData<Throwable?>()
    val areError: LiveData<Throwable?>
    get() = _areError;

    fun resetError() {
        _areError.value = null
    }
     fun getNewQuotation() {
         _isRefreshing.value = true
         viewModelScope.launch {
             NewQuotationManager.getNewQuotation()
                 .fold(
                     onSuccess = { _Quatation.value = it },
                     onFailure = { _areError.value = it }
                 )
         }

         _isRefreshing.value = false


     }
    fun addToFavourites() {
        (viewModelScope.launch{
            FavouritesRepository.addQuotation(Quotation.value!!)
        })

    }
}