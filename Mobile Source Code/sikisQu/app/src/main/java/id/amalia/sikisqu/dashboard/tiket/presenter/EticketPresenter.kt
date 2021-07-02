package id.amalia.sikisqu.dashboard.present

import id.amalia.sikisqu.dashboard.data.ResultTicket
import id.amalia.sikisqu.dashboard.presenter.EticketView
import id.amalia.sikisqu.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EticketPresenter(val ticketView: EticketView) {
    fun getTicket(idUser: String?){
        NetworkConfig.service()
            .getTicket(idUser)
            .enqueue(object : Callback<ResultTicket>{
                override fun onFailure(call: Call<ResultTicket>, t: Throwable) {
                    ticketView.onFailedlist(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultTicket>,
                    response: Response<ResultTicket>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        ticketView.onSuccessList(response.body()?.message,response.body()?.ticket)
                    }else{
                        ticketView.onFailedlist(response.body()?.message)
                    }
                }
            })
    }
}