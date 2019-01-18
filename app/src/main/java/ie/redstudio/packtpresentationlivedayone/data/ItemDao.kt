package ie.redstudio.packtpresentationlivedayone.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Łukasz on 18/01/2019.
 */
@Dao
interface ItemDao {

    @Query("SELECT * FROM itementity")
    fun getAll(): List<ItemEntity>

    @Insert
    fun insert(item: ItemEntity)
}