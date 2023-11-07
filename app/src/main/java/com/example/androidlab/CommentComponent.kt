import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlab.ui.theme.colorDarkGray

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