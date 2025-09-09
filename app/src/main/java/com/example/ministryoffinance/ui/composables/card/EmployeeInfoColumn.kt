package com.example.ministryoffinance.ui.composables.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ministryoffinance.ui.theme.Primary
import com.example.ministryoffinance.ui.values.mock.data.aliaqbar
import com.example.ministryoffinance.ui.values.variables.AppIcons
import com.example.ministryoffinance.ui.values.variables.InfoItems

@Composable
fun EmployeeInfoColumn(
    landlineNumber: String,
    extensionNumber: String,
    email: String,
    room: Int,
    fontSize: TextUnit = 12.sp,
    verticalPaddingValue: Dp = 2.dp
) {
    val infoItems = InfoItems
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        EmployeeInfoRow(
            icon = AppIcons.phoneIcon(),
            infoType = infoItems.landlineNumberLabel,
            info = landlineNumber,
            fontSize = fontSize,
            verticalPaddingValue = verticalPaddingValue,
        )
        EmployeeInfoRow(
            icon = AppIcons.phoneIcon(),
            infoType = infoItems.extensionNumberLabel,
            info = extensionNumber,
            fontSize = fontSize,
            verticalPaddingValue = verticalPaddingValue,
        )
        EmployeeInfoRow(
            icon = AppIcons.emailIcon(),
            infoType = infoItems.emailLabel,
            info = email,
            fontSize = fontSize,
            verticalPaddingValue = verticalPaddingValue,
        )
        EmployeeInfoRow(
            icon = AppIcons.roomIcon(),
            infoType = infoItems.roomLabel,
            info = room.toString(),
            fontSize = fontSize,
            verticalPaddingValue = verticalPaddingValue,
        )
    }
}

@Composable
fun EmployeeInfoRow(
    icon: Painter,
    infoType: String,
    info: String,
    fontSize: TextUnit,
    verticalPaddingValue: Dp = 2.dp,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(vertical = verticalPaddingValue)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                Modifier
                    .clip(CircleShape)
                    .padding(1.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = infoType,
                fontSize = fontSize,
                fontWeight = Bold,
                maxLines = 1,
            )
        }
        Text(
            text = "\t$info",
            fontSize = fontSize,
            fontWeight = Normal,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Primary
        )
    }
}

@Preview
@Composable
private fun EmployeeInfoColumnPreview() {
    EmployeeInfoColumn(
        landlineNumber = aliaqbar.landlineNumber,
        extensionNumber = aliaqbar.extensionNumber,
        email = aliaqbar.email,
        room = aliaqbar.room,
    )
}

@Preview
@Composable
private fun EmployeeInfoRowPreivew() {
    EmployeeInfoRow(
        icon = AppIcons.phoneIcon(),
        infoType = InfoItems.landlineNumberLabel,
        info = aliaqbar.landlineNumber,
        fontSize = 12.sp,
    )
    
}