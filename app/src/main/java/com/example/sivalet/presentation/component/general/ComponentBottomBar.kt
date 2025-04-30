package com.example.sivalet.presentation.component.general

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sivalet.navigation.Screen
import com.example.sivalet.ui.theme.NavigationStrings

@Composable
fun RoundedBottomBar(
    items: List<Screen>,
    currentRoute: String?,
    onItemSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(50),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.95f)),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items.forEach { item ->
                    val selected = currentRoute == item.route
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable { onItemSelected(item.route) }
                    ) {
                        Icon(
                            imageVector = when (item) {
                                Screen.Home -> Icons.Default.Home
                                Screen.Task -> Icons.Default.CheckCircle
                                Screen.History -> Icons.Default.Menu
                                Screen.Account -> Icons.Default.Person
                                else -> Icons.Default.Home
                            },
                            contentDescription = item.route,
                            tint = if (selected) Color.Black else Color.Gray
                        )
                        Text(
                            text = when (item) {
                                Screen.Home -> NavigationStrings.LABEL_HOME
                                Screen.Task -> NavigationStrings.LABEL_TASK
                                Screen.History -> NavigationStrings.LABEL_HISTORY
                                Screen.Account -> NavigationStrings.LABEL_ACCOUNT
                                else -> ""
                            },
                            fontSize = 12.sp,
                            color = if (selected) Color.Black else Color.Gray
                        )
                    }
                }
            }
        }
    }
}
