package devandroid.nex.applistatarefas.database

import devandroid.nex.applistatarefas.model.Tarefa

interface iTarefaDAO {
    fun salvar( tarefa : Tarefa) : Boolean
    fun atualizar( tarefa: Tarefa ) : Boolean
    fun deletar( id: Int ) : Boolean
    fun listar() : List<Tarefa>
}