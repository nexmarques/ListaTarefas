package devandroid.nex.applistatarefas.adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devandroid.nex.applistatarefas.databinding.ItemTarefaBinding
import devandroid.nex.applistatarefas.model.Tarefa

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    fun recarregarLista(lista : List<Tarefa>){
        this.listaTarefa = lista
        notifyDataSetChanged()
    }

    private var listaTarefa : List<Tarefa> = emptyList()

    inner class TarefaViewHolder(itemBinding: ItemTarefaBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        private val binding: ItemTarefaBinding

        init {
            binding = itemBinding
        }

        fun bind( tarefa: Tarefa  ){
            binding.txtDescription.text = tarefa.descricao
            binding.txtDate.text = tarefa.dataCadastro
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemTarefa = ItemTarefaBinding.inflate(
            layoutInflater, parent, false
        )
        return TarefaViewHolder(itemTarefa)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listaTarefa[position]
        holder.bind( tarefa )
    }

    override fun getItemCount(): Int {
        return listaTarefa.size
    }
}