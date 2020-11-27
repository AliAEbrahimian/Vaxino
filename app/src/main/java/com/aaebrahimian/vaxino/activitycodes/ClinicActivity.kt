package com.aaebrahimian.vaxino.activitycodes

import android.app.VoiceInteractor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aaebrahimian.vaxino.R
import com.aaebrahimian.vaxino.recyclerview.Post_Model
import com.aaebrahimian.vaxino.recyclerview.PostsAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class ClinicActivity : AppCompatActivity() {
    private val datalist : MutableList <Post_Model> = mutableListOf()
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)

        sendrequest()
    }

    private fun sendrequest(){
        val url = "https://jsonplaceholder.typicode.com/posts"
        val request = JsonArrayRequest(Request.Method.GET,url,null,
            Response.Listener { response ->
                              Log.e("Volley response",response.toString())
            },
            Response.ErrorListener {
                                   Log.e("Volley Error", "$it")
            }

        )

        Volley.newRequestQueue(this).add(request)
    }
}