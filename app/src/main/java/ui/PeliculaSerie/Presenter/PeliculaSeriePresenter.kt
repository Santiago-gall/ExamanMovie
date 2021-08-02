package ui.PeliculaSerie.Presenter

import ServiciosExternos.Constantes.ValoresApi
import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import ui.PeliculaSerie.Contractos.PeliculaSerieContract
import ui.PeliculaSerie.Entidad.Movies
import ui.PeliculaSerie.Interactor.PeliculaSerieInteractor
import ui.PeliculaSerie.Router.PeliculaSerieRouter

class PeliculaSeriePresenter(var views: PeliculaSerieContract.Views?) : PeliculaSerieContract.PresenterOutput, PeliculaSerieContract.Presenter {
    private var interactor: PeliculaSerieContract.Interactor? = PeliculaSerieInteractor(this,views as Activity)
    private  var router: PeliculaSerieContract.Router? = PeliculaSerieRouter(views as Activity)
    override fun onDestroy() {
        views = null
        interactor = null
    }


    override fun getMovies(page: Int) {
        interactor?.ServiceMovie(page)
    }

    override fun onClickItemMovie(movie: Movies) {
        router?.ActivityDetalle(movie)
    }

    override fun getServiceSuccesMovies(entidad: List<Movies>?) {
        views?.responseMovies(entidad!!)
    }

    override fun getServiceError(messages: Boolean) {
        views?.ShowMessage(ValoresApi.MensajeError)
    }

    override fun getServiceMessageError(messages: String) {
        views?.showError(messages)
    }

}