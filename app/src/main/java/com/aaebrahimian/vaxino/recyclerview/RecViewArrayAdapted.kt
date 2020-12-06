package com.aaebrahimian.vaxino.recyclerview


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.activitycodes.InformationClinicActivity
import com.aaebrahimian.vaxino.model.Clinic


class RecViewArrayAdapted(var context: Context,private val dataSet: ArrayList<Clinic>) :
        RecyclerView.Adapter<RecViewArrayAdapted.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgItem : ImageView = view.findViewById(R.id.img_Item)
        val textTitle : TextView = view.findViewById(R.id.txt_Title)
        val textBody : TextView = view.findViewById(R.id.txt_Body)


        init {

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

        viewHolder.imgItem.setImageResource(dataSet[position].image)
        viewHolder.textTitle.text = dataSet[position].title
        viewHolder.textBody.text  = dataSet[position].body


        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, InformationClinicActivity::class.java)
            intent.putExtra("key_1",dataSet[position])
            startActivity( context, intent, null)
        }
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}