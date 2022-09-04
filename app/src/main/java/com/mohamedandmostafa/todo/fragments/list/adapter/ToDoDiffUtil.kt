package com.mohamedandmostafa.todo.fragments.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mohamedandmostafa.todo.data.models.ToDoData

class ToDoDiffUtil(
    private val oldList: List<ToDoData>,
    private val newList: List<ToDoData>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int { // Return Size of the oldList.
        return oldList.size
    }

    override fun getNewListSize(): Int { //Return size of the newList
        return newList.size
    }

   // Called by DiffUtil to decide whether two object represent the same item.
    //if items have unique ids, this method should check their id equality
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
       // triple equal sign that mean it will basically check if those two items are identical -> متطابق
       // if this method return true then must called are areContentsTheSame
    }

    // Check whether two items have the same data. Can change its behavior depending on the UI. this method called by DiffUtil only
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].description == newList[newItemPosition].description
                && oldList[oldItemPosition].priority == newList[newItemPosition].priority
    }
}