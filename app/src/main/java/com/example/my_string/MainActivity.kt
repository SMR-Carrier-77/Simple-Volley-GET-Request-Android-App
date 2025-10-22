package com.example.my_string

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.my_string.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
  private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



// ...


// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url="https://arsarkar.xyz/SMR_practices/smr1.php"
        binding.progressBar.visibility= View.VISIBLE

// Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET,url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                binding.text.text="Response is :\n$response"
                binding.progressBar.visibility =(View.GONE)
            },
            Response.ErrorListener
            { binding.text.text = "That didn't work!" })
        binding.progressBar.visibility=(View.GONE)

// Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}