package br.senai.sp.jandira.retrofit_reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

//        Açao do botão GET:
        findViewById<Button>(R.id.btnGET).setOnClickListener{
            getUserByID()
        }
    }

    private fun getUserByID() {

        lifecycleScope.launch {
//            chamada para endpoint
            val result = apiService.getUserByID("2")

            if(result.isSuccessful){

                Log.e("GETTING-DATA", "${result.body()?.data}")

            } else {

                Log.e("GETTING-DATA", "${result.message()}")

            }
        }
    }
}