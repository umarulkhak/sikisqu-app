package id.amalia.sikisqu.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.profile.ProfileActivity
import id.amalia.sikisqu.dashboard.psikolog.JadwalPsikologActivity
import id.amalia.sikisqu.dashboard.tiket.EticketActivity
import id.amalia.utils.SessionManager
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class DashboardActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        sessionManager = SessionManager(this)
        getDataName()

        jadwal.onClick {
            startActivity<JadwalPsikologActivity>()
        }
        eticket.onClick {
            startActivity<EticketActivity>()
        }

        btnProfile.onClick{
            startActivity<ProfileActivity>()
        }

    }

    override fun onResume() {
        super.onResume()
        getDataName()
    }

    private fun getDataName() {
        sessionManager = SessionManager(this)
        if (sessionManager.isLogin){
            tvNameHome.text = sessionManager.nama
        }
    }
}
