package com.jonpas.webapps

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_view.*
import android.webkit.WebView
import android.webkit.WebViewClient


class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // Load website
        //webView.loadUrl("http://10.0.2.2:8000/") // Local Development
        webView.loadUrl("https://jonpas.eu.pythonanywhere.com/") // PythonAnywhere Hosted

        // Enable JavaScript
        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true

        // Load all URLs inside WebView instead of default browser
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        // Refresh button
        refreshButton.setOnClickListener {
            webView.reload()
        }
    }

    // Keep back button inside WebView, going a page back
    override fun onBackPressed() {
        when {
            webView?.canGoBack() == true -> webView.goBack()
            else -> super.onBackPressed()
        }
    }
}
