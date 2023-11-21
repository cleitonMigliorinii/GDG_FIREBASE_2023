package br.utfpr.gdg_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    val bundle = Bundle().apply {
        putString("FirebaseAnalytics.Param.ITEM_ID", "1")
        putString("FirebaseAnalytics.Param.ITEM_NAME", "COCA")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoSucesso = findViewById<Button>(R.id.meuBotao)
        val botaoErro = findViewById<Button>(R.id.botaoErro)

        firebaseAnalytics = Firebase.analytics
        Firebase.analytics.setAnalyticsCollectionEnabled(true)

        botaoSucesso.setOnClickListener {
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
        }

        botaoErro.setOnClickListener {
            throw RuntimeException("Test Crash")
        }




    }


}