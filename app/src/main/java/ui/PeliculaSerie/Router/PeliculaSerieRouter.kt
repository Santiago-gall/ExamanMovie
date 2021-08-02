package ui.PeliculaSerie.Router

import android.app.Activity
import android.content.Intent
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ui.Detalle.View.DetalleView
import ui.PeliculaSerie.Componentes.Constantes.ConstantesValores
import ui.PeliculaSerie.Contractos.PeliculaSerieContract
import ui.PeliculaSerie.Entidad.Movies

class PeliculaSerieRouter(var views: Activity?) : PeliculaSerieContract.Router {
    override fun ActivityDetalle(movie: Movies)
    {
        val intent = Intent(views!!,DetalleView::class.java)
        val jsonSer = Json.encodeToString(movie)
        intent.putExtra(ConstantesValores.LlaveJsonMovie,jsonSer)
        views!!.startActivity(intent)
    }
}