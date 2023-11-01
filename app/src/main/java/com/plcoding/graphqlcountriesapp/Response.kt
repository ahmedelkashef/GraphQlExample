package com.plcoding.graphqlcountriesapp

class Response<T>(val data : T) {
}
fun Response<*>.getData() = data