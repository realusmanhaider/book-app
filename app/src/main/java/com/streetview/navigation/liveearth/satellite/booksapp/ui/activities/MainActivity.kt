package com.streetview.navigation.liveearth.satellite.booksapp.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.streetview.navigation.liveearth.satellite.booksapp.R


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            PreviewComposeable()
        }
    }
}


@Composable
private fun PageDesign(itemList: List<ListItem>) {

    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    val context = LocalContext.current

    ConstraintLayout(
        modifier = Modifier
            .wrapContentSize()
            .verticalScroll(state = scrollState)
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
                value = inputValue.value,
                onValueChange = { inputValue.value = it },
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


            LazyRow(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(items = itemList) { index, item ->
                    Card(
                        modifier = Modifier
                            .width(160.dp)
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                            .clickable { onItemClick(item, context) },
                        elevation = 5.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(Color.Gray),
                                contentAlignment = Alignment.Center
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
                                color = MaterialTheme.colors.onSurface
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

            LazyRow(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(items = itemList) { index, item ->
                    Card(
                        modifier = Modifier
                            .width(160.dp)
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                            .clickable { onItemClick(item, context) },
                        elevation = 5.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(Color.Gray),
                                contentAlignment = Alignment.Center
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
                                color = MaterialTheme.colors.onSurface
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


        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .constrainAs(popularBooks) {
                top.linkTo(booksCollection.bottom)
                start.linkTo(parent.start)
            }) {

            Text(
                text = "Popular Books",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
            LazyRow(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(items = itemList) { index, item ->
                    Card(
                        modifier = Modifier
                            .width(160.dp)
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                            .clickable { onItemClick(item, context) },
                        elevation = 5.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(Color.Gray),
                                contentAlignment = Alignment.Center
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
                                color = MaterialTheme.colors.onSurface
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

@Composable
@Preview
private fun PreviewComposeable() {

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

    PageDesign(itemList = itemList)

}


private fun onItemClick(item: ListItem, context: Context) {

    context.startActivity(Intent(context, BookDetailsActivity::class.java))


}

data class ListItem(val imageResId: Int, val title: String, val subtitle: String)
