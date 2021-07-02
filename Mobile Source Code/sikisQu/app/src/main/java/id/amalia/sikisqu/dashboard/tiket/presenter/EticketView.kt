package id.amalia.sikisqu.dashboard.presenter

import id.amalia.sikisqu.dashboard.data.TicketItem


interface EticketView {
    fun onSuccessList (msg : String?, data : List<TicketItem?>?)
    fun onFailedlist (msg: String?)
    fun onSuccessAdd (msg: String?)
    fun onFailedAdd (msg: String?)
}