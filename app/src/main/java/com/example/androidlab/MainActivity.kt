package com.example.androidlab

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.androidlab.ui.theme.AndroidLabTheme
import com.example.androidlab.ui.theme.colorBackground
import com.example.androidlab.ui.theme.colorDarkGray
import com.example.androidlab.ui.theme.colorChip
import com.example.androidlab.ui.theme.colorChipText
import com.example.androidlab.ui.theme.colorStartVideo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    AndroidLabTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DotaScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DotaScreen() {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor(colorBackground)))
    ) {
        item {
            DotaScreenHeader()
        }
        item {
            ScrollableChipsRow(
                items = listOf(
                    stringResource(id = R.string.chip1),
                    stringResource(id = R.string.chip2),
                    stringResource(id = R.string.chip3)
                ),
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
            )
            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 14.dp,
                    bottom = 14.dp,
                ),
                color = Color.Gray,
                //fontfamily = Sk-Modernist,
                fontSize = 12.sp,
                //fontStyle = FontStyle.FONT_WEIGHT_NORMAL,
                fontWeight = FontWeight.W400,
                lineHeight = 19.sp,
                letterSpacing = 0.5.sp
            )
        }
        item {
            VideoPreviewRow(
                previewResList = listOf(
                    R.drawable.video1,
                    R.drawable.video1
                ),
                contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
            )
        }
        item {
            Text(
                text = "Review & Ratings",
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 20.dp,
                    bottom = 12.dp,
                ),
                color = Color.White,
                //fontfamily = Sk-Modernist,
                fontSize = 16.sp,
                //fontStyle = FontStyle.FONT_WEIGHT_NORMAL,
                fontWeight = FontWeight.W700,
                lineHeight = 19.sp,
                letterSpacing = 0.6.sp
            )
            RatingBlock(
                rating = "4.9",
                reviewsCount = stringResource(id = R.string.count_reviewers),
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 30.dp,
                )
            )
        }
        item {
            CommentsList()
        }
        item {
            PrimaryOvalButton(
                text = stringResource(id = R.string.button_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        top = 40.dp,
                        bottom = 50.dp,
                    )
                    .height(height = 64.dp)
            )
        }
    }
}

@Composable
fun PrimaryOvalButton(text: String, modifier: Modifier = Modifier) {
    TextButton(
        onClick = { },
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFAC00))
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.6.sp
        )
    }
}


@Composable
fun Line() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 38.dp)
            .padding(vertical = 24.dp)
    ) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CommentsList() {
    Column {
        Comment(
            image = R.drawable.people1,
            name = stringResource(id = R.string.comment_name1),
            date = stringResource(id = R.string.comment_date),
            text = stringResource(id = R.string.comment_text)
        )
        Line()
        Comment(
            image = R.drawable.people2,
            name = stringResource(id = R.string.comment_name2),
            date = stringResource(id = R.string.comment_date),
            text = stringResource(id = R.string.comment_text)
        )
    }
}
@Composable
fun Comment(image: Int, name: String, date: String, text: String) {
    Column(modifier = Modifier.padding(start = 24.dp)) {
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = name,
                    color = Color.White,
                    //fontfamily = Sk-Modernist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = date,
                    color = Color(android.graphics.Color.parseColor(colorDarkGray)),
                    //fontfamily = Sk-Modernist,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    letterSpacing = 0.5.sp
                )
            }
        }
        Text(
            text = text,
            color = Color.Gray,
            //fontfamily = Sk-Modernist,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            letterSpacing = 0.5.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun DotaScreenHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(310.dp)
        )
        Box(
            modifier = Modifier
                .padding(top = 290.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                .background(Color(android.graphics.Color.parseColor(colorBackground)))
        ) {
            Column(
                modifier = Modifier.padding(start = 124.dp, bottom = 40.dp, top = 14.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.logo_text),
                    color = Color.White,
                    //fontfamily = Sk-Modernist,
                    fontSize = 20.sp,
                    //fontStyle = FontStyle.FONT_WEIGHT_NORMAL,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 26.sp,
                    letterSpacing = 0.5.sp
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stars5),
                        contentDescription = "image",
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .height(12.dp)
                            .width(76.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.count_reviewers),
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .padding(start = 10.dp),
                        color = Color(android.graphics.Color.parseColor(colorDarkGray)),
                        //fontfamily = Sk-Modernist,
                        fontSize = 12.sp,
                        //fontStyle = FontStyle.FONT_WEIGHT_NORMAL,
                        fontWeight = FontWeight.W400,
                        lineHeight = 26.sp,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 270.dp, start = 24.dp)
                .border(
                    width = 1.dp,
                    color = Color(android.graphics.Color.parseColor(colorDarkGray)),
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(17.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.dotaico),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
            )
        }
    }
}

@Composable
fun VideoPreviewRow(previewResList: List<Int>, contentPadding: PaddingValues) {
    LazyRow(contentPadding = contentPadding) {
        items(previewResList) { previewResId ->
            Box(modifier = Modifier.padding(end = 15.dp)){
                Image(
                    painter = painterResource(id = previewResId),
                    contentDescription = "image",
                    modifier = Modifier
                        .height(135.dp)
                        .width(240.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .size(48.dp)
                    .background(Color(android.graphics.Color.parseColor(colorStartVideo)))
                    .align(
                        Alignment.Center

                    )){
                    Image(
                        painter = painterResource(id = R.drawable.start),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(15.dp)
                            .align(Alignment.Center)
                    )
                }
            }

        }
    }
}

@Composable
fun RatingBlock(rating: String, reviewsCount: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = rating,
            color = Color.White,
            //fontfamily = Sk-Modernist,
            fontSize = 48.sp,
            //fontStyle = FontStyle.FONT_WEIGHT_NORMAL,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.5.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Image(
                painter = painterResource(id = R.drawable.stars5),
                contentDescription = "image",
                modifier = Modifier
                    .height(12.dp)
                    .width(76.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = reviewsCount,
                color = Color.Gray,
                //fontfamily = Sk-Modernist,
                fontSize = 12.sp,
                //fontStyle = FontStyle.FONT_WEIGHT_NORMAL,
                fontWeight = FontWeight.W400,
                lineHeight = 26.sp,
                letterSpacing = 0.5.sp
            )
        }
    }
}

@Composable
fun ScrollableChipsRow(items: List<String>, modifier: Modifier, contentPadding: PaddingValues) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items) { item ->
            Chip(text = item)
        }
    }
}

@Composable
fun Chip(text: String) {
    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .background(
                Color(android.graphics.Color.parseColor(colorChip)),
                shape = RoundedCornerShape(45.dp)
            )
            .padding(8.dp)
    ) {
        Text(
            text = text,
            color = Color(android.graphics.Color.parseColor(colorChipText)),
            //fontfamily = Sk-Modernist,
            fontSize = 10.sp,
            //fontStyle = FontStyle.FONT_WEIGHT_NORMAL,
            fontWeight = FontWeight.W500,
            letterSpacing = 0.5.sp
        )
    }
}
