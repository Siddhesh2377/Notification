import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import kotlinx.coroutines.delay
import java.awt.Shape

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var showNotification by remember { mutableStateOf(false) }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                text = "Hello, Desktop!"
                showNotification = true
            }) {
                Text(text)
            }
        }
    }

    if (showNotification) {
        Notification(text = text) {
            showNotification = false
        }
    }
}

@Composable
fun Notification(text: String, onClose: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        onClose()
    }

    Window(
        onCloseRequest = onClose,
        title = "Notification",
        resizable = false,
        undecorated = true,

        transparent = true,
        state = WindowState(width = 400.dp, height = 100.dp, placement = WindowPlacement.Floating, position = WindowPosition(Alignment.TopEnd))
    ) {
        MaterialTheme {
            Box(
                modifier = Modifier.fillMaxSize().padding(8.dp).clip(shape = RoundedCornerShape(10.dp)).background(MaterialTheme.colors.background),
                ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = text)
                }
            }

        }
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
