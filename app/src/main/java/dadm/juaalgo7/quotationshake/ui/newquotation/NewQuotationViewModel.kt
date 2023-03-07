package dadm.juaalgo7.quotationshake.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dadm.juaalgo7.quotationshake.ui.model.Quotation

class   NewQuotationViewModel : ViewModel() {
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

    val isGreetingsVisible = Transformations.map(Quotation) { it == null };

    private val _isButtonVisible = MutableLiveData(false);
    val isButtonVisible: LiveData<Boolean>
    get() = _isButtonVisible;


    fun getNewQuotation() {
        _isRefreshing.value = true
        val num = (0..99).random().toString()
        _Quatation.value = Quotation(num, "Quotation text #$num", "Author #$num");
        _isRefreshing.value = false
        _isButtonVisible.value = true
    }
    fun addToFavourites() {
        _isButtonVisible.value = false
    }
}