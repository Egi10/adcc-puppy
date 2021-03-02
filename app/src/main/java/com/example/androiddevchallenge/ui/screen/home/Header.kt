package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple700

@Composable
fun Header() {
    Surface(
        color = purple700,
        shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp),
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp

    ) {
        ConstraintLayout(
            modifier = Modifier.padding(
                top = 40.dp,
                bottom = 40.dp,
                start = 15.dp,
                end = 15.dp
            )
        ) {
            val (column, image) = createRefs()

            Column(modifier = Modifier
                .constrainAs(column) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
            ) {
                Text(
                    text = "Discover",
                    style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
                    fontSize = 22.sp
                )
                Text(
                    text = "Find your favorite puppy and adopt it now",
                    style = TextStyle(color = Color.White),
                    fontSize = 12.sp
                )
            }

            Image(
                painter = painterResource(id = R.drawable.img_profile),
                contentDescription = "profile",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(column.top)
                        bottom.linkTo(column.bottom)
                        end.linkTo(parent.end)
                    }
                    .size(45.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    ),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview("Light Theme")
@Composable
fun LightPreview() {
    MyTheme {
        Header()
    }
}

@Preview("Dark Theme")
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Header()
    }
}