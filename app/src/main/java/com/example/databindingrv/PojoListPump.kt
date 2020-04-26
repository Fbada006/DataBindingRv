package com.example.databindingrv

fun generatePojoList(): List<Pojo> {
    val pojoList = mutableListOf<Pojo>()
    for ((id, i) in (1..30).withIndex()) {
        pojoList.add(Pojo(id, "Title $i", "Description for $i"))
    }
    return pojoList
}
