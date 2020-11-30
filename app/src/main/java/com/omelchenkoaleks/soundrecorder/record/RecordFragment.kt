package com.omelchenkoaleks.soundrecorder.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omelchenkoaleks.soundrecorder.R
import com.omelchenkoaleks.soundrecorder.databinding.FragmentRecordBinding
import kotlinx.android.synthetic.main.fragment_record.*

class RecordFragment : Fragment() {

    private val logTag: String = RecordFragment::class.java.simpleName

    private var isStart: Boolean = true
    private var isPause: Boolean = true


    private var _binding: FragmentRecordBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecordBinding.inflate(layoutInflater, container, false)
        return mBinding.root


    }

    private fun onRecord(start: Boolean) {

        if (start) {
            // start recording
            record_fab.setImageResource(R.drawable.ic_stop_white)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}