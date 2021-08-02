package ui.Detalle.DatosExternos.ServiciosApi

import ServiciosExternos.Api.ServicioApi
import ServiciosExternos.ApiContracto.ServicioApiContracto
import ServiciosExternos.Constantes.ValoresApi
import ServiciosExternos.EntidadGral.Items
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ui.Detalle.Contractos.DetalleContract
import ui.Detalle.DatosExternos.ServiciosApiContracto.MetodosApi
import ui.Detalle.Entidad.Videos
import java.util.*

class ApiServicios(var output: DetalleContract.OutPutInteractor) : DetalleContract.ApiServicioContract {
    private var ConsultaServicio: ServicioApiContracto? = ServicioApi()

    override fun getServiceVideos(key: String) {
        val request = ConsultaServicio?.buildService(MetodosApi :: class.java)
        val lenguaje = Locale.getDefault().toString()
        val url = "${ValoresApi.Url_Api}${ValoresApi.UrlVideo}${key}${ValoresApi.Video}${ValoresApi.Key}=${ValoresApi.keyValue}&${ValoresApi.Language}=${lenguaje}"
        request?.getVideoKey(url)!!.enqueue(
            object : Callback<Items<Videos>> {
                override fun onResponse(call: Call<Items<Videos>>, response: Response<Items<Videos>>) {
                    val Resp = response.body()
                    val err = response.errorBody()


                    if(response.isSuccessful)
                    {
                        if (Resp != null) {
                            output?.getServiceSuccesVideos(Resp.itemsMovies.first())
                        }
                        else
                        {
                            output?.getServiceMessageError(ValoresApi.MensajeError)
                        }
                    }
                    else
                    {
                        if(err != null) {
                            val errors = JSONObject(err!!.string())
                            val mensaje = errors.getString(ValoresApi.ErrorServicio)
                            output?.getServiceMessageError(mensaje)
                        }
                        else{
                            output?.getServiceMessageError(ValoresApi.ErrorServicio)
                        }
                    }
                }
                override fun onFailure(call: Call<Items<Videos>>, t: Throwable) {
                    if(!t.message.isNullOrEmpty()) {
                        output?.getServiceError(false)
                    }
                }

            }
        )
    }
}