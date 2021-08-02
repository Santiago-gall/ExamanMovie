package ui.Detalle.DatosExternos.ServiciosApiContracto

import ServiciosExternos.Constantes.ValoresApi
import ServiciosExternos.EntidadGral.Items
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import ui.Detalle.Entidad.Videos

interface MetodosApi {
    @GET
    fun getVideoKey(@Url url: String) : Call<Items<Videos>>
}