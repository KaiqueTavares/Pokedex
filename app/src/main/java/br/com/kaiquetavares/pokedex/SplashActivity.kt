package br.com.kaiquetavares.pokedex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        carregar()
    }

    fun carregar(){
        val anim = AnimationUtils.loadAnimation(this,R.anim.splash)
        anim.reset()
        ivSplash.startAnimation(anim)

        //Aqui estou deixando 2 segundos para executar a minha funcao
        //PostDelayed({EXECUTA FUNCAO},TEMPO DE ESPERA)
        Handler().postDelayed({
            startActivity(Intent(this,ListaActivity::class.java))
            //Como isso é uma splash vou mata-la logo apos troca-la
            finish()
        },2000)
    }
}
