package PersistenciaDatos.DBContext

import PersistenciaDatos.ContractsDB.MoviesDBo
import androidx.room.Database
import androidx.room.RoomDatabase
import ui.PeliculaSerie.Entidad.Movies

@Database(entities = arrayOf(Movies::class), version = 1)
abstract class DBMovies : RoomDatabase() {
    abstract fun MoviesDao() : MoviesDBo

}