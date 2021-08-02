package ui.PeliculaSerie.Entidad

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import ui.PeliculaSerie.Componentes.Constantes.NombreParametros

@Entity
@Serializable
data class Movies(
    @PrimaryKey
    @SerializedName(NombreParametros.id)
    var Id: Int,
    @ColumnInfo(name = NombreParametros.title)
    @SerializedName(NombreParametros.title)
    var Titulo: String,
    @ColumnInfo(name = NombreParametros.release_date)
    @SerializedName(NombreParametros.release_date)
    var Fecha: String,
    @ColumnInfo(name = NombreParametros.overview)
    @SerializedName(NombreParametros.overview)
    var Descripcion: String,
    @ColumnInfo(name = NombreParametros.vote_average)
    @SerializedName(NombreParametros.vote_average)
    var Promedio: Double,
    @ColumnInfo(name = NombreParametros.backdrop_path)
    @SerializedName(NombreParametros.backdrop_path)
    var ImagenSmall: String,
    @ColumnInfo(name = NombreParametros.poster_path)
    @SerializedName(NombreParametros.poster_path)
    var ImagenBig: String,
    @ColumnInfo(name = NombreParametros.video)
    @SerializedName(NombreParametros.video)
    var Video: Boolean
)
