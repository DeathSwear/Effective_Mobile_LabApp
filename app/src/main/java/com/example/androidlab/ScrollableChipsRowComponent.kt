import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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