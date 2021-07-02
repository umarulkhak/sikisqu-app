package id.amalia.sikisqu.dashboard.psikolog.data

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResultPsikolog(

    @field:SerializedName("psikolog")
    val dokter: List<PsikologItem?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)