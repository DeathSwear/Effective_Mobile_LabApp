import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlab.R

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