package com.example.shftlab_test.data.mapper

interface Mapper <Internal, External> {
    fun mapToInternal(data: External): Internal
    fun mapToExternal(data: Internal): External
}