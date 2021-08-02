package ui.Detalle.Router

import android.app.Activity
import android.content.Intent
import ui.Detalle.Contractos.DetalleContract
import ui.Detalle.View.DetalleView
import ui.PeliculaSerie.View.PeliculaSerieView

class DetalleRouter(var views: Activity) : DetalleContract.Router{
    override fun intentActivity() {
        val intent = Intent(views!!, PeliculaSerieView::class.java)
        views!!.startActivity(intent)
    }

}