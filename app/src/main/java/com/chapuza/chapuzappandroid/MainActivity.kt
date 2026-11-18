package com.chapuza.chapuzappandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.chapuza.chapuzappandroid.core.navigation.MainScreen
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChapuZappAndroidTheme {
                MainScreen()
            }

        }
    }
}