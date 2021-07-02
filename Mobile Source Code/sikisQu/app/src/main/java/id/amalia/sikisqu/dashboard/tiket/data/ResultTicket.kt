package id.amalia.sikisqu.dashboard.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultTicket(

	@field:SerializedName("ticket")
	val ticket: List<TicketItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)