package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.R

@Composable
fun ItemListPuppy() {
    ConstraintLayout(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
    ) {
        val (image, name, description) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = "item_list_puppy",
            modifier = Modifier
                .aspectRatio(2f, true)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            contentScale = ContentScale.Crop,
        )

        Text(
            text = "Title",
            style = TextStyle(color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .constrainAs(name) {
                    bottom.linkTo(description.top)
                    start.linkTo(description.start)
                    end.linkTo(description.end)
                    width = Dimension.fillToConstraints
                }
                .padding(start = 10.dp, end = 10.dp)
        )

        Text(
            text = "Disini",
            style = TextStyle(color = Color.White, fontSize = 9.sp),
            modifier = Modifier
                .constrainAs(description) {
                    start.linkTo(image.start)
                    end.linkTo(image.end)
                    bottom.linkTo(image.bottom)
                    width = Dimension.fillToConstraints
                }
                .padding(start = 10.dp, end = 10.dp, bottom = 5.dp)
        )
    }
}

@Preview
@Composable
fun ItemListPuppyPreview() {
    ItemListPuppy()
}