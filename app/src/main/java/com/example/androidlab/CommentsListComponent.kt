import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidlab.R
@Preview(showBackground = true)
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