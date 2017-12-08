package com.paprika.thali.data.db

import com.paprika.thali.data.db.room.AppDatabase
import javax.inject.Inject

/**
 * Created by vicky on 7/12/17.
 */
class AppDbHelper @Inject
constructor(val appDatabase: AppDatabase) : DbHelper {

}