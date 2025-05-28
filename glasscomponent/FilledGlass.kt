import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import androidx.compose.material3.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import com.example.hydrationglasscomponent.R

const val GLASS_HEIGHT = 230
const val GLASS_WIDTH = 172

@Composable
fun FilledGlass(
    modifier: Modifier = Modifier,
    dailyGoal: Float,
    quantity: Float,
    units: String,
    fillColor: Color,
) {
    val filledGlassImage = ImageBitmap.imageResource(id = R.drawable.glass_filled)
    val emptyGlassImage = painterResource(id = R.drawable.glass_empty)
    val hydrationPercent by rememberSaveable { mutableIntStateOf(computeHydrationPercent(quantity, dailyGoal)) }
    val hydrationLevel: Float = computeHydrationLevel(hydrationPercent, GLASS_HEIGHT)

    Box(modifier = modifier.padding(12.dp)) {
        Box(
            modifier = Modifier
                .width(GLASS_WIDTH.dp)
                .height(GLASS_HEIGHT.dp)
                .drawWithContent {
                    with(drawContext.canvas.nativeCanvas) {
                        val checkPoint = saveLayer(null, null)
                        drawContent()
                        drawImage(
                            image = filledGlassImage,
                            dstSize = IntSize(GLASS_WIDTH.dp.toPx().toInt(), GLASS_HEIGHT.dp.toPx().toInt()),
                            blendMode = BlendMode.DstIn
                        )
                        restoreToCount(checkPoint)
                    }
                }
        ) {
            Box(
                modifier = Modifier
                    .width(GLASS_WIDTH.dp)
                    .height(GLASS_HEIGHT.dp)
                    .background(Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(hydrationLevel.dp)
                        .background(fillColor)
                        .align(Alignment.BottomCenter)
                )
            }
        }

        Text(
            text = "${quantity.toInt()} $units",
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyLarge
        )

        Image(
            painter = emptyGlassImage,
            contentDescription = null,
        )
    }
}
