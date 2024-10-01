package com.batuhanozkan.starwarsapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var myTextView:TextView;
    private var retrofitInstance = RetrofitInstance;
    private lateinit var peopleCall: Call<People>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myTextView=findViewById(R.id.textView);
        myTextView.text="Champion Besiktas";
        peopleCall  = RetrofitInstance.StarWarsAPIcreater().getPeople();
        peopleCall.enqueue(object : Callback<People> {
            override fun onResponse(call: Call<People>, response: Response<People>) {
                if (response.isSuccessful) {
                    val person = response.body()  // API'den gelen veriyi alıyoruz
                    person?.let {
                        // Gelen kişinin adını TextView'e yazdırıyoruz
                        myTextView.text = it.name
                    }
                } else {
                    myTextView.text = "Failed to retrieve data"
                }
            }

            override fun onFailure(call: Call<People>, t: Throwable) {
                // Hata durumunda hata mesajını TextView'e yazdırıyoruz
                println(t.message);
            }
        })
    }



    }
