package andrey.elin.thefabricofspace

sealed class TfosData {
    data class Success(val serverResponseData: TfosServerResponseData) : TfosData()
    data class Error(val error: Throwable) : TfosData()
    data class Loading(val progress: Int?) : TfosData()
}