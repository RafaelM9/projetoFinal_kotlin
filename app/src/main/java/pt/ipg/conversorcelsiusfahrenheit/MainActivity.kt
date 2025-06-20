package pt.ipg.conversorcelsiusfahrenheit

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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.ipg.conversorcelsiusfahrenheit.ui.theme.ConversorCelsiusFahrenheitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConversorCelsiusFahrenheitTheme {
                    Surface( //cria superficie para ecra
                        modifier = Modifier.fillMaxSize(), // ocupa o ecra todo
                        color = Color(0xFFBBDEFB) // Mete o fundo azul-claro
                    ) {
                        //ConverterCelsiusFahrenheit() // chama a função do conversor
                        Navigation() // chama função que controla navegação do ficheiro Navigation.kt
                    }

            }
        }
    }
}




@Composable
fun ConverterCelsiusFahrenheit(navController: NavHostController, historico: MutableList<String>) {
    var celsiusParaFahrenheit by remember { mutableStateOf(true) } //variavel que guarda estado se conversao e celsius para fahrenheit

    var inputText by remember { mutableStateOf("") } // variavel que gurda texto introduzido pelo utilizador

    var resultadoConversao by remember { mutableStateOf("") } // variavel para guardar resultado da conversão


    Column( // coluna para organizar elementos na vertical
        modifier = Modifier // para alterações
            .padding(32.dp) //espaçamento de 32.dp
            .fillMaxSize(), // ocupa todo o espaço disponivel
        horizontalAlignment = Alignment.CenterHorizontally, //alinha elementos na horizontal no centro
        verticalArrangement = Arrangement.Center //Alinha os elementos na vertical no centro
    ) {
        Text( //texto que pede seleção do tipo de conversão
            text = stringResource(R.string.selecionar_tipo_de_convers_o), //permite a tradução automática da app para diferentes idiomas
            style = MaterialTheme.typography.titleMedium, //estilo do titulo medio
            modifier = Modifier.padding(bottom = 8.dp) //espaçamento de 8.dp na parte inferior
        )

        Row( //linha com um switch para alterar tipo de conversao
            verticalAlignment = Alignment.CenterVertically, //alinha vertical ao centro
            horizontalArrangement = Arrangement.Center, //alinha horizontal ao centro
            modifier = Modifier //para alterações
                .fillMaxWidth() // ocupa largura toda disponivel
                .padding(8.dp) //margem de 8.dp nos lados, topo e baixo
        ) {
            Text( // texto que indica o tipo de conversão (celsius pra fahrenheit)
                text = "Celsius -> Fahrenheit",
                modifier = Modifier.weight(1f), //ocupa metade da linha
                textAlign = TextAlign.End //alinha texto a direita
            )
            Switch( //switch para alterar entre tipos de conversao
                checked = !celsiusParaFahrenheit, //faz o inverso deivido a label trocar
                onCheckedChange = { celsiusParaFahrenheit = !it }, // altera o estado da variavel
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text( //texto que indica o tipo de conversão (fahrenheit pra celsius)
                text = "Fahrenheit -> Celsius",
                modifier = Modifier.weight(1f), // ocupa metade da linha
                textAlign = TextAlign.Start //alinha texto a esquerda
            )
        }

        //adiciona espaço na vertical entre o switch e campo de texto(TextField)
        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = inputText,
            onValueChange = { inputText = it }, //atualiza estado ao escrever
            label = { // esta muda de acordo com o tipo de conversão
                Text(
                    if (celsiusParaFahrenheit) {
                        stringResource(R.string.temperatura_em_celsius) //permite a tradução automática da app para diferentes idiomas
                    } else {
                        stringResource(R.string.temperatura_em_fahrenheit) //permite a tradução automática da app para diferentes idiomas
                    }
                )
            },
            // adiciona teclado numerico para introduzir numeros
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true, //texto introduzido numa linha
            modifier = Modifier.fillMaxWidth() //ocupa toda a largura disponivel
        )

        //espaço de 24.dp
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { //botão para conversao
            val valor = inputText.toDoubleOrNull() //converte texto inserido para double

            resultadoConversao = if (valor != null) { //se resultado for diferente de null, procede para a conversao
                val resultadoFormatado = if (celsiusParaFahrenheit) {
                    val resultado = (valor * 9 / 5) + 32
                    "%.1f ºF".format(resultado) //1 casa decimal e simbolo
                } else {
                    val resultado = (valor - 32) * 5 / 9
                    "%.1f ºC".format(resultado) //1 casa decimal e simbolo
                }

                // Guarda no histórico conversao
                historico.add("${inputText} -> $resultadoFormatado")
                resultadoFormatado //retorna valor formatado

            } else {
                //se valor não é valido mostra uma mensagem de erro
                "Valor invalido"
            }
        }) {
            Text(stringResource(R.string.converter)) //texto do botao
        }


        // espaço de 24.dp
        Spacer(modifier = Modifier.height(24.dp))

        //exibe resultado da conversao
        Text(
            text = resultadoConversao,
            style = MaterialTheme.typography.headlineMedium //estilo do resultado
        )

        //espaço entre botões
        Spacer(modifier = Modifier.height(16.dp))

        //botão para navegar para o histórico
        Button(
            onClick = {
                navController.navigate("historico") //abre historico
            }
        ) {
            Text(text = stringResource(R.string.ver_hist_rico))
        }

    }
}


@Composable
fun HistoricoConversoes(navController: NavHostController, historico: List<String>) {
    // ver lista de conversoes e voltar atras
    Column( //forma de coluna
        modifier = Modifier //para modificações
            .fillMaxSize() // ocupar espaço vertical disponivel
            .padding(16.dp) //espaçamento de 16.dp
    ) {
        // titulo da janela do historico
        Text(
            text = "Histórico de Conversões",
            style = MaterialTheme.typography.headlineMedium, // estilo do titulo
            modifier = Modifier.padding(bottom = 16.dp) //espaço inferior de 16.dp
        )

        // verifica se historico tem alguma coisa
        if (historico.isEmpty()) {
            Text("Nenhuma conversão realizada ainda.") // mensagem se tiver vazio
        } else {
            for (item in historico) {
                Text(text = item, // texto da conversao
                    modifier = Modifier.padding(vertical = 4.dp)) // espaço vertical 4.dp de cada item
            }
        }

        Spacer(modifier = Modifier.weight(1f)) //ocupa espaço restante para empurrar butao para o fim

        // botao para voltar para a tela principal
        Button(onClick = {
            navController.navigateUp() // navcontroller volta para a tela anterior
        }) {
            Text(stringResource(R.string.voltar)) // texto do botão
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConversorCelsiusFahrenheitTheme {
        ConverterCelsiusFahrenheit(navController = rememberNavController(), historico = mutableListOf())
    }
}