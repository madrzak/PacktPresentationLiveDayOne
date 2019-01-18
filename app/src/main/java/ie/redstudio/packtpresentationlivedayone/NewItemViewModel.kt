package ie.redstudio.packtpresentationlivedayone

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import ie.redstudio.packtpresentationlivedayone.data.AppDatabase
import ie.redstudio.packtpresentationlivedayone.data.ItemEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by Łukasz on 18/01/2019.
 */
class NewItemViewModel(application: Application) : AndroidViewModel(application) {

    private val mDb: AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "item-database"
    ).build()

    val allItems = MutableLiveData<List<ItemEntity>>()

    fun storeItem(name: String) {

        val item = ItemEntity()
        item.name = name

        GlobalScope.launch {
            mDb.itemDao().insert(item)
        }
    }

    fun retrieveItems(): MutableLiveData<List<ItemEntity>> {

        Timber.i("retrieveItems")

        GlobalScope.launch {

            val list = mDb.itemDao().getAll()

            Timber.i("retrieved items count ${list.size}")

            allItems.postValue(list)
        }

        return allItems
    }

}