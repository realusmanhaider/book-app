package com.streetview.navigation.liveearth.satellite.booksapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.streetview.navigation.liveearth.satellite.booksapp.R
import com.streetview.navigation.liveearth.satellite.booksapp.ui.theme.GreyClr


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val itemList = listOf(
            ListItem(R.drawable.imagesplash, "Title 1", "Subtitle 1"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            ListItem(R.drawable.imagesplash, "Title 2", "Subtitle 2"),
            // Add more items as needed
        )

        setContent {
            PageDesign(itemList)
        }
    }
}


@Composable
private fun PageDesign(itemList: List<ListItem>) {

    val inputvalue = remember { mutableStateOf(TextFieldValue()) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {

        val (topBox, searchBox, booksCollection, popularBooks) = createRefs()


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(topBox) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        ) {

            Row(modifier = Modifier.wrapContentSize()) {

                Text(
                    text = "Hi Marvel",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.wrapContentSize()
                )

                Image(
                    painter = painterResource(id = R.drawable.handshake),
                    contentDescription = "Hand shake",
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp)
                )
            }

            Text(
                text = "Track Your Book Reading",
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.h6
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(searchBox) {
                    top.linkTo(topBox.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            OutlinedTextField(
                value = inputvalue.value,
                onValueChange = { inputvalue.value = it },
                placeholder = { Text(text = "Search Box") },
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .background(Color.Transparent),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search icon"
                    )
                }
            )
        }



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(booksCollection) {
                    top.linkTo(searchBox.bottom)
                    start.linkTo(parent.start)
                }
        ) {


            Text(
                text = "Books Collection",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )


            LazyRow {
                itemsIndexed(items = itemList.chunked(2)) { index, chunkedList ->
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        chunkedList.forEach { item ->
                            Card(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                                elevation = 5.dp
                            ) {
                                Column(
                                    modifier = Modifier
                                        .width(160.dp), // Adjust the width as needed
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp)
                                            .background(GreyClr),
                                        contentAlignment = Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = item.imageResId),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .height(40.dp)
                                                .width(40.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = item.title,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colors.onSurface,
                                    )
                                    Text(
                                        text = item.subtitle,
                                        color = MaterialTheme.colors.onSurface,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }


    }

}

data class ListItem(val imageResId: Int, val title: String, val subtitle: String)
