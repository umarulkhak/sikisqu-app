package id.amalia.sikisqu.dashboard.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import id.amalia.sikisqu.R
import id.amalia.sikisqu.login.LoginPageActivity
import id.amalia.utils.SessionManager
import kotlinx.android.synthetic.main.activity_profile.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_profile)
        sessionManager = SessionManager(this)

        btnUpdate.onClick{
            startActivity<EditProfileActivity>()
        }

        btnSignOut.onClick{
            startActivity<LoginPageActivity>()
            sessionManager.logout()
            finish()
        }


        getData()
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun getData(){
        sessionManager = SessionManager(this)
        if (sessionManager.isLogin){
            tvNameProfile.text = sessionManager.nama
            tvEmailProfile.text = sessionManager.email
            tvPhoneProfile.text = sessionManager.phone
            tvAddressProfile.text = sessionManager.alamat
        }
    }
}
