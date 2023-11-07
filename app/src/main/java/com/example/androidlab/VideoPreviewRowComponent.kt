import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidlab.R
import com.example.androidlab.ui.theme.colorStartVideo

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