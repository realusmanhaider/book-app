package com.streetview.navigation.liveearth.satellite.booksapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.outlinedButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.streetview.navigation.liveearth.satellite.booksapp.R
import com.streetview.navigation.liveearth.satellite.booksapp.ui.activities.ui.theme.BooksAppTheme
import com.streetview.navigation.liveearth.satellite.booksapp.ui.theme.GreyClr
import com.streetview.navigation.liveearth.satellite.booksapp.ui.theme.TextColor

class BookDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksAppTheme {
                ConstraintSet()
            }
        }
    }
}


@Composable
@Preview
private fun ConstraintSet() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {


        val (first, second, third, fourth, fifth) = createRefs()


        Box(
            modifier = Modifier
                .fillMaxHeight(0.5F)
                .fillMaxWidth()
                .background(GreyClr)
                .constrainAs(second) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
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

        Image(
            painter = painterResource(id = R.drawable.backarrow),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(first) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
                .padding(start = 24.dp, top = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.bookmark),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(third) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(end = 24.dp, top = 24.dp)
        )

        Card(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(fourth) {
                    bottom.linkTo(second.bottom, margin = (-20).dp)
                    end.linkTo(parent.end)
                }
                .padding(end = 24.dp)
                .clip(CircleShape),
            backgroundColor = TextColor) {
            Image(
                painter = painterResource(id = R.drawable.hearticon),
                contentDescription = "Heart Icon",
                modifier = Modifier
                    .wrapContentSize()
                    .padding(10.dp)
            )
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5F)
            .padding(top = 24.dp, start = 16.dp)
            .constrainAs(fifth) {
                top.linkTo(second.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {

            Text(
                text = "Book Title",
                style = MaterialTheme.typography.h4
            )

            Text(
                text = "by Author",
                color = TextColor,
                fontSize = 18.sp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 36.dp, top = 20.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column() {
                    Text(text = "Rating", color = TextColor)
                    Text(text = "4.5")
                }


                Column() {
                    Text(text = "Pages", color = TextColor)
                    Text(text = "800")
                }

                Column() {
                    Text(text = "Language", color = TextColor)
                    Text(text = "ENG/INA")
                }

            }


            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla aliquet facilisis magna sit amet scelerisque. Pellentesque ut pretium diam. Fusce sit amet erat quis sem dictum pellentesque.",
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 10.dp, end = 26.dp),
                color = TextColor
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = { /*TODO*/ },
                    colors = outlinedButtonColors(backgroundColor = Color.Black),
                    modifier = Modifier
                        .padding(16.dp)
                        .height(50.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.playicon),
                        contentDescription = "Play icon",
                        tint = Color.White,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "Play Audio", color = Color.White)
                }


                Button(
                    onClick = { /*TODO*/ },
                    colors = outlinedButtonColors(backgroundColor = Color.White),
                    modifier = Modifier
                        .padding(16.dp)
                        .height(50.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bookreadingicon),
                        contentDescription = "Book Reading Icon",
                        tint = TextColor,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "Read Book", color = TextColor)
                }


            }

        }


    }


}

