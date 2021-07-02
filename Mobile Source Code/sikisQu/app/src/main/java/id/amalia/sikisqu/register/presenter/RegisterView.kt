package id.amalia.sikisqu.register.presenter

interface RegisterView {
    fun onSuccessRegister (msg: String?)
    fun onErrorRegister (msg: String?)
}