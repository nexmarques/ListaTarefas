package devandroid.nex.applistatarefas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import devandroid.nex.applistatarefas.database.TarefaDAO
import devandroid.nex.applistatarefas.databinding.ActivityAdicionarTarefaBinding
import devandroid.nex.applistatarefas.model.Tarefa

class AdicionarTarefaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarTarefaBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        binding.btnSalvar.setOnClickListener {
            salvar()
        }
    }
    private fun salvar(){
        if( binding.editTarefa.text.isNotEmpty() ){
            val descricao = binding.editTarefa.text.toString()
            val tarefa = Tarefa(
                -1, descricao, "default"
            )
            val tarefaDAO = TarefaDAO(this)

            if(tarefaDAO.salvar(tarefa)){
                Toast.makeText(this, "Tarefa cadastrada com sucesso", Toast.LENGTH_SHORT).show()
                finish()
            }

        }else {
            Toast.makeText(this, "Preencha uma tarefa", Toast.LENGTH_SHORT).show()
        }
    }
}