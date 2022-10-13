package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * SampleData for Jetpack Compose Tutorial
 */
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        SimpleMessage(
            "Lexi",
            "Test...Test...Test..."
        ),
        SimpleMessage(
            "Lexi",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        SimpleMessage(
            "Lexi",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        SimpleMessage(
            "Lexi",
            "Searching for alternatives to XML layouts..."
        ),
        SimpleMessage(
            "Lexi",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        SimpleMessage(
            "Lexi",
            "It's available from API 21+ :)"
        ),
        SimpleMessage(
            "Lexi",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        SimpleMessage(
            "Lexi",
            "Android Studio next version's name is Arctic Fox"
        ),
        SimpleMessage(
            "Lexi",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        SimpleMessage(
            "Lexi",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        SimpleMessage(
            "Lexi",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        SimpleMessage(
            "Lexi",
            "Previews are also interactive after enabling the experimental setting"
        ),
        SimpleMessage(
            "Lexi",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(SimpleMessage("Max Mayweather", "why not always something everywhere some of the time? And now the question, what happens with overflow..."))
            Conversation(messages = SampleData.conversationSample)
        }
    }
}

//simple Class providing "data structure" Class
data class SimpleMessage(val author: String, val body: String)

@Composable
fun Conversation(messages: List<SimpleMessage>){
    LazyColumn{
        items(messages) {
            message -> MessageCard(message)
        }
    }
}

//base function to create a new Message Card in Layout
@Composable
fun MessageCard(msg: SimpleMessage) {

    ComposeTutorialTheme{
        Surface(modifier = Modifier.fillMaxSize()){
            Row(
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_picture),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),

                    )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = msg.author,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Surface(shape =  CircleShape, shadowElevation = 1.dp){
                        Text(
                            text = msg.body,
                            modifier = Modifier.padding(all = 8.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview(name = "Light Mode")
@Composable
fun PreviewMessageCard(){
    ComposeTutorialTheme {
        Surface {
            MessageCard(msg = SimpleMessage("author", "some message body"))
        }
    }
}


