# Conversor Celsius ↔ Fahrenheit

Esta Aplicação Android  foi desenvolvida em Kotlin com Jetpack Compose no Android Studio, esta permite converter temperaturas entre Celsius -> Fahrenheit e Fahrenheit -> Celsius, utilizando um Switch para alternar entre estes dois tipos de conversão.

<br>

## 📱 Funcionalidades

- Conversão entre Celsius e Fahrenheit
- Conversão entre Fahrenheit e Celsius
- Interface construída com Jetpack Compose
- Tem suporte a internacionalização (idiomas)
- Layout responsivo, adaptado a ecrãs diferentes

<br>

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Kotlin
- **UI:** Jetpack Compose (sem uso de XML)
- **Framework:** Android SDK
- **Control de versões:** Git
- **Plataforma onde código foi alojado:** GitHub

<br>

## 🚀 Instruções de Instalação e Execução

1. **Pré-requisitos:**
   - Android Studio instalado (recomendado: versão mais recente).
   - JDK 17 ou superior.
   - Andorid SDK (versão utilizada foi 15.0)
   - Android Emulator hyperviser
   - Ligação à internet para sincronizar dependências.

2. **Clonar o repositório:**

   ***Se for por Interface Gráfica:***
   1. Abra o Android Studio.
   2. Na tela inicial, clique em "Clonar repositório".
   3. Cole o URL do repositório no campo indicado.
   4. Escolha o caminho da pasta local onde deseja salvar o projeto.
   5. Clique em "Clonar".
   6. O Android Studio irá baixar o projeto e abrir automaticamente. quando concluido.

   ***Se for por Linha de Comandos:***
   ```bash
   git clone https://github.com/RafaelM9/projetoFinal_kotlin.git
3. **Abir Projeto no Android Studio:**
   - Abrir Android Studio.
   - Selecionar "Open" (caso já tenha feito o clone do repositorio). 
   - Deve ir até a pasta onde está localizado o clone do projeto.

4. **Executar a aplicação:**
   - Deve-se ligar o dispositivo Android iniciando o Emulador.
   - Deve depois clicar em Run (ícone de play verde) para este compilar e correr a aplicação.


## ⚙️ Funcionalidades da Aplicação
A aplicação permite ao utilizador:

- Escolher o tipo de conversão:
    - Celsius para Fahrenheit
    - Fahrenheit para Celsius

- Introduzir um valor de temperatura através de um campo de texto (TextBox) com teclado numérico.

- Ver o resultado da conversão formatado com uma casa decimal e o símbolo da unidade de temperatura correspondente. (Resultado é exibido quando clicado o botão "Converter")

- Alternar facilmente entre os dois modos de conversão utilizando um `Switch` intuitivo.

- Visualização clara e centrada dos elementos com design responsivo adaptado a diferentes tamanhos de ecrã.

- Interface em português com suporte para internacionalização (traduções futuras facilitadas com `stringResource`).

<br>

## 📁 Organização do Projeto
```
ConversorCelsiusFahrenheit/
├── .gitignore                     # Ficheiros e pastas ignoradas pelo Git
├── build.gradle                   # Configuração do projeto (nível root)
├── settings.gradle                # Definições dos módulos do projeto
├── app/
│   ├── build.gradle               # Configuração específica do módulo 'app'
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml    # Declaração da MainActivity e permissões
│   │   │   ├── java/
│   │   │   │   └── pt/ipg/conversorcelsiusfahrenheit/
│   │   │   │       └── MainActivity.kt   # Lógica principal da aplicação
│   │   │   ├── res/
│   │   │   │   ├── values/                # Strings e temas em português (pt)
│   │   │   │   │   └── strings.xml
│   │   │   │   ├── values-en/             # Strings em inglês
│   │   │   │   │   └── strings.xml
│   │   │   │   ├── values-es/             # Strings em espanhol
│   │   │   │   │   └── strings.xml
```
