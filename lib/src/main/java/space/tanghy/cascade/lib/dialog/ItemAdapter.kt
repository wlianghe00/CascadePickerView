package space.tanghy.cascade.lib.dialog

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.tanghy.cascade.pickerview.R

/**
 * ClassName: CascadeAdapter
 * Description:
 * @date: 2022/3/22 11:39 上午
 * @author: tanghy
 */
class ItemAdapter(var dataSet: MutableList<Item>, private val callback: (Item) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    var currentItem:SelectItem? = null

    class ItemHolder internal constructor(val cascadeView: ItemView) :
        RecyclerView.ViewHolder(cascadeView.view) {
        fun bind(item: Item) {
            cascadeView.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.tanghy_view_cascade_item_layout, parent, false)
        return ItemHolder(ItemView(view))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(dataSet[position])
        val cascadeView = holder.cascadeView
        cascadeView.view.setOnClickListener {
            if (currentItem != null) {
                currentItem!!.item.isCheck = false
                notifyItemChanged(currentItem!!.index)
            }
            currentItem = SelectItem(dataSet[position],position)
            currentItem!!.item.isCheck = true
            notifyItemChanged(position)
            callback.invoke(dataSet[position])
        }

        holder.cascadeView.checkClick(object : OnClickListener{
            override fun onClick(v: View?) {
                if (currentItem != null) {
                    currentItem!!.item.isCheck = false
                    notifyItemChanged(currentItem!!.index)
                }
                currentItem = SelectItem(dataSet[position],position)
                currentItem!!.item.isCheck = true
                currentItem!!.item.isChoose = true;
                notifyItemChanged(position)
                callback.invoke(dataSet[position])
            }
        })
    }

    override fun getItemCount() = dataSet.size


    data class SelectItem(
        var item:Item,
        var index:Int
    )


}