package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinContext { // หรือ KoinApplication
                App() // ฟังก์ชัน App หลักของคุณจาก shared module (ถ้ามี)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
