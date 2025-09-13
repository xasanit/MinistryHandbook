package com.example.ministryoffinance.ui.common.components.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun FullScreenImageDialog(
    painter: Painter,
    contentDescription: String? = null,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
       Box(
           modifier = Modifier
               .wrapContentSize()
               .clickable {onDismiss},
           contentAlignment = Alignment.Center
       ) {
           Image(
               painter = painter,
               contentDescription = contentDescription,
               modifier = Modifier
                   .padding(20.dp)
                   .clip(RoundedCornerShape(15.dp))
           )
       }
    }
}