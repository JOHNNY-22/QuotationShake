package dadm.juaalgo7.quotationshake.ui.newquotation

import androidx.lifecycle.*
import dadm.juaalgo7.quotationshake.data.newquotation.NewQuotationRepository
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class NewQuotationViewModel @Inject constructor(private val NewQuotationRepository: NewQuotationRepository) : ViewModel(){

    private val _userName: MutableLiveData<String> = getUsername();
    val userName: LiveData<String>
        get() = _userName;

    fun getUsername(): MutableLiveData<String> {
        return MutableLiveData(setOf("Alice", "Bob", "Charlie", "David", "Emma").random())
    }

    private val _Quatation = MutableLiveData<Quotation>();
    val Quotation: LiveData<Quotation>
        get() = _Quatation;

    private val _isRefreshing = MutableLiveData(false);
    val isRefreshing: LiveData<Boolean>
    get() = _isRefreshing;

    val isGreetingsVisible = Quotation.map { it == null };

    private val _isButtonVisible = MutableLiveData(false);
    val isButtonVisible: LiveData<Boolean>
    get() = _isButtonVisible;

    private val _areError = MutableLiveData<Throwable?>()
    val areError: LiveData<Throwable?>
    get() = _areError;

    fun resetError() {
        _areError.value = null
    }
     fun getNewQuotation() {
         _isRefreshing.value = true
         viewModelScope.launch {
             NewQuotationRepository.getNewQuotation().fold(onSuccess = { _Quatation.value = it },onFailure = { _areError.value = it })
         }
         _isRefreshing.value = false
         _isButtonVisible.value = true

    }
    fun addToFavourites() {
        _isButtonVisible.value = false
    }
}