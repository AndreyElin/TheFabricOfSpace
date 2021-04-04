package andrey.elin.thefabricofspace

import com.google.gson.annotations.SerializedName

data class TfosServerResponseData(

    @field:SerializedName("explanation") val explanation: String?,
    @field:SerializedName("title") val title: String?,
    @field:SerializedName("url") val url: String?,
)