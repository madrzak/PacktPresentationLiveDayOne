package ie.redstudio.packtpresentationlivedayone


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ListFragment : Fragment() {

    private lateinit var mViewModel: NewItemViewModel

    private lateinit var listAdapter: ItemRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewItemViewModel(activity!!.application)::class.java)

        mViewModel.allItems.observe(this, Observer {

            listAdapter.setData(it)

        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnGoToNew.setOnClickListener {
            (activity as? MainActivity)?.goToNewItemFragment()
        }

        listAdapter = ItemRecyclerAdapter()
        rvList.layoutManager = LinearLayoutManager(activity)
        rvList.adapter = listAdapter
    }


    override fun onResume() {
        super.onResume()

        mViewModel.retrieveItems()
    }


}
