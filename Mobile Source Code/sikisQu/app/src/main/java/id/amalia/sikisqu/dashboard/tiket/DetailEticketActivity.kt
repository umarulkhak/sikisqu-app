package id.amalia.sikisqu.dashboard.tiket

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.amalia.sikisqu.R
import id.amalia.sikisqu.dashboard.data.TicketItem
import kotlinx.android.synthetic.main.activity_detail_eticket.*

class DetailEticketActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_eticket)
        val intent = intent.getSerializableExtra("dataTicket") as TicketItem

        tvBookingInfo.text = intent.noBooking.toString()
        tvNameInfo.text = intent.namaPasien.toString()
        tvPhoneInfo.text = intent.noHp.toString()
        tvPeriksaInfo.text = intent.jenisPeriksa.toString()
        tvDokterInfo.text = intent.namaPsikolog.toString()
        tvWaktuInfo.text = "${intent.waktuPeriksa} 13:00 WIB"
    }
}
