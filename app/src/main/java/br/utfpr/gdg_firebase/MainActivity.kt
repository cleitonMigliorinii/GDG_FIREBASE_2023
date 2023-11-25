package br.utfpr.gdg_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.transition.Visibility
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    val bundle = Bundle().apply {
        putString("FirebaseAnalytics.Param.ITEM_ID", "1")
        putString("FirebaseAnalytics.Param.ITEM_NAME", "ENVIAR")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.btnEnvar)
        val botaoError = findViewById<Button>(R.id.btnNaoAconteceu)

        firebaseAnalytics = Firebase.analytics
        Firebase.analytics.setAnalyticsCollectionEnabled(true)

        btnSend.setOnClickListener {
           firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
            botaoError.visibility = View.VISIBLE
        }

        botaoError.setOnClickListener {
            throw RuntimeException("Test Crash")
        }



    }


}