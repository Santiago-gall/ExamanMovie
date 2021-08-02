package ui.PeliculaSerie.Componentes.Helper

import ServiciosExternos.Imagenes.ImagenesContracto.IObtenerImagen
import ServiciosExternos.Imagenes.getImagenes.ObtenerImagen
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.peliculasseries.R
import ui.PeliculaSerie.Contractos.PeliculaSerieContract
import ui.PeliculaSerie.Entidad.Movies

class MoviesAdapter(private var context: Activity, private val dataSource: List<Movies>, private val presenter: PeliculaSerieContract.Presenter?, private var contador: Int) : BaseAdapter() {
    private var viewimage: IObtenerImagen? = ObtenerImagen(context)
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        if(contador == 0) {
            val get = dataSource[position]
            presenter?.onClickItemMovie(get)
            contador++
        }

        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.items_list, parent, false)
        val titulos = rowView.findViewById(R.id.titulo) as TextView

        val descripcion = rowView.findViewById(R.id.fecha) as TextView
        val imagen = rowView.findViewById(R.id.IVcontent) as ImageView
        val recipe = dataSource[position]


        titulos.text = recipe.Titulo
        descripcion.text = recipe.Fecha
        viewimage!!.getImagenRemoto(imagen,recipe.ImagenBig)
        return rowView
    }

}