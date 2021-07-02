package id.amalia.sikisqu.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.DashboardActivity
import id.amalia.sikisqu.login.LoginPageActivity
import id.amalia.utils.SessionManager
import org.jetbrains.anko.startActivity

class Splash : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val session = SessionManager(this)
        Handler().postDelayed(Runnable {
            if (session.isLogin) {
                startActivity<DashboardActivity>()
            } else {
                startActivity<LoginPageActivity>()
            }

            finish()
        }, 3000)
    }
}