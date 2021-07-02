package id.amalia.sikisqu.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat.startActivity
import id.amalia.sikisqu.MainActivity
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.DashboardActivity
import id.amalia.sikisqu.login.LoginPageActivity
import id.amalia.sikisqu.register.presenter.RegisterPresenter
import id.amalia.sikisqu.register.presenter.RegisterView
import kotlinx.android.synthetic.main.layout_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class RegisterActivity : AppCompatActivity(), RegisterView {


    private lateinit var presenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        presenter = RegisterPresenter(this)
        manualLogin.onClick {
            startActivity<LoginPageActivity>()

        }
        regPassword.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (regPassword.length() <= 6){
                    regPassword.setError("Password Harus Lebih Dari 6 Karakter!")
                }
            }
        })

        btnRegister.onClick {

            val nama = regName.text.toString()
            val email = regEmail.text.toString()
            val nohp = regPhone.text.toString()
            val password = regPassword.text.toString()
            presenter.registerUser(nama, email, nohp, password)

        }
    }

    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = "Successfully To Register"
        }.show()
        startActivity<DashboardActivity>()
        finish()
    }

    override fun onErrorRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = "Failed To Reggister"
        }.show()
    }
}
