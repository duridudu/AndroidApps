package com.example.etc_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RedFragment : Fragment() {
    override fun onCreateView(      // Fragment 의 layout 을 연결할 때 쓰는 callback
        inflater: LayoutInflater,   // 뷰를 생성하는 객체
        container: ViewGroup?,      // 생성할 뷰(자식 뷰)가 들어갈 부모 뷰
        saveInstanceState: Bundle?  // 이전 Fragment 객체에서 전달된 데이터(Bundle)
    ): View? {
        return inflater.inflate(R.layout.fragment_red, container, false);
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}