package ServiciosExternos.Imagenes.getImagenes

import ServiciosExternos.Constantes.ValoresApi
import ServiciosExternos.Imagenes.ImagenesContracto.IObtenerImagen
import android.app.Activity
import android.widget.ImageView
import com.example.peliculasseries.R
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

class ObtenerImagen(var views: Activity?) : IObtenerImagen {
    override fun getImagenRemoto(imageViews: ImageView,urlImage: String) {
        Picasso.with(views!!).load("${ValoresApi.Url_Image}${urlImage}").into(imageViews,
            object: Callback {
                override fun onSuccess() {

                }
                override fun onError() {

                    imageViews.maxHeight = 300
                    Picasso.with(views!!).load(R.drawable.notimage).into(imageViews)
                }

            })
    }

    override fun getImagenLocal() {

    }

}