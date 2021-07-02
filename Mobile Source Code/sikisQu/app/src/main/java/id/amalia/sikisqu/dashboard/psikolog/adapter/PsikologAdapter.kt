package id.amalia.sikisqu.dashboard.psikolog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.psikolog.data.PsikologItem
import kotlinx.android.synthetic.main.item_jadwal.view.*

class PsikologAdapter (val data : List<PsikologItem?>?) : RecyclerView.Adapter<PsikologAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jadwal,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: PsikologItem?) {
            itemView.itemNamaDokter.text = get?.namaPsikolog
            itemView.itemSpesialis.text = get?.spesialisPsikolog
            itemView.itemWaktuDokter.text = get?.waktuPsikolog
        }

    }
}