package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(SimpleMessage("Max Mayweather", "why not always something everywhere some of the time? And now the question, what happens with overflow..."))
        }
    }
}

//simple Class providing "data structure" Class
data class SimpleMessage(val author: String, val body: String)

//base function to create a new Message Card in Layout
@Composable
fun MessageCard(msg: SimpleMessage) {
    Row(
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }

    }

}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(SimpleMessage("author", "some message body"))
}