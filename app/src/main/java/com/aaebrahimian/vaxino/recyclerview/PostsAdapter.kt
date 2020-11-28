package com.aaebrahimian.vaxino.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.model.Clinic
import kotlinx.android.synthetic.main.item_1.view.*


class PostsAdapter(context: Context, private val dataSet: ArrayList<Clinic>) :
        RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle : TextView = itemView.txt_Title
        val textBody : TextView = itemView.txt_Body
        val imgItem : ImageView = itemView.img_Item

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_1, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val model : Clinic = dataSet[position]

        viewHolder.textTitle.text = model.title
        viewHolder.textBody.text = model.body

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}