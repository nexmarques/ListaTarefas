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
            DatabaseHelper.DESCRICAO, tarefa.descricao
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
            DatabaseHelper.DESCRICAO, tarefa.descricao
        )
        val args = arrayOf(tarefa.descricao)
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
        val args = arrayOf(id.toString())
        try {
            escrita.delete(
                DatabaseHelper.TABELA_TAREFAS,
                "${DatabaseHelper.ID_TAREFA} = ? ",
                args
            )
            Log.i("info_db", "Sucesso ao deletar")
            return true
        }catch (e : Exception){
            Log.i("info_db", "Erro ao deletar")
        }
        return false
    }

    override fun listar(): List<Tarefa> {
        val list = mutableListOf<Tarefa>()
        val sql = "SELECT \n" +
                "${DatabaseHelper.ID_TAREFA}, ${DatabaseHelper.DESCRICAO},\n" +
                "strftime('%d/%m/%Y %H:%M', ${DatabaseHelper.DATA_CADASTRO})\n" +
                "FROM ${DatabaseHelper.TABELA_TAREFAS};"

        val cursor = leitura.rawQuery(sql, null)
        val indiceId = cursor.getColumnIndex(DatabaseHelper.ID_TAREFA)
        val indiceDescricao = cursor.getColumnIndex(DatabaseHelper.DATA_CADASTRO)
        val indiceDataCadastro = cursor.getColumnIndex(DatabaseHelper.DATA_CADASTRO)
        while(cursor.moveToNext()){
            val idTarefa = cursor.getInt(indiceId)
            val descricao = cursor.getString(indiceDescricao)
            val dataCadastro = cursor.getString(indiceDataCadastro)
            list.add(
                Tarefa(idTarefa,descricao,dataCadastro)
            )
        }
        return list
    }
}