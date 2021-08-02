package ui.PeliculaSerie.Contractos

import ui.PeliculaSerie.Entidad.Movies

interface PeliculaSerieContract {
    interface Views
    {
        fun onDestroy()
        fun showError(message: String)
        fun responseMovies(movies: List<Movies>)
        fun ShowMessage(ismessage : String)
    }
    interface Presenter
    {
        fun onDestroy()
        fun getMovies(page: Int)
        fun onClickItemMovie(movie: Movies)
    }
    interface Interactor
    {
        fun ServiceMovie(page: Int)
    }
    interface Router
    {
        fun ActivityDetalle(movie: Movies)
    }
    interface PresenterOutput
    {
        fun getServiceSuccesMovies(entidad: List<Movies>?)
        fun getServiceError(messages: Boolean)
        fun getServiceMessageError(messages: String)
    }
    interface InteractorOutPut
    {
        fun getServiceSuccesMovies(entidad: List<Movies>?)
        fun getServiceError(messages: Boolean)
        fun getServiceMessageError(messages: String)
    }
    interface ApiServicioContract
    {
        fun getServiceMovies(page: Int)
    }
}