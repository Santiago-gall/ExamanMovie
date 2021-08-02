package ui.Detalle.Entidad

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import ui.Detalle.Componentes.Constantes.ParametrosVideos

@Serializable
data class Videos(
    @SerializedName(ParametrosVideos.key)
    var Key: String
)
