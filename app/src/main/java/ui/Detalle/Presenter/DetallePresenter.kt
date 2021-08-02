package ui.Detalle.Presenter

import android.app.Activity
import com.google.android.youtube.player.YouTubePlayerView
import ui.Detalle.Componentes.ObtenerVideos.VideoHelper
import ui.Detalle.Contractos.DetalleContract
import ui.Detalle.Entidad.Videos
import ui.Detalle.Interactor.DetalleInteractor
import ui.Detalle.Router.DetalleRouter
import ui.PeliculaSerie.Entidad.Movies

class DetallePresenter(var views: DetalleContract.Views?) : DetalleContract.OutPutPresenter, DetalleContract.Presenter {
    private var interactor: DetalleContract.Interactor? = DetalleInteractor(this)
    private var router: DetalleContract.Router? = DetalleRouter(views as Activity)
    override fun onDestroy() {
        views = null
        interactor = null
    }
    override fun inicializeVideo(youTubePlayerview: YouTubePlayerView, llavevideo: String) {
    }

    override fun onRequestValues() {
        interactor?.getValues(views as Activity)
    }

    override fun getServiceReq(key: String) {
        interactor?.getServiceReq(key)
    }

    override fun onChangeActivity() {
        router?.intentActivity()
    }

    override fun onSuccessValues(movie: Movies) {
        views?.onSuccessValues(movie)
    }

    override fun onSuccessVideos(entidad: Videos) {
        views?.onSuccessVideos(entidad)
    }

    override fun onError(message: Boolean) {
        views?.onError(message)
    }

    override fun getServiceMessageError(messages: String) {
        views?.getServiceMessageError(messages)
    }

}