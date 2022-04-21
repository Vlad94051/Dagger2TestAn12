package com.tms.dagger2testan12.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map

interface MainInteractor {
    fun getData(): Flow<List<String>>

    fun addIntValue()
}

class MainInteractorImpl(private val repository: MainRepository) : MainInteractor {

    override fun getData(): Flow<List<String>> {
        return repository.getInts() // получили Flow<List<Int>>
            .map { list -> list.map { item -> item.toString() } } // смапили его к Flow<List<String>>
            .combine(repository.getStrings()) { mappedInts, strings -> // склеили два флоу, чтобы обработать данные с обоих
                mappedInts
                    .filter { mappedItem -> !strings.contains(mappedItem) } // оставили только элементы, которых нет в strings (убрали элементы, которые есть в обоих списках)
                    .plus(strings) // склеили список mappedInts и strings
                    .sorted() // отсортировали по возрастанию (встроенный метод, работает хорошо)

            }
    }

    override fun addIntValue() {
        repository.addIntValue()
    }
}