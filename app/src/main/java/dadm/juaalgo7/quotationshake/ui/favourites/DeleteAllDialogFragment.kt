package dadm.juaalgo7.quotationshake.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DeleteAllDialogFragment(val delete :DeleteInterface): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Delete all favourites")
            .setMessage("Are you sure you want to delete all favourites?")
            .setPositiveButton("Delete") { _, _ ->
                delete.positiveButton()
            }
            .setNegativeButton("Cancel") { _, _ ->
                delete.negativeButton()
            }
            .create()
    }
    interface DeleteInterface {
        fun positiveButton()
        fun negativeButton()
    }
}