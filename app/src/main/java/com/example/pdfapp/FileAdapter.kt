package com.example.pdfapp
//
//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//
//class FileAdapter(private val files: List<String>, private val context: Context) : RecyclerView.Adapter<FileAdapter.FileViewHolder>() {
//
//    class FileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val fileNameTextView: TextView = itemView.findViewById(R.id.fileNameTextView)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.file_item, parent, false)
//        return FileViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
//        val file = files[position]
//        holder.fileNameTextView.text = file
//
//        holder.itemView.setOnClickListener {
//
//            val intent = Intent(context, FileActivity::class.java)
//            intent.putExtra("file_name", file)
//            context.startActivity(intent)
//
//
//
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return files.size
//    }
//}


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FileAdapter(private val context: Context, private val files: List<String>) :
    RecyclerView.Adapter<FileAdapter.FileViewHolder>() {

    private var filteredFiles: List<String> = files

    class FileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fileNameTextView: TextView = itemView.findViewById(R.id.fileNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.file_item, parent, false)
        return FileViewHolder(view)
    }

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        val file = filteredFiles[position]
        holder.fileNameTextView.text = file

        holder.itemView.setOnClickListener {
            val intent = Intent(context, FileActivity::class.java)
            intent.putExtra("file_name", file)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filteredFiles.size
    }

    fun filter(query: String) {
        filteredFiles = if (query.isEmpty()) {
            files
        } else {
            files.filter { it.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }
}
