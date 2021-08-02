package PersistenciaDatos.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import ui.PeliculaSerie.Componentes.Constantes.NombreParametros

@Entity
data class Movie(
@PrimaryKey
val Id: Int,
@ColumnInfo(name = NombreParametros.title)
val Titulo: String?,
@ColumnInfo(name = NombreParametros.release_date)
val Fecha: String?,
@ColumnInfo(name = NombreParametros.overview)
val Descripcion: String?,
@ColumnInfo(name = NombreParametros.vote_average)
val Promedio: Double?,
@ColumnInfo(name = NombreParametros.backdrop_path)
val ImagenSmall: String?,
@ColumnInfo(name = NombreParametros.poster_path)
val ImagenBig: String?,
@ColumnInfo(name = NombreParametros.video)
val Video: Boolean?
)
