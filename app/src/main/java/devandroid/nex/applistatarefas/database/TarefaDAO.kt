package devandroid.nex.applistatarefas.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import devandroid.nex.applistatarefas.model.Tarefa

class TarefaDAO(context: Context) : iTarefaDAO {

    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(tarefa: Tarefa): Boolean {
        val valores = ContentValues()
        valores.put(
           "${DatabaseHelper.DESCRICAO}", tarefa.descricao
        )
        try {
            escrita.insert(
                DatabaseHelper.TABELA_TAREFAS,
                null,
                valores
            )
            Log.i("info_db", "Sucesso ao salvar")
            return true
        }catch ( e: Exception ){
            e.printStackTrace()
            Log.i("info_db", "Falha ao salvar")
        }
        return false
    }

    override fun atualizar(tarefa: Tarefa): Boolean {
        val valores = ContentValues()
        valores.put(
            "${DatabaseHelper.DESCRICAO}", tarefa.descricao
        )
        val args = arrayOf(tarefa.idTarefa.toString())
        try {
            escrita.update(
                DatabaseHelper.TABELA_TAREFAS,
                valores,
                "${DatabaseHelper.DESCRICAO} = ?",
                args
            )
            return true
        }catch ( e:Exception ){
            e.printStackTrace()
            Log.i("info_db", "Falha ao atualizar")
        }
        return false
    }

    override fun deletar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Tarefa> {
        TODO("Not yet implemented")
    }
}