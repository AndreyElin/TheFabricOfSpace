package andrey.elin.thefabricofspace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TFOSViewModel(

    private val liveDataForViewToObserve: MutableLiveData<TfosData> = MutableLiveData(),
    private val retrofitImpl: TfosRetrofitImpl = TfosRetrofitImpl()
) :
    ViewModel() {

    fun getData(): LiveData<TfosData> {
        sendServerRequest()
        return liveDataForViewToObserve
    }

    private fun sendServerRequest() {
        liveDataForViewToObserve.value = TfosData.Loading(null)
        val apiKey: String = "DEMO_KEY"
        if (apiKey.isBlank()) {
            TfosData.Error(Throwable("You need API key"))
        } else {
            retrofitImpl.getRetrofitImpl().getTfos(apiKey).enqueue(object :
                Callback<TfosServerResponseData> {
                override fun onResponse(
                    call: Call<TfosServerResponseData>,
                    response: Response<TfosServerResponseData>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        liveDataForViewToObserve.value =
                            TfosData.Success(response.body()!!)
                    } else {
                        val message = response.message()
                        if (message.isNullOrEmpty()) {
                            liveDataForViewToObserve.value =
                                TfosData.Error(Throwable("Unidentified error"))
                        } else {
                            liveDataForViewToObserve.value =
                                TfosData.Error(Throwable(message))
                        }
                    }
                }

                override fun onFailure(call: Call<TfosServerResponseData>, t: Throwable) {
                    liveDataForViewToObserve.value = TfosData.Error(t)
                }
            })
        }
    }
}
