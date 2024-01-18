package com.missclick.alies.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun TriangleArrow(modifier: Modifier, enable: Boolean) {
    Card(
        modifier = modifier.size(30.dp),
        shape = GenericShape { size, _ ->
            // 1)
            moveTo(size.width / 2f, 0f)

            // 2)
            lineTo(size.width, size.height)

            // 3)
            lineTo(0f, size.height)
        },
        colors = CardDefaults.cardColors(
            containerColor = if (enable) AppTheme.colors.primary else AppTheme.colors.primaryShadow
        )
    ) {

    }
}