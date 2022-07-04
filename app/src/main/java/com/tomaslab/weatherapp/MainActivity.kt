package com.tomaslab.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tomaslab.wetherapp.R
import com.tomaslab.wetherapp.databinding.ActivityMainBinding
import org.json.JSONObject

const val API_KEY = "e4ceff26c11541ceb2a181217220407"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            getResult("London")
        }
    }

    private fun getResult(name: String){
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {   response ->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.e("AAA","Temper - ${temp.getString("temp_c")}")
                binding.tvTemp.text = temp.getString("temp_c")
            },
            {
                Log.e("AAA","Volle Error $it")
            }
        )
        queue.add(stringRequest)
    }
}