package PersistenciaDatos.Repository.ContractRepository

import PersistenciaDatos.DBContext.DBMovies
import PersistenciaDatos.Entities.Movie
import android.app.Application
import androidx.lifecycle.LiveData

interface ContractoRepository {
    fun dbContext(apps: Application) : DBMovies
}