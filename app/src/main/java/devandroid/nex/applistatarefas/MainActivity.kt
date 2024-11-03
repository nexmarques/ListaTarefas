package devandroid.nex.applistatarefas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import devandroid.nex.applistatarefas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView( binding.root )

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AdicionarTarefaActivity::class.java)

            startActivity(intent)
        }


    }
}