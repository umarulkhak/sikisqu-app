package id.amalia.sikisqu.dashboard.tiket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.data.TicketItem
import kotlinx.android.synthetic.main.item_ticket.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class EticketAdapter (val data: List<TicketItem?>?, val onClicked : onItemClickTicket) : RecyclerView.Adapter<EticketAdapter.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket,parent, false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.btnBayarTicket.onClick {
            onClicked.item(data?.get(position))
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: TicketItem?) {
            itemView.tvTicketName.text = get?.namaPasien
            itemView.tvTicketPhone.text = get?.noHp
            itemView.tvNoBooking.text = get?.noBooking
        }
    }

    interface onItemClickTicket{
        fun item(item : TicketItem?)
    }
}