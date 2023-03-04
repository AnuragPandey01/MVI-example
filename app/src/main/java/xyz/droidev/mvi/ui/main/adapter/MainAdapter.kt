package xyz.droidev.mvi.ui.main.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xyz.droidev.mvi.R
import xyz.droidev.mvi.data.model.User

class MainAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUserName : TextView = itemView.findViewById(R.id.textViewUserName)
        val textViewUserEmail : TextView = itemView.findViewById(R.id.textViewUserEmail)
        val imageViewAvatar : ImageView = itemView.findViewById(R.id.imageViewAvatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val user = users[position]
        holder.textViewUserName.text = user.name
        holder.textViewUserEmail.text = user.email
        Glide.with(holder.imageViewAvatar.context)
            .load(user.avatar)
            .into(holder.imageViewAvatar)
    }


    fun addData(list: List<User>) {
        users.addAll(list)
    }

}