package id.amalia.sikisqu.login.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class User(

	@field:SerializedName("user_alamat")
	val userAlamat: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_hp")
	val userHp: String? = null,

	@field:SerializedName("user_level")
	val userLevel: String? = null,

	@field:SerializedName("id_user")
	val userId: String? = null
):Serializable