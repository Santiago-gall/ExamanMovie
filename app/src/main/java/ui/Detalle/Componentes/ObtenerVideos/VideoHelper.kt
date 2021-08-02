package ui.Detalle.Componentes.ObtenerVideos

import ServiciosExternos.Constantes.ValoresApi
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import ui.Detalle.Componentes.Constantes.Mensajes
import ui.Detalle.Contractos.DetalleContract

class VideoHelper(var views:Activity?) : YouTubePlayer.OnInitializedListener, DetalleContract.VideoHelperContract {
    private var keyVideo: String = String()
    private var _youTubePlayerview: YouTubePlayerView = YouTubePlayerView(views as Context)
    override fun startVideo(youTubePlayerview: YouTubePlayerView, llavevideo: String) {
        _youTubePlayerview = youTubePlayerview
        _youTubePlayerview.initialize(ValoresApi.LlaveApiGoogle,this)

        keyVideo = llavevideo
    }
    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if(!p2 && p1 != null)
        {
            p1.cueVideo(keyVideo)
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        if(p1!!.isUserRecoverableError)
        {
            p1.getErrorDialog(views as Activity,1).show()
        }
        else
        {
            Toast.makeText(views!!.getApplicationContext(), "${Mensajes.ErrorYoutube}${p1?.toString()}", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == 1)
        {
            getYoutubePlayerProvider().initialize(ValoresApi.LlaveApiGoogle,this)
        }
    }
    fun getYoutubePlayerProvider() : YouTubePlayer.Provider
    {
        return _youTubePlayerview
    }
}