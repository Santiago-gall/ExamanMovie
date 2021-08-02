package ServiciosExternos.Imagenes.ImagenesContracto

import android.widget.ImageView

interface IObtenerImagen {
    fun getImagenRemoto(imageViews: ImageView, urlImage: String)
    fun getImagenLocal()
}