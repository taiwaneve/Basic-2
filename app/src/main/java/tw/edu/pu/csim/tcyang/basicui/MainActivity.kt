package tw.edu.pu.csim.tcyang.basicui

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.csim.tcyang.basicui.ui.theme.BasicUITheme
import androidx.compose.foundation.background // 新增
import androidx.compose.foundation.layout.Arrangement // 新增
import androidx.compose.foundation.layout.Column // 新增
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment // 新增
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color // 新增
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext

val LightPurple = Color(0xFFE6E0F8) // 淺紫色 ARGB 範例

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var Animals = listOf(
        R.drawable.animal0, R.drawable.animal1,
        R.drawable.animal2, R.drawable.animal3,
        R.drawable.animal4, R.drawable.animal5,
        R.drawable.animal6, R.drawable.animal7,
        R.drawable.animal8, R.drawable.animal9
    )

    // 修復 AnimalsName 缺少的部分
    val AnimalsName: List<String> = listOf(
        "鴨子1.", "企鵝2.",
        "青蛙3.", "貓頭鷹4.", "海豚5.", "牛6.", "無尾熊7.", "獅子8.", "狐狸9.", "小雞10"
    )

    val context = LocalContext.current


    Column(
        // 1. 結合傳入的 modifier (包含 Scaffold 的內邊距)
        // 2. 設定全螢幕 (.fillMaxSize())
        // 3. 設定背景色 (.background(LightPurple))
        modifier = modifier
            .fillMaxSize()
            .background(LightPurple), // 此處設定了整個畫面的背景色

        // 4. 設定水平置中
        horizontalAlignment = Alignment.CenterHorizontally,

        // 5. 設定垂直靠上
        verticalArrangement = Arrangement.Top
    ) {
        // 在這裡放置您的元件，例如：
        Text(
            text = stringResource(R.string.app_title),
            fontSize = 25.sp,
            color = Color.Blue,
            fontFamily = FontFamily(Font(R.font.kai))

        )
        Text(
            text = stringResource(R.string.app_author),
            fontSize = 20.sp,
            color = Color(0xFF654321)
        )

        Spacer(modifier = Modifier.size(10.dp))

        Row {
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "Android icon",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Yellow),
                alpha = 0.6f,
            )

            Image(
                painter = painterResource(id = R.drawable.compose),
                contentDescription = "Compose icon",
                modifier = Modifier.size(100.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.firebase),
                contentDescription = "Firebase icon",
                modifier = Modifier.size(100.dp)
            )
        }


        // 您原有的 LazyRow (動物圖片)
        LazyRow {
            items(50) { index ->
                Text(text = AnimalsName[index % 10])
                Image(
                    painter = painterResource(id = Animals[index % 10]),
                    contentDescription = "可愛動物圖片",
                    modifier = Modifier.size(60.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row{
            Button(onClick = {
            }) {
                Text(text = "歡迎修課")
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {
            }) {
                Text(text = "展翅飛翔")
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {
            }) {
                Text(text = "結束App")
            }
        }





    }
        }
// 您原有的其他 Composable 保持不變 (但不需要放在 MainContent 內部)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() { // 更改函式名稱以匹配新的 Composable
    BasicUITheme {
        MainContent() // 呼叫新的 MainContent
    }
}