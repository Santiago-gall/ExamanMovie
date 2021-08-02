package PersistenciaDatos.Repository.RepositoryDB

import PersistenciaDatos.ConstantesDB.DBHandler
import PersistenciaDatos.ContractsDB.MoviesDBo
import PersistenciaDatos.DBContext.DBMovies
import PersistenciaDatos.Entities.Movie
import PersistenciaDatos.Repository.ContractRepository.ContractoRepository
import PersistenciaDatos.Utils.subscribeOnBackground
import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

class RepositoryDB : ContractoRepository{
    override fun dbContext(apps: Application) : DBMovies
    {
        return Room.databaseBuilder(
            apps,
            DBMovies::class.java, DBHandler.DATABASE_NAME
        ).build()
    }
}