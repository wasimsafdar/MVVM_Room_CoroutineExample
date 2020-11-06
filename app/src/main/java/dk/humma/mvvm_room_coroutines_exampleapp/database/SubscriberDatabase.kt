package dk.humma.mvvm_room_coroutines_exampleapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class], version = 1)

abstract class SubscriberDatabase: RoomDatabase() {
    abstract val subscriberDAO : Subscriber_DAO

    companion object{

        @Volatile //It makes field visible to other threads
        private var INSTANCE : SubscriberDatabase? = null

        fun getInstance(context: Context):SubscriberDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        "subscribe_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}