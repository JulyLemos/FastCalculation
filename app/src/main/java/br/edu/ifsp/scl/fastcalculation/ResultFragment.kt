package br.edu.ifsp.scl.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ResultFragment : Fragment() {
    private lateinit var resultTextView: TextView
    private lateinit var restartButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultTextView = view.findViewById(R.id.result_text_view)
        restartButton = view.findViewById(R.id.restart_button)

        val result = arguments?.getInt("resultado")?: 0
        val totalQuestions = arguments?.getInt("totalQuestions")?: 10

        resultTextView.text = "Resultado: ${result} de ${totalQuestions}"

        restartButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.restart_button, GameFragment()).commit()
        }
    }
//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ResultFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}