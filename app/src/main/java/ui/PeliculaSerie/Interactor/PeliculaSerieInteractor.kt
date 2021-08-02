package ui.PeliculaSerie.Interactor

import PersistenciaDatos.Entities.Movie
import PersistenciaDatos.Repository.ContractRepository.ContractoRepository
import PersistenciaDatos.Repository.RepositoryDB.RepositoryDB
import android.app.Activity
import android.app.Application
import android.content.Context
import okhttp3.internal.wait
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import ui.PeliculaSerie.Contractos.PeliculaSerieContract
import ui.PeliculaSerie.DatosExternos.ServiciosApi.ApiServicios
import ui.PeliculaSerie.Entidad.Movies

class PeliculaSerieInteractor(var outPut: PeliculaSerieContract.PresenterOutput,var app: Activity?) : PeliculaSerieContract.InteractorOutPut, PeliculaSerieContract.Interactor {
    private var repository: ContractoRepository? = RepositoryDB()
    private var consultaServicio: PeliculaSerieContract.ApiServicioContract? = ApiServicios(this)
    private var listMovie: List<Movies> = emptyList()
    override fun ServiceMovie(page: Int) {

        async {
            val context = repository?.dbContext(app!!.application)?.MoviesDao()
            val dats = context?.getAll()
            if(dats != null) {
                if (dats.size > 0) {
                    listMovie = dats
                }
            }
        }
        consultaServicio?.getServiceMovies(page)
    }

    override fun getServiceSuccesMovies(entidad: List<Movies>?) {

        val context = repository?.dbContext(app!!.application)?.MoviesDao()
        if(entidad != null) {
            entidad.map { x ->

                    async {
                    var getId = context?.loadById(x.Id)
                    if (getId == null) {

                            context?.insertAll(x)

                        }

                    }
            }
        }

        outPut?.getServiceSuccesMovies(entidad)
    }

    override fun getServiceError(messages: Boolean) {

        outPut?.getServiceSuccesMovies(listMovie)
    }

    override fun getServiceMessageError(messages: String) {
        outPut?.getServiceMessageError(messages)
    }
}