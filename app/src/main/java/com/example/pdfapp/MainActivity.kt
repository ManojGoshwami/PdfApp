package com.example.pdfapp

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        pdfView=findViewById(R.id.pdfView)




        searchEditText.setOnEditorActionListener { _, _, _ ->
            if (!searchEditText.text.isEmpty()){
                searchPDF()
            }

            true
        }
    }

    private fun searchPDF() {
        val searchTerm = searchEditText.text.toString().trim().toLowerCase()
        val pdfFileName = "$searchTerm.pdf"
        val assetManager = this.assets
//        val inputStream = assetManager.open(pdfFileName)
//        pdfView.fromStream(inputStream).load()

        try {
            val inputStream = assetManager.open(pdfFileName)
            pdfView.fromStream(inputStream).load()
//            val inputStream = assets.open(pdfFileName)
//            pdfView.fromStream(inputStream).load()
        } catch (e: FileNotFoundException) {
            Toast.makeText(this, "PDF not found", Toast.LENGTH_SHORT).show()
        }

    }
}
