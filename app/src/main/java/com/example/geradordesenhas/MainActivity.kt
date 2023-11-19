package com.example.geradordesenhas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.geradordesenhas.databinding.ActivityMainBinding

private fun Handler.postDelayed(function: () -> Unit) {

}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val alfabeto = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "]", "{", "}", ":", ";", "'", ",", "<", ".", ">", "?")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // UTILIZA A ANIMAÇÃO POR 1 SEGUNDO E OCULTA PARA FICAR VISIVEL A SENHA
        binding.btGerarSenha.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.txtsenha.visibility = View.INVISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                gerarSenhaAleatoria()

                binding.progressBar.visibility = View.GONE
                binding.txtsenha.visibility = View.VISIBLE

            }, 1000)
        }
    }

    private fun gerarSenhaAleatoria(){

        var senhaGerada = arrayListOf("")

        var i:  Int = 0
        while (i < 6 ){

            val itemAleatorio = (alfabeto.indices).random()

            senhaGerada.add(alfabeto[itemAleatorio])

            i= i+1

        }

        binding.txtsenha.text = senhaGerada.joinToString("").toString()

    }
}