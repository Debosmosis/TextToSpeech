package com.example.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.texttospeech.ui.theme.TextToSpeechTheme
import java.util.Locale

class MainActivity : ComponentActivity() {

    lateinit var tts : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1 = findViewById<Button>(R.id.btnSpeak)
        var e1 = findViewById<EditText>(R.id.edText)

        b1.setOnClickListener {
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it==TextToSpeech.SUCCESS) {

                    tts.language = Locale.US
                    tts.setSpeechRate(1.0f)
                    tts.speak(e1.text.toString(), TextToSpeech.QUEUE_ADD, null)
                }
            })
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextToSpeechTheme {
        Greeting("Android")
    }
}