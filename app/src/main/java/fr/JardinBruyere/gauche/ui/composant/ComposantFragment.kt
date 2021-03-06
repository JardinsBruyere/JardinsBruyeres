package fr.JardinBruyere.gauche.ui.composant

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.JardinBruyere.gauche.R
import fr.JardinBruyere.gauche.databinding.FragmentGalleryBinding
import fr.JardinBruyere.gauche.database.sensor.SensorAdapter
import fr.JardinBruyere.gauche.database.sensor.SensorViewModel
import java.text.SimpleDateFormat
import java.util.*

class ComposantFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView: RecyclerView = root.findViewById(R.id.recycleur_view_Component)
        val mComponentViewModel = ViewModelProvider(this)[SensorViewModel::class.java]
        val adapter = activity?.let { SensorAdapter(it.application) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager= LinearLayoutManager(context)
        mComponentViewModel.allWords.observe(viewLifecycleOwner, { words ->
            words?.let {
                adapter?.setWords(it)
            }
        })
        adapter?.notifyDataSetChanged()
        Log.e("Passage","fin recycler view")
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getDate(milliSeconds: Long, dateFormat: String?): String? {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat(dateFormat)

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar: Calendar = Calendar.getInstance()
        calendar.setTimeInMillis(milliSeconds)
        return formatter.format(calendar.getTime())
    }
}