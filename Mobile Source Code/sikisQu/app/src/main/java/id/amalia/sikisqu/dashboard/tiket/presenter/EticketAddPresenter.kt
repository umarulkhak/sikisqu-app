package id.amalia.sikisqu.dashboard.present


import id.amalia.sikisqu.dashboard.data.ResultAddTicket
import id.amalia.sikisqu.dashboard.presenter.EticketView
import id.amalia.sikisqu.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EticketAddPresenter (val eticketView: EticketView) {
    fun addTicket(nobooking : String?, orderticket : String?,
                  namapasien : String?, nohp : String?,
                  jenisperiksa : String?, namadokter : String?){
        NetworkConfig.service()
            .newTicket(nobooking,orderticket,namapasien,nohp,jenisperiksa,namadokter)
            .enqueue(object : Callback<ResultAddTicket>{
                override fun onFailure(call: Call<ResultAddTicket>, t: Throwable) {
                    eticketView.onFailedAdd(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultAddTicket>,
                    response: Response<ResultAddTicket>
                ) {
                    if (response.isSuccessful && response.body()?.status ==200){
                        eticketView.onSuccessAdd(response.body()?.message)
                    }else{
                        eticketView.onSuccessAdd(response.body()?.message)
                    }
                }

            })

    }
}