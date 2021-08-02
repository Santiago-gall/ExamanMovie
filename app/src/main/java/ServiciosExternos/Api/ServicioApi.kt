package ServiciosExternos.Api

import ServiciosExternos.ApiContracto.ServicioApiContracto
import ServiciosExternos.Constantes.ValoresApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServicioApi : ServicioApiContracto {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(ValoresApi.Url_Api)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    override fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}