package ServiciosExternos.EntidadGral

import ServiciosExternos.Constantes.ValoresApi
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import ui.PeliculaSerie.Componentes.Constantes.NombreParametros
import ui.PeliculaSerie.Entidad.Movies

@Serializable
data class Items<T>(
    @SerializedName(ValoresApi.Items)
    var itemsMovies : List<T>

)
