package com.dmonsalud.data

sealed class DataError : Throwable() {
    data class Network(val errorType: Throwable) : DataError()
    data class Unknown(val errorType: Throwable) : DataError()
}