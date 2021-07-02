package id.amalia.sikisqu.network

import id.amalia.sikisqu.dashboard.data.ResultAddTicket
import id.amalia.sikisqu.dashboard.data.ResultTicket
import id.amalia.sikisqu.dashboard.profile.data.ResultUpdate
import id.amalia.sikisqu.dashboard.psikolog.data.ResultPsikolog
import id.amalia.sikisqu.login.data.ResultLogin
import id.amalia.sikisqu.register.data.ResultRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface SikisquService {

    @FormUrlEncoded
    @POST("getTicket")
    fun getTicket(@Field("orderticket") idUser: String?) : Call<ResultTicket>


    @FormUrlEncoded
    @POST("newTicket")
    fun newTicket(@Field("nobooking") nobooking: String?,
                  @Field("orderticket") orderticker: String?,
                  @Field("namapasien") namapasien: String?,
                  @Field("nohp") nohp: String?,
                  @Field("jenisperiksa") jenisperiksa: String?,
                  @Field("namapsikolog") namapsikolog: String?) : Call<ResultAddTicket>

    @FormUrlEncoded
    @POST("updateUser")
    fun update(@Field("idUser") idUser : String?,
               @Field("nama") nama : String?,
               @Field("hp") hp : String?,
               @Field("alamat") alamat : String?,
               @Field("password") password : String?) : Call<ResultUpdate>

    //Login Service
    @FormUrlEncoded
    @POST("loginUser")
    fun login (@Field("email") email : String,
               @Field("nohp") nohp : String,
               @Field("password") password : String) : Call<ResultLogin>

    //Register Service
    @FormUrlEncoded
    @POST("registerUser")
    fun register(@Field("nama") nama : String,
                 @Field("email") email : String,
                 @Field("nohp") nohp : String,
                 @Field("password") password : String) : Call<ResultRegister>

    @GET("getPsikolog")
    fun getPsikolog(): Call<ResultPsikolog>

}