package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var dolar: Double = 20.0
    private var cantidad: Double = 1.0
    private var resultado: Double = 1.0

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonCalculate.setOnClickListener {
                operation()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun operation() {
        binding.apply {
            if (inputAccount.text.isEmpty() || inputDolarValue.text.isEmpty()) {
                textViewResult.text = "Ingresa Datos"
            } else {
                cantidad = inputAccount.text.toString().toDouble()
                dolar = inputDolarValue.text.toString().toDouble()
                resultado = cantidad * dolar
                textViewResult.text = resultado.toString()
            }
        }
    }
}