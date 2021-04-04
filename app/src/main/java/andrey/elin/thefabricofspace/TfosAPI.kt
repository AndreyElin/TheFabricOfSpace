package andrey.elin.thefabricofspace

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TfosAPI {
    @GET("planetary/apod")
    fun getTfos(@Query("api_key") apiKey: String): Call<TfosServerResponseData>
}