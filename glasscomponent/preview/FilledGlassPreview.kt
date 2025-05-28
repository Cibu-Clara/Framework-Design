import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.hydrationglasscomponent.glasscomponent.FilledGlass

@Preview
@Composable
fun FilledGlassPreview() {
    FilledGlass(
        dailyGoal = 2000f,
        quantity = 1500f,
        units = "ml",
        fillColor = Color.Cyan,
    )
}
