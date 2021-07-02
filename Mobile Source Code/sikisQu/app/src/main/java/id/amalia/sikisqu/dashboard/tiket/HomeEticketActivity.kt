package id.amalia.sikisqu.dashboard.tiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.data.TicketItem
import id.amalia.sikisqu.dashboard.present.EticketPresenter
import id.amalia.sikisqu.dashboard.presenter.EticketView
import id.amalia.sikisqu.dashboard.tiket.adapter.EticketAdapter
import id.amalia.utils.SessionManager
import kotlinx.android.synthetic.main.activity_home_eticket.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class HomeEticketActivity : AppCompatActivity(), EticketView {

    private lateinit var sessionManager: SessionManager
    private lateinit var presenter : EticketPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_eticket)
        sessionManager = SessionManager(this)
        getData()
        btnAddTicket.onClick {
            startActivity<EticketActivity>()
            finish()
        }
    }
    override fun onSuccessList(msg: String?, data: List<TicketItem?>?) {
        rvTicket.adapter = EticketAdapter(data, object : EticketAdapter.onItemClickTicket{
            override fun item(item: TicketItem?) {
                alert {
                    title = "informasi pembayaran"
                    message = "Ticket Berhasil Dipesan"
                    yesButton {
                        startActivity<DetailEticketActivity>("dataTicket" to item)
                        finish()
                    }
                    noButton {  }
                }.show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getData()
    }
    fun getData(){
        sessionManager = SessionManager(this)
        presenter = EticketPresenter(this)
        if (sessionManager.isLogin){
            presenter.getTicket(sessionManager.id)
        }
    }

    override fun onFailedlist(msg: String?) {
        toast(msg.toString()).show()
    }

    override fun onSuccessAdd(msg: String?) {}

    override fun onFailedAdd(msg: String?) {}
}