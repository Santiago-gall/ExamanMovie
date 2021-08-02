package ui.Detalle.View

import ServiciosExternos.Constantes.ValoresApi
import ServiciosExternos.Imagenes.ImagenesContracto.IObtenerImagen
import ServiciosExternos.Imagenes.getImagenes.ObtenerImagen
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.peliculasseries.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.detalle_view.*
import ui.Detalle.Componentes.Constantes.Mensajes
import ui.Detalle.Contractos.DetalleContract
import ui.Detalle.Entidad.Videos
import ui.Detalle.Presenter.DetallePresenter
import ui.PeliculaSerie.Entidad.Movies

class DetalleView : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener, DetalleContract.Views {
    private var presenter: DetalleContract.Presenter? = DetallePresenter(this)
    private var viewimage: IObtenerImagen? = ObtenerImagen(this)
    private var keysVideo: String = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_view)
        presenter?.onRequestValues()

    }
    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    override fun onSuccessValues(movie: Movies) {
        viewimage!!.getImagenRemoto(imagens,movie.ImagenBig)
        titulode.setText(movie.Titulo)
        fechade.setText(movie.Fecha)
        votes.text = movie.Promedio.toString()
        descripcionde.setText(movie.Descripcion)
        presenter?.getServiceReq(movie.Id.toString())
    }

    override fun onSuccessVideos(entidad: Videos) {
        keysVideo = entidad.Key
        youtubevideo.initialize(ValoresApi.LlaveApiGoogle,this)
        //presenter?.inicializeVideo(youtubevideo,entidad.Key)
    }

    override fun onError(message: Boolean) {
        Toast.makeText(getApplicationContext(), ValoresApi.ErrorServicio, Toast.LENGTH_SHORT).show()
    }

    override fun getServiceMessageError(messages: String) {
        Toast.makeText(getApplicationContext(), messages, Toast.LENGTH_SHORT).show()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            presenter?.onChangeActivity()
            return false
        }
        return true
        return super.onKeyUp(keyCode, event)
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if (!p2) {
            p1?.cueVideo(keysVideo);
        }
    }
    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        TODO("Not yet implemented")
    }

}