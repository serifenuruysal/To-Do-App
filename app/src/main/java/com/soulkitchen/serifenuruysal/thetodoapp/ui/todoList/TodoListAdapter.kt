package com.soulkitchen.serifenuruysal.thetodoapp.ui.todoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.soulkitchen.serifenuruysal.thetodoapp.R
import com.soulkitchen.serifenuruysal.thetodoapp.data.db.TodoRecord
import kotlinx.android.synthetic.main.todo_item.view.*

/**
 * Created by S.Nur Uysal on 2019-07-22.
 */

class TodoListAdapter(todoEvents: TodoEvents) : RecyclerView.Adapter<TodoListAdapter.ViewHolder>(), Filterable {

    private var todoList: List<TodoRecord> = arrayListOf()
    private var filteredTodoList: List<TodoRecord> = arrayListOf()
    private val listener: TodoEvents = todoEvents

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = filteredTodoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filteredTodoList[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todo: TodoRecord, listener: TodoEvents) {
            itemView.tv_item_title.text = todo.title
            itemView.tv_item_content.text = todo.content

            itemView.iv_item_delete.setOnClickListener {
                listener.onDeleteClicked(todo)
            }

            itemView.setOnClickListener {
                listener.onViewClicked(todo)
            }
        }
    }
    /**
     * Search Filter implementation
     * */
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charString = p0.toString()
                filteredTodoList = if (charString.isEmpty()) {
                    todoList
                } else {
                    val filteredList = arrayListOf<TodoRecord>()
                    for (row in todoList) {
                        if (row.title.toLowerCase().contains(charString.toLowerCase())
                                || row.content.contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = filteredTodoList
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredTodoList = p1?.values as List<TodoRecord>
                notifyDataSetChanged()
            }

        }
    }

    /**
     * Activity uses this method to update todoList with the help of LiveData
     * */
    fun setAllTodoItems(todoItems: List<TodoRecord>) {
        this.todoList = todoItems
        this.filteredTodoList = todoItems
        notifyDataSetChanged()
    }

    /**
     * RecycleView touch event callbacks
     * */
    interface TodoEvents {
        fun onDeleteClicked(todoRecord: TodoRecord)
        fun onViewClicked(todoRecord: TodoRecord)
    }
}
