package com.streetview.navigation.liveearth.satellite.booksapp.ui.activities

import android.app.Activity
import android.content.Intent
import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.print.PrintAttributes.Margins
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.streetview.navigation.liveearth.satellite.booksapp.R
import com.streetview.navigation.liveearth.satellite.booksapp.ui.theme.GreyBox
import com.streetview.navigation.liveearth.satellite.booksapp.ui.theme.GreyClr
import com.streetview.navigation.liveearth.satellite.booksapp.ui.theme.TextColorLight
import kotlinx.coroutines.*

lateinit var job: Job

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashScreen()
        }

        job = CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}


@Composable
@Preview
fun SplashScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight(0.5F)
                .fillMaxWidth()
                .background(GreyClr)
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagesplash),
                contentDescription = "Splash Image",
                modifier = Modifier
                    .align(
                        alignment = Alignment.Center
                    )
                    .wrapContentSize()
            )


        }

        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Read In Your Comfortable Way!",
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )

                Text(
                    text = "Keep track of your book reading habit on daily basis with us",
                    textAlign = TextAlign.Center,
                    style = TextStyle(color = TextColorLight),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(16.dp)
                )


                Box(
                    modifier = Modifier
                        .size(60.dp, 60.dp)
                        .background(GreyBox)
                        .align(Alignment.CenterHorizontally)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .clickable {
                            job.cancel()
                            context.startActivity(Intent(context, MainActivity::class.java))
                            (context as Activity).finish()
                        }
                ) {
                    Image(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = R.drawable.arrownext),
                        contentDescription = "Next Arrow"
                    )
                }


            }
        }


    }

}