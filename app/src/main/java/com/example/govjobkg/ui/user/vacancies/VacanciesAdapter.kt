package com.example.govjobkg.ui.user.vacancies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.govjobkg.databinding.ItemVacancyInListBinding
import com.example.govjobkg.network.models.Vacancy

class VacanciesAdapter(private val onClick: () -> Unit) : RecyclerView.Adapter<VacanciesAdapter.VacanciesViewHolder>() {

    private var list = listOf<Vacancy>()

    fun setList(vacancies: List<Vacancy>) {
        list = vacancies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesViewHolder {
        return VacanciesViewHolder(
            ItemVacancyInListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VacanciesViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class VacanciesViewHolder(private val binding: ItemVacancyInListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(vacancy: Vacancy) {
            binding.tvTitle.text = vacancy.jobTitle
            binding.tvCompany.text = vacancy.company
            binding.tvSalary.text = vacancy.salary
            binding.tvExperience.text = vacancy.experience

            itemView.setOnClickListener {
                onClick()
            }
        }
    }

}
