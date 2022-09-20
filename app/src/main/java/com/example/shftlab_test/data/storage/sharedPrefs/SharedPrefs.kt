package com.example.shftlab_test.data.storage.sharedPrefs

interface SharedPrefs <Out, Inp> {
    fun get(): Out
    fun save(data: Inp)
}