package com.example.ministryoffinance.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ministryoffinance.R
import com.example.ministryoffinance.domain.model.Employee
import com.example.ministryoffinance.ui.composables.card.EmployeeInfoColumn
import com.example.ministryoffinance.ui.dialog.FullScreenImageDialog
import com.example.ministryoffinance.ui.theme.Primary
import com.example.ministryoffinance.ui.theme.Shapes
import com.example.ministryoffinance.ui.values.mock.data.aliaqbar

@Composable
fun EmployeeDetails(employee: Employee) {

    var openDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(15.dp)
            .wrapContentHeight()
    ) {

        Column (
            Modifier.wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.erjan),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxHeight()
                        .clip(shape = Shapes.medium)
                        .weight(0.5F)
                        .border(width = 2.dp, color = Primary, shape = Shapes.medium)
                        .clickable { openDialog = true }
                )
                if (openDialog) {
                    FullScreenImageDialog(
                        painter = painterResource(R.drawable.erjan),
                        onDismiss = { openDialog = false }
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(0.6F)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = employee.fullName,
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = Bold,
                    )
                    Text(
                        text = employee.position,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = Bold,
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Box (
                modifier = Modifier
                    .weight(2F)
                    .fillMaxWidth()
            ) {
                EmployeeInfoColumn(
                    landlineNumber = employee.landlineNumber,
                    extensionNumber = employee.extensionNumber,
                    email = employee.email,
                    room = employee.room,
                    fontSize = 18.sp,
                    verticalPaddingValue = 5.dp
                )
            }
        }
    }
}

@Preview
@Composable
private fun EmployeeDetailsPreview() {
    val employee = aliaqbar
    EmployeeDetails(employee)

}