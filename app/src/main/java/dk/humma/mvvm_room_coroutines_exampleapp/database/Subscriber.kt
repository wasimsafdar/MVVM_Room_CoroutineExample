package dk.humma.mvvm_room_coroutines_exampleapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Subscriber_Data_table")
data class Subscriber(

    @PrimaryKey(autoGenerate = true) //Set the primary key of database table

    @ColumnInfo( name = "subscriber_name")
    val id : Int ,

    @ColumnInfo( name = "subscriber_id")
    val name : String,

    @ColumnInfo( name = "subscriber_email")
    val email : String
)