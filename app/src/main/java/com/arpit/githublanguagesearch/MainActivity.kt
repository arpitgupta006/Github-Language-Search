package com.arpit.githublanguagesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val base_url = "https://api.github.com/"
class MainActivity : AppCompatActivity() {


    private var fullNameList = mutableListOf<String>()
    private var ownerLoginList = mutableListOf<String>()
    private var descriptionList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      buSearch.setOnClickListener {
          makeAPIRequest()
      }
    }


    private fun setRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = RecyclerAdapter(fullNameList, ownerLoginList, descriptionList)
    }

    private fun addToList(fullname: String, ownerlogin: String, description: String) {
        fullNameList.add(fullname)
        ownerLoginList.add(ownerlogin)
        descriptionList.add(description)
    }

    private fun makeAPIRequest() {

        val api = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {

            GlobalScope.launch(Dispatchers.Main) {
                val response = withContext(Dispatchers.IO) {api.githubResults(etSearch.text.toString())}
                if (response.isSuccessful){


                }

                    }
                }

    }
}