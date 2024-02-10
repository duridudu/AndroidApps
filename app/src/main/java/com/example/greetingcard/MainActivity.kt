package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {
                    GreetingText()
                }
            }
        }
    }
}

@Composable
fun GreetingImage(modifier: Modifier){
    val image = painterResource(id = R.drawable.android_logo)
    Box{
        Image(
            modifier = modifier,
            painter = image,
            contentDescription = null,

       //     contentScale = ContentScale.Crop
            )
//        GreetingText(from = from, message = message, modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp))
    }
}

@Composable
fun GreetingText() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {

        GreetingImage(modifier= Modifier
            .fillMaxWidth(0.3f))

        Text(
            text = stringResource(R.string.my_name),
            fontSize = 50.sp,
            color = Color.White
        )
        Text(
            text = stringResource(R.string.my_job),
            fontSize = 25.sp,
            color = Green
        )
        Spacer(modifier = Modifier.padding(bottom = 200.dp))
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))

        ContactText(
            text = stringResource(R.string.my_number),  textBlur = 5.dp,
            icon = Icons.Rounded.Phone)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactText(
            text = stringResource(R.string.my_email), icon = Icons.Rounded.Email)
       }


}

@Composable
fun ContactText(text: String, icon: ImageVector, textBlur: Dp = 0.dp){
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Green,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(3f).blur(textBlur)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    GreetingCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF073042)
        ) {
            GreetingText()
        }
    }
}