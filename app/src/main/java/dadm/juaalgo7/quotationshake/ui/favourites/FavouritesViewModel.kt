package dadm.juaalgo7.quotationshake.ui.favourites

import androidx.lifecycle.*
import dadm.juaalgo7.quotationshake.ui.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor() : ViewModel()  {
    private val _favQuotations = MutableLiveData<List<Quotation>>(getfavoriteQuotations())
    val favQuotations: LiveData<List<Quotation>>
        get() = _favQuotations

    val isDeleteAllVisible = favQuotations.map { it.isNotEmpty() }

    private fun  getfavoriteQuotations(): List<Quotation>? {
        val listFavs: List<Quotation> =  (0..20 ).map {
            val num = (0..99).random().toString()
            Quotation(num, "Quotation text #$num", "Author #$num")
        }
        listFavs.toMutableList().add(Quotation("21", "La imaginación es lo mas importante del conocimiento", "Eistein"))
        listFavs.toMutableList().add(Quotation("22", "La ceramica de Talavera no es cosa menor si no que es cosa mayor", "Anonymus"))
        return listFavs;
    }

    fun deleteAllQuotations(){
        _favQuotations.value = emptyList()
    }
    fun deleteQuotationAtPosition(position: Int) {
            val list = _favQuotations.value?.toMutableList()
            list?.removeAt(position)
            _favQuotations.value= list ?: emptyList()

        }

    }
