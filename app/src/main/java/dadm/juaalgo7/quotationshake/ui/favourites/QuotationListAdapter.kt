package dadm.juaalgo7.quotationshake.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dadm.juaalgo7.quotationshake.databinding.QuotationItemBinding
import dadm.juaalgo7.quotationshake.ui.model.Quotation

class QuotationListAdapter(private val itemclicked: ItemClicked): ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(QuotationDiff) {
        class ViewHolder (private val binding: QuotationItemBinding, itemclicked: ItemClicked): RecyclerView.ViewHolder(binding.root) {
            init {
                binding.root.setOnClickListener {
                    itemclicked.onClick(binding.tvFavAuthor.text.toString())
                }
            }

            fun bind(quotation: Quotation) {
                binding.tvFavQuotation.text = quotation.text;
                binding.tvFavAuthor.text = quotation.author;
            }
        }
    object
    QuotationDiff : DiffUtil.ItemCallback<Quotation>() {
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
          return oldItem.id == newItem.id;
        }

        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent,
            false), itemclicked);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position));
    }
    interface ItemClicked { fun onClick(author: String) }
}