package id.amalia.sikisqu.login.presenter

import id.amalia.sikisqu.login.data.User


interface LoginView {
    fun onSuccessLogin (user : User?, msg: String?)
    fun onErrorLogin (msg: String?)
}