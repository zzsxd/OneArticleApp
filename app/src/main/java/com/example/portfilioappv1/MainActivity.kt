package com.example.portfilioappv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
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
import com.example.portfilioappv1.ui.theme.PortfilioAppV1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfilioAppV1Theme {
                val scrollState = rememberScrollState()
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(WindowInsets.systemBars.asPaddingValues())) {
                    Column (modifier = Modifier
                        .verticalScroll(scrollState)
                        .fillMaxWidth()
                    ) {
                        FirstBlock(
                            authorArticle = stringResource(R.string.full_name_creator),
                            dateArticle = stringResource(R.string.date_of_article),
                        )
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.3F.dp,
                            color = Color.Black
                        )
                        SecondBlock(
                            slogan = stringResource(R.string.article_name),
                            articleHalfOne = stringResource(R.string.article_part_one),
                            articleHalfTwo = stringResource(R.string.article_part_two)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun FirstBlock(authorArticle: String, dateArticle: String, modifier: Modifier = Modifier) {
    val avatar = painterResource(R.drawable.image)
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top=32.dp, bottom = 32.dp, start=52.dp)) {
        Image(
            painter = avatar,
            contentDescription = null,
            alpha = 1.0F,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(96.dp)
                .height(96.dp)
                .clip(RoundedCornerShape(128.dp))
        )
        Column(modifier = Modifier.padding(start=16.dp)) {
            Text(
                text = authorArticle,
                fontSize = 18.sp,
                modifier = Modifier
            )
            Text(
                text = dateArticle,
                fontSize = 14.sp,
                )
        }
    }
}

@Composable
fun SecondBlock(slogan: String, articleHalfOne: String, articleHalfTwo: String, modifier: Modifier = Modifier) {
    val articleImage = painterResource(R.drawable.g2win)
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)) {
        Image(
            painter = articleImage,
            contentDescription = "G2 image",
            modifier = Modifier.clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = slogan,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(top=16.dp, bottom=24.dp)
        )
        Text(
            text = articleHalfOne,
            modifier = Modifier.padding(top=16.dp, bottom=24.dp, start=12.dp, end=12.dp),
            fontSize = 16.sp
        )
        Text(
            text = articleHalfTwo,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom=8.dp, start=12.dp, end=12.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PortfolioAppPreview() {
    val scrollState = rememberScrollState()
    PortfilioAppV1Theme {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())) {
                Column (modifier = Modifier
                    .verticalScroll(scrollState)
                    .fillMaxWidth()
                ) {
                    FirstBlock(
                        authorArticle = stringResource(R.string.full_name_creator),
                        dateArticle = stringResource(R.string.date_of_article),
                    )
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.3F.dp,
                        color = Color.Black
                    )
                    SecondBlock(
                        slogan = stringResource(R.string.article_name),
                        articleHalfOne = stringResource(R.string.article_part_one),
                        articleHalfTwo = stringResource(R.string.article_part_two)
                    )
                }
            }
    }
}