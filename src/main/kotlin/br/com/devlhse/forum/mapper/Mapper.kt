package br.com.devlhse.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
