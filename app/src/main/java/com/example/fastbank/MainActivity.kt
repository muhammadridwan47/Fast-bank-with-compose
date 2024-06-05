package com.example.fastbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fastbank.ui.theme.FastBankTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FastBankTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)
                HomeScreen()
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
   Scaffold(
       bottomBar = {
            BottomNavigationBar()
       }
   ) { innerPadding ->
           Column(
               modifier = Modifier
               .fillMaxSize()
               .padding(innerPadding)
           ) {
           WalletSection()
           CardsSection()
           Spacer(modifier = Modifier.height(16.dp))
           FinanceSection()
           CurrenciesSection()
       }
   }
}
