package com.tms.dagger2testan12.data

import com.tms.dagger2testan12.domain.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainRepositoryImpl(
    private val stringStorage: StringStorage,
    private val intStorage: IntStorage
) : MainRepository {

    override fun getStrings(): Flow<List<String>> {
        return flow {
            emit(stringStorage.getData())
        }.flowOn(Dispatchers.IO)
    }


    override fun getInts(): Flow<List<Int>> {
        return flow {
            while (true) {  // эмитим (выбрасываем значения подписчику) каждые три секунды,
                // но если данные не были изменены с последнего эмита, эмита не будет (достигается это засчет distinctUntilChanged()
                emit(intStorage.getNumbers())
                delay(3000L)
            }
        }.distinctUntilChanged() // этот оператор фильтрует значения, то есть, если с прошло эмита значение не менялось, то эмита не будет
            .flowOn(Dispatchers.IO) // таким образом, елси данные не были изменены, ничего не произойдет
    }

    override fun addIntValue() {
        intStorage.addInt()
    }
}