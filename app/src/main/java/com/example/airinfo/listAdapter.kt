package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.airinfo.R
import com.example.airinfo.network.Repo
import kotlinx.android.synthetic.main.list_item.view.*

class listAdapter(private val repos: List<Repo>) : RecyclerView.Adapter<listAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageUrl:ImageView=itemView.repo_url
        val description:TextView=itemView.repo_desc
        val owner:TextView = itemView.repo_owner
        fun bind(repos: Repo) {
            description.text = repos.description
            owner.text = repos.owner.login
        }
    }

}
