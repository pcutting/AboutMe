import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nevie.aboutme.HobbiesViewAdapter
import com.nevie.aboutme.HobbyNewDialogFragment
import com.nevie.aboutme.R
import com.nevie.aboutme.databinding.FragmentHobbyBinding

class HobbyFragment: Fragment(R.layout.fragment_hobby), HobbyNewDialogFragment.OnClickListener {
    private val TAG = "HobbyFragment"
    private var fragmentHobbyBinding: FragmentHobbyBinding? = null

    private fun showDialog() {
        val dialog = HobbyNewDialogFragment.create(this)
        dialog.show(parentFragmentManager , "HobbyDialogFragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHobbyBinding.bind(view)
        fragmentHobbyBinding = binding

        binding.hobbiesFab.setOnClickListener {
            Log.d("FAB", "Fab got clicked in onViewCreated")
            showDialog()
        }

        binding.hobbyList.adapter = HobbiesViewAdapter()
        binding.hobbyList.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
    }

    override fun onDialogPositiveClick() {
        Log.d(TAG, " onDialogPositiveClick save clicked" )
    }

    override fun onDialogNegativeClick() {
        Log.d(TAG, " onDialogNegativeClick cancel clicked")
    }


}