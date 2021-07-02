package id.amalia.sikisqu.dashboard.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.profile.presenter.UpdatePresenter
import id.amalia.sikisqu.dashboard.profile.presenter.UpdateView
import id.amalia.utils.SessionManager
import kotlinx.android.synthetic.main.activity_edit_profile.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick

class EditProfileActivity : AppCompatActivity(), UpdateView {

    private lateinit var sessionManager: SessionManager
    private lateinit var presenter: UpdatePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_edit_profile)

        sessionManager = SessionManager(this)
        if (sessionManager.isLogin) {
            etProfileName.setText(sessionManager.nama)
            etProfileAlamat.setText(sessionManager.alamat)
            etProfilePhone.setText(sessionManager.phone)
        }

        presenter = UpdatePresenter(this)
        btnProfileUpdate.onClick {

            val name = etProfileName.text.toString()
            val alamat = etProfileAlamat.text.toString()
            val phone = etProfilePhone.text.toString()
            val password = etProfilePassword.text.toString()
            presenter.updateUser(sessionManager.id,name,phone,alamat,password)
            newBuild(name,alamat,password,phone)
        }
    }

    private fun newBuild(name : String?, alamat : String?, password : String? , phone : String?) {
        val sesi = SessionManager(this)
        sesi.createLoginSession("")
        sesi.nama = name
        sesi.phone = phone
        sesi.alamat = alamat
    }

    override fun onSuccessUpdate(msg: String?) {
        alert {
            title = "Success Update"
        }.show()
        finish()
    }

    override fun onFailedUpdate(msg: String?) {
    }
}