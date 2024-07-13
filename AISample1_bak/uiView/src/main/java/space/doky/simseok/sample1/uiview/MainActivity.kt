package space.doky.simseok.sample1.uiview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import space.doky.simseok.sample1.uiview.databinding.ActivityMainBinding
import space.doky.simseok.sample1.util.AIAppLog


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val db = Firebase.database
    private var client: DatabaseReference? = null
    private var isChatInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonLogIn.setOnClickListener {
            logIn()
        }

        binding.buttonSend.setOnClickListener {
            if (!isChatInit) {
                addListener()
            }
            sendMessage("${binding.inputBoxMessage.text}")
        }
    }



    private fun logIn() {
        if (binding.inputBoxId.text.isEmpty()) {
            AIAppLog.e(TAG, "logIn", "empty id")
            return
        }

        client = db.getReference("id::${binding.inputBoxId.text}")
        AIAppLog.d(TAG, "logIn", "start to chat")
        AIAppLog.d(TAG, "logIn", "client info: $client")

        isChatInit = false
        client?.removeEventListener(getListener())
    }

    private fun sendMessage(message: String) {
        if (client == null) {
            AIAppLog.w(TAG, "sendMessage", "you should login first")
            return
        }

        client?.setValue(message)
        AIAppLog.d(TAG, "main", "client info: $client")
    }

    private fun addListener() {
        AIAppLog.d(TAG, "addListener", "start to listen")
        isChatInit = true
        client?.addValueEventListener(getListener())
    }

    private fun getListener() = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            val value = dataSnapshot.getValue<String>()
            AIAppLog.d(TAG, "getListener", "Value is: $value")
        }

        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            AIAppLog.w(TAG, "onCancelled", "Failed to read value. ${error.toException()}")
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}