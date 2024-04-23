package com.example.pdfapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.barteksc.pdfviewer.PDFView
import java.io.FileNotFoundException

class FileActivity : AppCompatActivity() {
    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)
        pdfView=findViewById(R.id.pdfView)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        val fileName = intent.getStringExtra("file_name")
        Log.d("FileActivity", "File name received: $fileName")

        val assetManager = this.assets
        val docxFilePath = "man/$fileName"
        Log.d("FileActivity", "PDF file path: $docxFilePath")

        try {
            val inputStream = assetManager.open(docxFilePath)
            pdfView.fromStream(inputStream).load()
        } catch (e: FileNotFoundException) {
            Toast.makeText(this, "PDF not found", Toast.LENGTH_SHORT).show()
            Log.e("FileActivity", "Error opening PDF file: $e")
        }

    }
}
