package pt.ipg.converterfahrenheitcelsius

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.ipg.converterfahrenheitcelsius.ui.theme.ConverterFahrenheitCelsiusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConverterFahrenheitCelsiusTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFBBDEFB)
                    ) {
                    ConverterFahrenheitCelsius()
                }
            }
        }
    }
}

@Composable
fun ConverterFahrenheitCelsius(){
    var inputText by remember { mutableStateOf("") }

    var resultadoConversao by remember { mutableStateOf("") }

    var fahrenheitParaCelsious by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.selecionar_tipo_de_convers_o),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Fahrenheit → Celsius",
                modifier = Modifier.weight(1f),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )
            Switch(
                checked = !fahrenheitParaCelsious,
                onCheckedChange = { fahrenheitParaCelsious = !it },
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = "Celsius → Fahrenheit",
                modifier = Modifier.weight(1f),
                textAlign = androidx.compose.ui.text.style.TextAlign.Start
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = inputText,
            onValueChange = {inputText = it},
            label = {
                Text(
                    if (fahrenheitParaCelsious) {
                        stringResource(R.string.temperatura_em_fahrenheit)
                    }else {
                        stringResource(R.string.temperatura_em_celsius)
                    }
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true, // faz com que texto fique numa linha só
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val value = inputText.toDoubleOrNull()
            resultadoConversao = if(value != null){
                if (fahrenheitParaCelsious){
                    val result = (value - 32) * 5 / 9
                    "%.1f ºC".format(result)
                }else{
                    val result = (value * 9 / 5) + 32
                    "%.1f ºF".format(result)
                }
            } else {
                "Valor inválido"
            }
        }) {
            Text(stringResource(R.string.converter))
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = resultadoConversao,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}


//private fun converterParaCelsius(fahrenheit: Double): Double{
//    return (fahrenheit - 32) * 5/9
//}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConverterFahrenheitCelsiusTheme {
        ConverterFahrenheitCelsius()
    }
}