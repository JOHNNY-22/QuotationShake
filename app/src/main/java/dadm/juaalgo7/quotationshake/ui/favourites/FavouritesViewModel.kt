package dadm.juaalgo7.quotationshake.ui.favourites

import androidx.lifecycle.*
import dadm.juaalgo7.quotationshake.data.favourites.FavouritesRepository
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val FavouritesRepository: FavouritesRepository) : ViewModel()  {

    val favQuotations: LiveData<List<Quotation>> = FavouritesRepository.getAllQuotations().asLiveData()

    val isDeleteAllVisible = favQuotations.map { it.isNotEmpty() }



    fun deleteAllQuotations(){
        (viewModelScope.launch{
            FavouritesRepository.deleteAllQuotations()
        })
    }
    fun deleteQuotationAtPosition(position: Int) {
        (viewModelScope.launch{
            FavouritesRepository.deleteQuotation(favQuotations.value!![position])
        })
        }

    }
