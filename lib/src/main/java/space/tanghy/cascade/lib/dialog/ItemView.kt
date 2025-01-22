package space.tanghy.cascade.lib.dialog

import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import space.tanghy.cascade.pickerview.R

/**
 * ClassName: ItemView
 * Description:
 * @date: 2022/3/22 5:00 下午
 * @author: tanghy
 */
class ItemView(val view: View) {

    private val labelView: AppCompatTextView = view.findViewById(R.id.label)
    private val imageView: AppCompatImageView = view.findViewById(R.id.image)
    private val tvCheck: AppCompatTextView = view.findViewById(R.id.tv_check);
    var item: Item? = null

    fun bind(item: Item) {
        labelView.text = item.name
        this.item = item
        if (!item.isCheck) {
            imageView.visibility = View.INVISIBLE
        } else {
            imageView.visibility = View.VISIBLE
        }
    }

    fun checkClick(listener: OnClickListener) {
        tvCheck.setOnClickListener(listener)
    }

}