package com.example.employeemanagementtool

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.employeemanagementtool.database.models.Employee
import kotlinx.android.synthetic.main.employee_item.view.*

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.EmployeeViewHolder>(){

     class EmployeeViewHolder(itemView:View):
         RecyclerView.ViewHolder(itemView){
         private val employeeFirstName: TextView = itemView.first_name
         private val employeeLastName: TextView = itemView.last_name
         private val employeeAge: TextView = itemView.age
         private val employeeGender: TextView = itemView.gender
         private val employeeId: TextView = itemView.employee_id

         fun bind(employee: Employee) {
             employeeFirstName.text = employee.firstName
             employeeLastName.text = employee.lastName
             employeeAge.text = employee.age.toString()
             employeeGender.text = employee.gender.toString()
             employeeId.text = "Id: ${employee.employeeId}"
         }


    }
    private val diffCallback = object:DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.employeeId == newItem.employeeId
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
       return EmployeeViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
       )
    }

    fun submitList(employeeList: List<Employee>) {
        differ.submitList(employeeList)
    }
    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
}