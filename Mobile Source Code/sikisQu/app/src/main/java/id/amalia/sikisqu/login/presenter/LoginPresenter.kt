package id.amalia.sikisqu.login.presenter

import id.amalia.sikisqu.login.data.ResultLogin
import id.amalia.sikisqu.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresenter(val loginView: LoginView) {

    fun loginUser(email: String?, password: String?,nohp: String?) {
        NetworkConfig.service()
            .login(email ?: "",nohp ?: "",password ?: "" )
            .enqueue(object : Callback<ResultLogin> {
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    if (response.body()?.status == 200 && response.isSuccessful) {
                        if (email!!.isNotEmpty() or nohp!!.isNotEmpty()) {
                            loginView.onSuccessLogin(
                                response.body()?.user,
                                response.body()?.message
                            )
                        } else {
                            loginView.onErrorLogin(response.body()?.message)
                        }

                    } else {
                        loginView.onErrorLogin(response.body()?.message)
                    }

                }

            })
    }
}

