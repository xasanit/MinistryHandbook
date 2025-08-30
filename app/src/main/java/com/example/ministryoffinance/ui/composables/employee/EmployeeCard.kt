package com.example.ministryoffinance.ui.composables.employee

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ministryoffinance.R
import com.example.ministryoffinance.domain.model.Employee

@Composable
fun EmployeeCard(
    employee: Employee,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .wrapContentHeight()
            .padding(vertical = 20.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .background(color = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .height(intrinsicSize = IntrinsicSize.Min)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.4F)
                        .fillMaxHeight()
                ) {
                    EmployeePhoto()
                }
                Spacer(Modifier.width(20.dp))
                Column(
                    modifier = Modifier
                        .weight(0.6F)
                        .wrapContentHeight()
                ) {
                    EmployeeInfo(
                        fullName = employee.fullName,
                        position = employee.position,
                        landlineNumber = employee.landlineNumber,
                        extensionNumber = employee.extensionNumber,
                        email = employee.email,
                        room = employee.room,
                    )
                }
            }
        }
    }
}

@Composable
fun EmployeePhoto(
    photo: Painter = painterResource(R.drawable.erjan)
) {
    Image(
        painter = painterResource(R.drawable.erjan),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(0.6f)
            .clip(RoundedCornerShape(15.dp))
    )
}

@Composable
fun EmployeeInfo(
    fullName: String,
    position: String,
    landlineNumber: String,
    extensionNumber: String,
    email: String,
    room: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.wrapContentHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = fullName,
                fontSize = 18.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = Bold,
            )
        }
        Spacer(Modifier.height(3.dp))
        Text(
            text = position,
            fontSize = 16.sp,
            color = Color.Blue,
            fontWeight = Bold,
        )
        Spacer(Modifier.height(5.dp))
        EmployeeInfoColumn(
            landlineNumber,
            extensionNumber,
            email,
            room
        )
    }
}

@Preview
@Composable
private fun CardPreview() {
    val mockData = Employee(
        id = 1,
        fullName = "Мухамеджанов Алиакбар Атахунович",
        position = "Директор",
        landlineNumber = "0921939123",
        extensionNumber = "12312",
        email = "muhamedjanov@gmail.com",
        room = 444,
        categoryId = 5,
        image = "fff",
    )
    EmployeeCard(mockData) {}
}

