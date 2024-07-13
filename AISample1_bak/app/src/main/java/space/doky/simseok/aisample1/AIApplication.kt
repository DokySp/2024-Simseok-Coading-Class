package space.doky.simseok.aisample1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import space.doky.simseok.sample1.util.ALog

class AIApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            ALog.i(TAG, "onCreate")
    }

    companion object {
        private val TAG = AIApplication::class.java.simpleName
    }
}