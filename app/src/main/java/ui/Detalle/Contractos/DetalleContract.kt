package ui.Detalle.Contractos

import android.app.Activity
import android.content.Intent
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import ui.Detalle.Entidad.Videos
import ui.PeliculaSerie.Entidad.Movies

interface DetalleContract {
    interface Views
    {
        fun onDestroy()
        fun onSuccessValues(movie: Movies)
        fun onSuccessVideos(entidad: Videos)
        fun onError(message: Boolean)
        fun getServiceMessageError(messages: String)
    }
    interface Presenter
    {
        fun onDestroy()
        fun inicializeVideo(youTubePlayerview: YouTubePlayerView, llavevideo: String)
        fun onRequestValues()
        fun getServiceReq(key: String)
        fun onChangeActivity()
    }
    interface Interactor
    {
        fun getValues(activit: Activity)
        fun getServiceReq(key: String)
    }
    interface Router
    {
        fun intentActivity()
    }
    interface OutPutPresenter
    {
        fun onSuccessValues(movie: Movies)
        fun onSuccessVideos(entidad: Videos)
        fun onError(message: Boolean)
        fun getServiceMessageError(messages: String)
    }
    interface OutPutInteractor
    {
        fun getServiceSuccesVideos(entidad: Videos?)
        fun getServiceError(messages: Boolean)
        fun getServiceMessageError(messages: String)
    }
    interface valoresContract
    {
        fun getValueControls(entidad: Movies)
    }
    interface VideoHelperContract
    {
        fun startVideo(youTubePlayerview: YouTubePlayerView, llavevideo: String)
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    }
    interface ApiServicioContract
    {
        fun getServiceVideos(key: String)
    }

}