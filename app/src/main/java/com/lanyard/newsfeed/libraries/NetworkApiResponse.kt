package com.lanyard.newsfeed.libraries

import retrofit2.Response

internal const val UNKNOWN_CODE = -1

sealed class NetworkApiResponse<T> {
    companion object {
        fun <T> create(response: Response<T>): NetworkApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    NetworkApiEmptyResponse()
                } else {
                    NetworkApiSuccessResponse(body)
                }
            } else {
                NetworkApiErrorResponse(
                    response.code(),
                    response.errorBody()?.string() ?: response.message()
                )
            }
        }

        fun <T> create(errorCode: Int, error: Throwable): NetworkApiErrorResponse<T> {
            return NetworkApiErrorResponse(errorCode, error.message ?: "Unknown Error!")
        }
    }
}

class NetworkApiEmptyResponse<T> : NetworkApiResponse<T>()
data class NetworkApiErrorResponse<T>(val errorCode: Int, val errorMessage: String): NetworkApiResponse<T>()
data class NetworkApiSuccessResponse<T>(val body: T): NetworkApiResponse<T>()