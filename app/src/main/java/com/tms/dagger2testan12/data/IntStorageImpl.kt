package com.tms.dagger2testan12.data

class IntStorageImpl : IntStorage {

    private var ints = listOf(3, 4, 5, 6, 7)

    override fun getNumbers(): List<Int> {
        return ints
    }

    override fun addInt() { // пришлось реализовать так, тк distinctUntilChanged сравнивал
                            // элементы по ссылкам, нужно было ее обновлять
        val newInts = ints.toMutableList()
        newInts.add(0) // просто добавили 0 к списку ints
        ints = newInts
    }
}