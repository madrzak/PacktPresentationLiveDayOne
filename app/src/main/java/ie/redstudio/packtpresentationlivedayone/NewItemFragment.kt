package ie.redstudio.packtpresentationlivedayone


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_new_item.*


/**
 * A simple [Fragment] subclass.
 *
 */
class NewItemFragment : Fragment() {

    private lateinit var mViewModel: NewItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewItemViewModel(activity!!.application)::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_item, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button.setOnClickListener {

            val input = editText.text.toString()

            if (input.isEmpty()) {

                Toast.makeText(context, "Please enter some text to continue...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            } else if (input.length < 3) {

                Toast.makeText(context, "Input too short...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mViewModel.storeItem(input)

            Toast.makeText(context, "${input.capitalize()} entered", Toast.LENGTH_SHORT).show()

            (activity as? MainActivity)?.goToListFragment()
        }

        btnBack.setOnClickListener {

            (activity as? MainActivity)?.goToListFragment()

        }
    }


}
