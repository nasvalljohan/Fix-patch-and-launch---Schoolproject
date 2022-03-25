package com.ploohan.android_studio_lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerViewActivityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerViewActivityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    //RecyclerView

    private val itemsList =  ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    private lateinit var viewFollow: View
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            val root = inflater.inflate(R.layout.fragment_recycler_view_activity, container, false)
            viewFollow = root

        // Inflate the layout for this fragment

        val recyclerView: RecyclerView = viewFollow.findViewById(R.id.recyclerView) //vår view
        customAdapter = CustomAdapter(itemsList)
        layoutManager = LinearLayoutManager(requireContext())

        // NEW - Interface (on Item Click)
        customAdapter.setOnItemClickListener(object: CustomAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                itemsList.removeAt(position)
                customAdapter.notifyItemRemoved(position)
            }
        })

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
        return root
    }

    private fun prepareItems(){
        for (index in 0..3){
            itemsList.add("Apples$index")
            itemsList.add("Bananas$index")
            itemsList.add("Bread$index")
            itemsList.add("Broccoli$index")
            itemsList.add("Milk$index")
            itemsList.add("Butter$index")
        }
        customAdapter.notifyDataSetChanged()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecyclerViewActivityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecyclerViewActivityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}