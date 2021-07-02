package id.amalia.sikisqu.dashboard.psikolog.presenter

import id.amalia.sikisqu.dashboard.psikolog.data.ResultPsikolog
import id.amalia.sikisqu.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PsikologPresenter (val psikologView: PsikologView){

    fun getPsikolog(){
        NetworkConfig.service()
            .getPsikolog()
            .enqueue(object : Callback<ResultPsikolog> {
                override fun onFailure(call: Call<ResultPsikolog>, t: Throwable) {
                    psikologView.onFailed(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultPsikolog>,
                    response: Response<ResultPsikolog>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        psikologView.onSuccess(response.body()?.message,response.body()?.dokter)
                    }else {
                        psikologView.onFailed(response.body()?.message)
                    }
                }

            })
    }
}