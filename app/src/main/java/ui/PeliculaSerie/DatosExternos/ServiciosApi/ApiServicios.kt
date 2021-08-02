package ui.PeliculaSerie.DatosExternos.ServiciosApi

import ServiciosExternos.Api.ServicioApi
import ServiciosExternos.ApiContracto.ServicioApiContracto
import ServiciosExternos.Constantes.ValoresApi
import ServiciosExternos.EntidadGral.Items
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ui.PeliculaSerie.Contractos.PeliculaSerieContract
import ui.PeliculaSerie.DatosExternos.ServiciosApiContracto.MetodosApi
import ui.PeliculaSerie.Entidad.Movies
import java.util.*

class ApiServicios(var outPutInteractor: PeliculaSerieContract.InteractorOutPut) : PeliculaSerieContract.ApiServicioContract {
    private var ConsultaServicio: ServicioApiContracto? = ServicioApi()

    override fun getServiceMovies(page: Int){
        val request = ConsultaServicio?.buildService(MetodosApi :: class.java)
        val lenguaje = Locale.getDefault().toString()
        request?.peliculaPopular(ValoresApi.keyValue,lenguaje ,page)!!.enqueue(
            object : Callback<Items<Movies>> {
                override fun onResponse(call: Call<Items<Movies>>, response: Response<Items<Movies>>) {
                    val Resp = response.body()
                    val err = response.errorBody()


                    if(response.isSuccessful)
                    {
                        if (Resp != null) {
                            outPutInteractor?.getServiceSuccesMovies(Resp.itemsMovies)
                        }
                        else
                        {
                            outPutInteractor?.getServiceMessageError(ValoresApi.MensajeError)
                        }
                    }
                    else
                    {
                        if(err != null) {
                            val errors = JSONObject(err!!.string())
                            val mensaje = errors.getString(ValoresApi.ErrorServicio)
                            outPutInteractor?.getServiceMessageError(mensaje)
                        }
                        else{
                            outPutInteractor?.getServiceMessageError(ValoresApi.ErrorServicio)
                        }
                    }
                }
                override fun onFailure(call: Call<Items<Movies>>, t: Throwable) {
                    if(!t.message.isNullOrEmpty()) {
                        outPutInteractor?.getServiceError(false)
                    }
                }

            }
        )
    }

}