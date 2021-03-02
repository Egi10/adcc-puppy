/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
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
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            DiscoverTop()
        }
    }
}

@Composable
fun DiscoverTop() {
    Surface(
        color = Color.Blue,
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

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
