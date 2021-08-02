package ui.PeliculaSerie.DatosExternos.ServiciosApiContracto

import ServiciosExternos.Constantes.ValoresApi
import ServiciosExternos.EntidadGral.Items
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ui.PeliculaSerie.Entidad.Movies

interface MetodosApi {
    @GET(ValoresApi.PlayingNow)
    fun peliculaPopular(@Query(ValoresApi.Key) keyValue : String,@Query(ValoresApi.Language) lenguaje: String, @Query(ValoresApi.Page) page: Int): Call<Items<Movies>>
}