package id.amalia.sikisqu.login

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import id.amalia.sikisqu.MainActivity
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.DashboardActivity
import id.amalia.sikisqu.login.data.User
import id.amalia.sikisqu.login.presenter.LoginPresenter
import id.amalia.sikisqu.login.presenter.LoginView
import id.amalia.sikisqu.register.RegisterActivity
import id.amalia.utils.SessionManager
import kotlinx.android.synthetic.main.layout_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity


class LoginPageActivity : AppCompatActivity(), LoginView {


    private lateinit var presenter : LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        manualRegister.onClick {
            startActivity<RegisterActivity>()
        }

        presenter = LoginPresenter(this)


        cirLoginButton.onClick {
            val email = editTextEmail.text.toString()
            val nohp = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            presenter.loginUser(email, password , nohp)

        }
    }

    override fun onSuccessLogin(user: User?, msg: String?) {
        val sesi = SessionManager(this)
        sesi.createLoginSession("")
        sesi.email = user?.userEmail
        sesi.nama = user?.userNama
        sesi.phone = user?.userHp
        sesi.alamat = user?.userAlamat
        sesi.id = user?.userId
        startActivity<DashboardActivity>()
        finish()

    }

    override fun onErrorLogin(msg: String?) {
        alert {
            title = "Informasi Login"
            message = msg ?: "Email/NoHp atau Password Salah"
        }.show()
    }
}
