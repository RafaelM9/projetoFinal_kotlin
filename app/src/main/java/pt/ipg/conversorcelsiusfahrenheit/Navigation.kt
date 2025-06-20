package pt.ipg.conversorcelsiusfahrenheit


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
//cria navegardor de navegação para gerir navegaçãp entre telas
fun Navigation() {

    val navController = rememberNavController() // variavel que controla navegação

    // Lista mutável que guarda o histórico de conversões
    // remember para guardar daddos quando a função é recriada
    val historico = remember { mutableStateListOf<String>() }

    //define NavHost que é container das janelas de navegação
    // navController controla a navegação
    // starDestination define a tela inicial
    NavHost(navController = navController, startDestination = "converter") {
        // define tela converter  usa a função ConverterCelsiusFahrenheit
        composable("converter") {
            // mostra ecra principal do conversor
            ConverterCelsiusFahrenheit(navController, historico)
        }

        // janela historico usa a função HistoricoConversoes
        composable("historico") {
            // mostra ecra do historico
            HistoricoConversoes(navController, historico)
        }
    }
}
