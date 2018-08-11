package br.com.kaiquetavares.pokedex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.kaiquetavares.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        //IT -> ESTA RECEBENDO O OBJETO POKEMON LOGO NESTA PARTE USAREI TODA VEZ O IT
        //AQUI TEMOS UMA FUNÇÃO QUE RECEBE UMA LISTA DE DADOS O GETPOKEMONS
        //ELE RETORNA UM IT POIS NA LISTA POKEMON ADAPTER ESTOU DANDO ISSO:
        //val listener: (Pokemon) -> Unit) :
            rvPokemons.adapter = ListaPokemonAdapter(getPokemons(),this,{
        //Toast.makeText(this,it.nome,Toast.LENGTH_LONG).show()
                val telaDetalhe = Intent(this,DetalheActivity::class.java)
                telaDetalhe.putExtra("POKEMON", it)
                startActivity(telaDetalhe)
    })
        rvPokemons.layoutManager=LinearLayoutManager(this)
    }

    //Faço uma função que retorna uma lista preenchida
    fun getPokemons(): List<Pokemon>{
        return listOf(
                getMewtwo()
        )
    }

    //Função para criar cada pokemon
    fun getMewtwo():Pokemon{
        return Pokemon(150,
                "Mewtwo","Psy","bla bla bla",R.drawable.mewtwo)
    }
}
