package devandroid.nex.applistatarefas.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, NOME_BANDO_DADOS, null, VERSAO
) {

    companion object{
        const val NOME_BANDO_DADOS = "ListaTarefas.db"
        const val VERSAO = 1
        const val TABELA_TAREFAS = "tarefas"
        const val ID_TAREFA = "id_tarefa"
        const val DESCRICAO = "descricao"
        const val DATA_CADASTRO = "data_cadastro"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS $TABELA_TAREFAS (\n" +
                "\t $ID_TAREFA INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "   $DESCRICAO VARCHAR(70),\n" +
                "   $DATA_CADASTRO DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
                ");"
        try {
            db?.execSQL(sql)
        }catch ( e: Exception ){
            e.printStackTrace()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}