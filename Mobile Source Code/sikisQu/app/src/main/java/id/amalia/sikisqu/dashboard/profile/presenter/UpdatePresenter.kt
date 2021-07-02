package id.amalia.sikisqu.dashboard.profile.presenter


import id.amalia.sikisqu.dashboard.profile.data.ResultUpdate
import id.amalia.sikisqu.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePresenter (val updateView: UpdateView) {

    fun updateUser(idUser : String? , nama : String? , hp : String?, alamat : String?, password : String?){
        NetworkConfig.service()
            .update(idUser ?: "", nama ?: "", hp ?: "", alamat ?: "", password ?: "")
            .enqueue(object : Callback<ResultUpdate>{
                override fun onFailure(call: Call<ResultUpdate>, t: Throwable) {
                    updateView.onFailedUpdate(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultUpdate>,
                    response: Response<ResultUpdate>
                ) {
                    if (response.isSuccessful && response.body()?.satus == 200){
                        updateView.onSuccessUpdate(response.body()?.message)
                    } else{
                        updateView.onFailedUpdate(response.body()?.message)
                    }
                }

            })
    }
}