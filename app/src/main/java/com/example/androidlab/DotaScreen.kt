import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlab.R
import com.example.androidlab.ui.theme.colorBackground

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
                color = androidx.compose.ui.graphics.Color.Gray,
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
                color = androidx.compose.ui.graphics.Color.White,
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