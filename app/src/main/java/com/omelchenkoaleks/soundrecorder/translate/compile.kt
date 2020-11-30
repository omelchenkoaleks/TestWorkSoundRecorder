package com.omelchenkoaleks.soundrecorder.translate

import android.os.Parcel
import android.os.Parcelable


//class RecordingItem : Parcelable {
//    var name // file name
//            : String? = null
//    var filePath //file path
//            : String? = null
//    var id //id in database
//            = 0
//    var length // length of recording in seconds
//            = 0
//    var time // date/time of the recording
//            : Long = 0
//
//    constructor() {}
//    constructor(`in`: Parcel) {
//        name = `in`.readString()
//        filePath = `in`.readString()
//        id = `in`.readInt()
//        length = `in`.readInt()
//        time = `in`.readLong()
//    }
//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        dest.writeInt(id)
//        dest.writeInt(length)
//        dest.writeLong(time)
//        dest.writeString(filePath)
//        dest.writeString(name)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object {
//        val CREATOR: Parcelable.Creator<RecordingItem> =
//            object : Parcelable.Creator<RecordingItem?> {
//                override fun createFromParcel(`in`: Parcel): RecordingItem? {
//                    return RecordingItem(`in`)
//                }
//
//                override fun newArray(size: Int): Array<RecordingItem?> {
//                    return arrayOfNulls(size)
//                }
//            }
//    }
//}



//import android.app.Fragment
//import android.content.Intent
//import android.os.Bundle
//import android.os.Environment
//import android.os.SystemClock
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.view.WindowManager
//import android.widget.Button
//import android.widget.Chronometer
//import android.widget.Chronometer.OnChronometerTickListener
//import android.widget.TextView
//import android.widget.Toast
//import java.io.File
//
//class RecordFragment : Fragment() {
//    private var position = 0
//
//    //Recording controls
//    private var mRecordButton: FloatingActionButton? = null
//    private var mPauseButton: Button? = null
//    private var mRecordingPrompt: TextView? = null
//    private var mRecordPromptCount = 0
//    private var mStartRecording = true
//    private var mPauseRecording = true
//    private var mChronometer: Chronometer? = null
//    var timeWhenPaused: Long = 0 //stores time when user clicks pause button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        position = arguments.getInt(ARG_POSITION)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle
//    ): View? {
//        val recordView: View = inflater.inflate(R.layout.fragment_record, container, false)
//        mChronometer = recordView.findViewById<View>(R.id.chronometer) as Chronometer
//        //update recording prompt text
//        mRecordingPrompt = recordView.findViewById<View>(R.id.recording_status_text) as TextView
//        mRecordButton = recordView.findViewById<View>(R.id.btnRecord) as FloatingActionButton
//        mRecordButton.setColorNormal(resources.getColor(R.color.primary))
//        mRecordButton.setColorPressed(resources.getColor(R.color.primary_dark))
//        mRecordButton.setOnClickListener(View.OnClickListener {
//            onRecord(mStartRecording)
//            mStartRecording = !mStartRecording
//        })
//        mPauseButton = recordView.findViewById<View>(R.id.btnPause) as Button
//        mPauseButton!!.visibility = View.GONE //hide pause button before recording starts
//        mPauseButton!!.setOnClickListener {
//            onPauseRecord(mPauseRecording)
//            mPauseRecording = !mPauseRecording
//        }
//        return recordView
//    }
//
//    // Recording Start/Stop
//    //TODO: recording pause
//    private fun onRecord(start: Boolean) {
//        val intent = Intent(activity, RecordingService::class.java)
//        if (start) {
//            // start recording
//            mRecordButton.setImageResource(R.drawable.ic_media_stop)
//            //mPauseButton.setVisibility(View.VISIBLE);
//            Toast.makeText(activity, R.string.toast_recording_start, Toast.LENGTH_SHORT).show()
//            val folder =
//                File(Environment.getExternalStorageDirectory().toString() + "/SoundRecorder")
//            if (!folder.exists()) {
//                //folder /SoundRecorder doesn't exist, create the folder
//                folder.mkdir()
//            }
//
//            //start Chronometer
//            mChronometer!!.base = SystemClock.elapsedRealtime()
//            mChronometer!!.start()
//            mChronometer!!.onChronometerTickListener = OnChronometerTickListener {
//                if (mRecordPromptCount == 0) {
//                    mRecordingPrompt!!.text =
//                        getString(R.string.record_in_progress).toString() + "."
//                } else if (mRecordPromptCount == 1) {
//                    mRecordingPrompt!!.text =
//                        getString(R.string.record_in_progress).toString() + ".."
//                } else if (mRecordPromptCount == 2) {
//                    mRecordingPrompt!!.text =
//                        getString(R.string.record_in_progress).toString() + "..."
//                    mRecordPromptCount = -1
//                }
//                mRecordPromptCount++
//            }
//
//            //start RecordingService
//            activity.startService(intent)
//            //keep screen on while recording
//            activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
//            mRecordingPrompt!!.text = getString(R.string.record_in_progress).toString() + "."
//            mRecordPromptCount++
//        } else {
//            //stop recording
//            mRecordButton.setImageResource(R.drawable.ic_mic_white_36dp)
//            //mPauseButton.setVisibility(View.GONE);
//            mChronometer!!.stop()
//            mChronometer!!.base = SystemClock.elapsedRealtime()
//            timeWhenPaused = 0
//            mRecordingPrompt!!.text = getString(R.string.record_prompt)
//            activity.stopService(intent)
//            //allow the screen to turn off again once recording is finished
//            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
//        }
//    }
//
//    //TODO: implement pause recording
//    private fun onPauseRecord(pause: Boolean) {
//        if (pause) {
//            //pause recording
//            mPauseButton!!.setCompoundDrawablesWithIntrinsicBounds(
//                R.drawable.ic_media_play,
//                0,
//                0,
//                0
//            )
//            mRecordingPrompt!!.text = getString(R.string.resume_recording_button).toUpperCase()
//            timeWhenPaused = mChronometer!!.base - SystemClock.elapsedRealtime()
//            mChronometer!!.stop()
//        } else {
//            //resume recording
//            mPauseButton!!.setCompoundDrawablesWithIntrinsicBounds(
//                R.drawable.ic_media_pause,
//                0,
//                0,
//                0
//            )
//            mRecordingPrompt!!.text = getString(R.string.pause_recording_button).toUpperCase()
//            mChronometer!!.base = SystemClock.elapsedRealtime() + timeWhenPaused
//            mChronometer!!.start()
//        }
//    }
//
//    companion object {
//        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//        private const val ARG_POSITION = "position"
//        private val LOG_TAG = RecordFragment::class.java.simpleName
//
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @return A new instance of fragment Record_Fragment.
//         */
//        fun newInstance(position: Int): RecordFragment {
//            val f = RecordFragment()
//            val b = Bundle()
//            b.putInt(ARG_POSITION, position)
//            f.arguments = b
//            return f
//        }
//    }
//}