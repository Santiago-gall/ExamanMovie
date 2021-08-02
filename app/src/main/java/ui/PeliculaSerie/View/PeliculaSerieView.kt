package ui.PeliculaSerie.View

import PersistenciaDatos.ConstantesDB.DBHandler
import PersistenciaDatos.DBContext.DBMovies
import PersistenciaDatos.Repository.ContractRepository.ContractoRepository
import PersistenciaDatos.Repository.RepositoryDB.RepositoryDB
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.peliculasseries.R
import kotlinx.android.synthetic.main.pelicula_serie_view.*
import kotlinx.coroutines.launch
import ui.PeliculaSerie.Componentes.Constantes.ConstantesValores
import ui.PeliculaSerie.Componentes.Helper.MoviesAdapter
import ui.PeliculaSerie.Contractos.PeliculaSerieContract
import ui.PeliculaSerie.Entidad.Movies
import ui.PeliculaSerie.Presenter.PeliculaSeriePresenter

class PeliculaSerieView : AppCompatActivity(), PeliculaSerieContract.Views {
    private var presenter: PeliculaSerieContract.Presenter? = PeliculaSeriePresenter(this)
    private var movieList: List<Movies>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pelicula_serie_view)
        getMovieRequest(1)
        if(movieList != null)
        {
            movieNews(movieList!!)
        }
        getMoviesAll()
    }
    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }
    fun getMovieRequest(page: Int)
    {
        presenter?.getMovies(page)
    }
    override fun showError(message: String) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show()
    }
    override fun responseMovies(movies: List<Movies>) {
        movieNews(movies)
        movieList = movies
    }
    fun movieNews(movies: List<Movies>)
    {
        val adapter = MoviesAdapter(this,movies,presenter, ConstantesValores.contador)
        listMovies.adapter = adapter
    }
    override fun ShowMessage(ismessage: String) {
        Toast.makeText(getApplicationContext(), ismessage, Toast.LENGTH_SHORT).show();
    }
    fun getMoviesAll()
    {

    }
}