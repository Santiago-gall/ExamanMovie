package ServiciosExternos.EntidadGral

import ServiciosExternos.Constantes.ValoresApi
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import ui.PeliculaSerie.Entidad.Movies

@Serializable
data class MensajeServicio(
    @SerializedName(ValoresApi.ErrorServicio)
    var ServicioError: List<String>
)
