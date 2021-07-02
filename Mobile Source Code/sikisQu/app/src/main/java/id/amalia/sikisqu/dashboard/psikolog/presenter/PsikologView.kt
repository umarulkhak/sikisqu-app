package id.amalia.sikisqu.dashboard.psikolog.presenter

import id.amalia.sikisqu.dashboard.psikolog.data.PsikologItem

interface PsikologView {
    fun onSuccess (msg : String?, data : List<PsikologItem?>?)
    fun onFailed (msg : String?)
}