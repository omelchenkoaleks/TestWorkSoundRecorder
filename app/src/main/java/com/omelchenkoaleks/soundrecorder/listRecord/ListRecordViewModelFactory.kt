package com.omelchenkoaleks.soundrecorder.listRecord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omelchenkoaleks.soundrecorder.database.RecordDatabaseDao

/**
 * Будет создавать экземпляр ViewModel с переданным дополнительным параметром
 * также вернет сохраненный экземпляр после изменения конфигурации
 */
class ListRecordViewModelFactory(
    private val dataSource: RecordDatabaseDao
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListRecordViewModel::class.java)) {
            return ListRecordViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}