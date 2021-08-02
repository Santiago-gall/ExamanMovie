package PersistenciaDatos.ContractsDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ui.PeliculaSerie.Entidad.Movies

@Dao
interface MoviesDBo {
    @Query("SELECT * FROM Movies")
     fun getAll(): List<Movies>
    @Query("SELECT * FROM Movies WHERE id = :id")
    fun loadById(id: Int): Movies
    @Insert
    fun insertAll(vararg movies: Movies)
}