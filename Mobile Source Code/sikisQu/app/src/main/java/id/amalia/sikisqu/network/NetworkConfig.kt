package id.amalia.sikisqu.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun getInterceptor():OkHttpClient {
        val interceptor  = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
                .build()
    }

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
                .baseUrl("http://192.168.1.28/sikisqu_server/index.php/Api/")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    fun service() = getRetrofit().create(SikisquService::class.java)
}