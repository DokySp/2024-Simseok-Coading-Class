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
import space.doky.simseok.sample1.uiview.util.AIAppLog


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val db = Firebase.database
    private var client: DatabaseReference? = null
    private var clientListener: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 로그인 버튼
        binding.buttonLogIn.setOnClickListener {
            logIn()
        }

        // 전송 버튼
        binding.buttonSend.setOnClickListener {
            sendMessage("${binding.inputBoxMessage.text}")
        }
    }

    private fun logIn() {
        if (binding.inputBoxId.text.isEmpty()) {
            AIAppLog.e(TAG, "logIn", "empty id")
            return
        }
        stopChat()

        val id = "id::${binding.inputBoxId.text}"
        startChat(id)
    }



    // =============================================================================================



    private fun sendMessage(message: String) {
        if (client == null) {
            AIAppLog.w(TAG, "sendMessage", "you should login first")
            return
        }

        client?.setValue(message)
        AIAppLog.d(TAG, "main", "client info: $client")
    }

    private fun startChat(id: String) {
        client = db.getReference(id)
        AIAppLog.d(TAG, "startToChat", "client id: $id")

        clientListener = buildListener()
        clientListener?.let { listener ->
            AIAppLog.d(TAG, "startToChat", "start to listen")
            client?.addValueEventListener(listener)
        }
    }

    private fun stopChat() {
        clientListener?.let { listener ->
            AIAppLog.d(TAG, "stopToChat", "stop to listen")
            client?.removeEventListener(listener)
        }
    }

    private fun buildListener(): ValueEventListener =
        object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<String>()
                AIAppLog.d(TAG, "buildListener", "value: $value")
                binding.chatMessage.text = "server -> $value"
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                AIAppLog.w(TAG, "buildListener", "Failed to read value. ${error.toException()}")
            }
        }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}