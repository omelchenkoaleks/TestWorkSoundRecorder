package com.omelchenkoaleks.soundrecorder.listRecord

import androidx.lifecycle.ViewModel
import com.omelchenkoaleks.soundrecorder.database.RecordDatabaseDao

class ListRecordViewModel(
    dataSource: RecordDatabaseDao
) : ViewModel() {
    val database = dataSource

    // получение всех записей, которые нужно будет отобразить в списке
    val records = database.getAllRecords()
}