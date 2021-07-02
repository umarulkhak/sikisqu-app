package id.amalia.sikisqu.dashboard.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class TicketItem(

	@field:SerializedName("order_ticket")
	val orderTicket: String? = null,

	@field:SerializedName("nama_pasien")
	val namaPasien: String? = null,

	@field:SerializedName("no_hp")
	val noHp: String? = null,

	@field:SerializedName("status_bayar")
	val statusBayar: String? = null,

	@field:SerializedName("waktu_periksa")
	val waktuPeriksa: String? = null,

	@field:SerializedName("jenis_periksa")
	val jenisPeriksa: String? = null,

	@field:SerializedName("nama_psikolog")
	val namaPsikolog: String? = null,

	@field:SerializedName("no_booking")
	val noBooking: String? = null,

	@field:SerializedName("id_ticket")
	val idTicket: String? = null
) : Serializable