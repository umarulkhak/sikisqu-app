package id.amalia.sikisqu.dashboard.psikolog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.Window.*
import android.view.WindowManager
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.psikolog.adapter.PsikologAdapter
import id.amalia.sikisqu.dashboard.psikolog.data.PsikologItem
import id.amalia.sikisqu.dashboard.psikolog.presenter.PsikologPresenter
import id.amalia.sikisqu.dashboard.psikolog.presenter.PsikologView
import kotlinx.android.synthetic.main.activity_jadwal_psikolog.*

class JadwalPsikologActivity : AppCompatActivity(), PsikologView {
    private lateinit var psikologPresenter: PsikologPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_psikolog)
        psikologPresenter = PsikologPresenter(this)
        psikologPresenter.getPsikolog()
    }
    override fun onSuccess(msg: String?, data: List<PsikologItem?>?) {
        Log.d("Success Load Data", msg.toString())
        rvJadwalDokter.adapter = PsikologAdapter(data)
    }

    override fun onFailed(msg: String?) {
        Log.d("Success Load Data", msg.toString())
    }
}