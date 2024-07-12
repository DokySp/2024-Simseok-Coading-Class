package space.doky.simseok.sample1.util

import android.util.Log

class AIAppLog {
    companion object {
        private const val TAG = "AIApp"

        fun d(tag: String, functionName: String, msg: String = "") {
            Log.d(TAG, buildLog(tag, functionName, msg))
        }

        fun e(tag: String, functionName: String, msg: String = "") {
            Log.e(TAG, buildLog(tag, functionName, msg))
        }

        fun i(tag: String, functionName: String, msg: String = "") {
            Log.i(TAG, buildLog(tag, functionName, msg))
        }

        fun v(tag: String, functionName: String, msg: String = "") {
            Log.v(TAG, buildLog(tag, functionName, msg))
        }

        fun w(tag: String, functionName: String, msg: String = "") {
            Log.w(TAG, buildLog(tag, functionName, msg))
        }

        fun wtf(tag: String, functionName: String, msg: String = "") {
            Log.wtf(TAG, buildLog(tag, functionName, msg))
        }

        private fun buildLog(tag: String, functionName: String, message: String) =
            "[$tag] $functionName() - $message"
    }
}