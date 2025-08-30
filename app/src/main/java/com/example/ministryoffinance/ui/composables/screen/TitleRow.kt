package com.example.ministryoffinance.ui.composables.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ministryoffinance.R
import com.example.ministryoffinance.ui.theme.MinistryOfFinanceTheme

@Composable
fun TitleRow() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.gerb),
            contentDescription = "Herb of Kyrgyz Republic",
            modifier = Modifier
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier
            .width(10.dp))
        Text(
            text = "Министерство Финансов Кыргызской Республики",
            modifier = Modifier
                .weight(1F)
                .align(Alignment.CenterVertically),
            fontSize = 18.sp,
            fontWeight = Bold,
            maxLines = 2
        )
    }
}

@Preview
@Composable
fun TitleRowPreview() {
    MinistryOfFinanceTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
        ) {
            TitleRow()
        }
    }
}
