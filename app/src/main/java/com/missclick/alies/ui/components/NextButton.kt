package com.missclick.alies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.theme.AppTheme
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextButton(click: () -> Unit){
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .size(280.dp, 80.dp)
            .border(width = 4.dp, shape = RoundedCornerShape(20.dp), color = AppTheme.colors.accent),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground),
        onClick = {
            click.invoke()
        }
    ) {

        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = context.getString(R.string.next_button).uppercase(), textAlign = TextAlign.Center, style = AppTheme.typography.nextButtonText, color = AppTheme.colors.primary)
        }

    }
}