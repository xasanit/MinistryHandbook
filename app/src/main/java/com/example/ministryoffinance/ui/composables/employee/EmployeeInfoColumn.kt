package com.example.ministryoffinance.ui.composables.employee

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ministryoffinance.ui.values.variables.AppIcons
import com.example.ministryoffinance.ui.values.variables.InfoItems

@Composable
fun EmployeeInfoColumn(
    landlineNumber: String,
    extensionNumber: String,
    email: String,
    room: Int
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
        )
        EmployeeInfoRow(
            icon = AppIcons.phoneIcon(),
            infoType = infoItems.extensionNumberLabel,
            info = extensionNumber
        )
        EmployeeInfoRow(
            icon = AppIcons.emailIcon(),
            infoType = infoItems.emailLabel,
            info = email
        )
        EmployeeInfoRow(
            icon = AppIcons.roomIcon(),
            infoType = infoItems.roomLabel,
            info = room.toString()
        )
    }


}

@Composable
fun EmployeeInfoRow(
    icon: Painter,
    infoType: String,
    info: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 2.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            Modifier
                .clip(CircleShape)
                .padding(1.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$infoType:",
            fontSize = 12.sp,
            fontWeight = Normal,
            maxLines = 1,
        )
        Text(
            text = "\t$info",
            modifier = Modifier.weight(1f),
            fontSize = 12.sp,
            fontWeight = Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}