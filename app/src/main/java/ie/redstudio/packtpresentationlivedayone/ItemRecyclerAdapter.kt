package ie.redstudio.packtpresentationlivedayone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ie.redstudio.packtpresentationlivedayone.data.ItemEntity
import timber.log.Timber

/**
 * Created by Łukasz on 18/01/2019.
 */
class ItemRecyclerAdapter : RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
    }

    private var mList: List<ItemEntity> = ArrayList()

    fun setData(list: List<ItemEntity>) {
        mList = list
        Timber.i("setData: {$mList}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: ItemEntity = mList[position]

        if (!item.name.isNullOrBlank()) {
            holder.tvName.text = item.name
        } else {
            holder.tvName.text = "blank"
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}