package ui.Detalle.Interactor

import android.app.Activity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ui.Detalle.Contractos.DetalleContract
import ui.Detalle.DatosExternos.ServiciosApi.ApiServicios
import ui.Detalle.Entidad.Videos
import ui.PeliculaSerie.Componentes.Constantes.ConstantesValores
import ui.PeliculaSerie.Entidad.Movies

class DetalleInteractor(var output: DetalleContract.OutPutPresenter?) : DetalleContract.Interactor, DetalleContract.OutPutInteractor {
    private var requestServicio: DetalleContract.ApiServicioContract? = ApiServicios(this)
    override fun getValues(activit: Activity)
    {
        try {
            val valores = activit.intent.extras
            if (valores != null) {
                val datos = valores.getString(ConstantesValores.LlaveJsonMovie)
                val entidad = Json.decodeFromString<Movies>(datos!!)
                output?.onSuccessValues(entidad)
            }
        }catch (ex: Exception)
        {

        }
    }

    override fun getServiceReq(key: String) {
        requestServicio?.getServiceVideos(key)
    }

    override fun getServiceSuccesVideos(entidad: Videos?) {
        if(entidad != null) {
            output?.onSuccessVideos(entidad)
        }
    }

    override fun getServiceError(messages: Boolean) {
        output?.onError(messages)
    }

    override fun getServiceMessageError(messages: String) {
        output?.getServiceMessageError(messages)
    }

}