package com.dini.book.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dini.book.model.Category


@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(category.imageCategory),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(start = 6.dp, end = 6.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = stringResource(category.textCategory),
            fontSize = 14.sp,
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp, bottom = 8.dp)
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}