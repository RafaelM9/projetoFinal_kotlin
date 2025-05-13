package pt.ipg.converterfahrenheitcelsius

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.ipg.converterfahrenheitcelsius.ui.theme.ConverterFahrenheitCelsiusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConverterFahrenheitCelsiusTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ConverterFahrenheitCelsius()
                }
            }
        }
    }
}

@Composable
fun ConverterFahrenheitCelsius(){
    var fahrenheitInput by remember { mutableStateOf("") }

    val fahrenheit = fahrenheitInput.toDoubleOrNull()
    val celsius = fahrenheit?.let { (it - 32) * 5 / 9 }

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = fahrenheitInput,
            onValueChange = {fahrenheitInput = it},
            label = { Text("Temperatura em Fahrenheit") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConverterFahrenheitCelsiusTheme {
        ConverterFahrenheitCelsius()
    }
}