package space.doky.simseok.sample2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import space.doky.simseok.sample2.uiview.util.AIAppLog

class AIApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            AIAppLog.i(TAG, "onCreate")
    }

    companion object {
        private val TAG = AIApplication::class.java.simpleName
    }
}