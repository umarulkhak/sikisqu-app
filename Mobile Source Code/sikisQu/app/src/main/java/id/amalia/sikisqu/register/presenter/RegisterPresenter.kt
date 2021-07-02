package id.amalia.sikisqu.register.presenter

import id.amalia.sikisqu.network.NetworkConfig
import id.amalia.sikisqu.register.data.ResultRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter (val registerView: RegisterView) {

    fun registerUser(nama : String?, email : String?, nohp : String?, password : String?){
        NetworkConfig.service()
                .register(nama ?: "",email ?: "",nohp ?: "",password ?: "")
                .enqueue(object : Callback<ResultRegister> {
                    override fun onFailure(call: Call<ResultRegister>, t: Throwable) {
                        registerView.onErrorRegister(t.localizedMessage)
                    }

                    override fun onResponse(
                            call: Call<ResultRegister>,
                            response: Response<ResultRegister>
                    ) {
                        if (response.body()?.status == 200){
                            registerView.onSuccessRegister(response.body()?.message)
                        } else{
                            registerView.onErrorRegister(response.body()?.message)
                        }
                    }

                })
    }
}