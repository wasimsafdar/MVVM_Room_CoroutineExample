package dk.humma.mvvm_room_coroutines_exampleapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

//Data access object for Room
@Dao
interface Subscriber_DAO {

    //In this function, we pass Subscriber Class
    //Room manages database queries in background thread
    @Insert //Room library recognize it using Insert annotation
    suspend fun insertSubscriber(susbcriber : Subscriber)

    //Updating the row of Subscriber table
    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    //With Query annotation we can write SQL queries
    @Query("DELETE FROM Subscriber_Data_table")
    suspend fun deleteAll()

    //Because this function returns LiveData, therefore Room runs it in background thread
    @Query("SELECT * FROM Subscriber_Data_table")
    fun getAllSubscribers():LiveData<List<Subscriber>>
}