package com.omelchenkoaleks.soundrecorder.list_records

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omelchenkoaleks.soundrecorder.R
import com.omelchenkoaleks.soundrecorder.databinding.FragmentListRecordsBinding

class ListRecordsFragment : Fragment() {

    private var _binding: FragmentListRecordsBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListRecordsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}