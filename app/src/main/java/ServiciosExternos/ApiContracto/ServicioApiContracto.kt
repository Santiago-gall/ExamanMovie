package ServiciosExternos.ApiContracto

interface ServicioApiContracto {
    fun<T> buildService(service: Class<T>): T
}