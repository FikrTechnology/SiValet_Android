package com.example.sivalet.presentation.component.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.ui.theme.AccountStrings

@Composable
fun ComponentContentTable(
    accountName: String,
    accountPhone: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ComponentListContentTable(
            icon = painterResource(id = R.drawable.ico_driver),
            title = accountName
        )

        ComponentListContentTable(
            icon = painterResource(id = R.drawable.ico_phone),
            title = accountPhone
        )

        ComponentListContentTable(
            icon = painterResource(id = R.drawable.ico_feedback),
            title = AccountStrings.TITLE_FEEDBACK
        )

        ComponentListContentTable(
            icon = painterResource(id = R.drawable.ico_announcement),
            title = AccountStrings.TITLE_ANNOUNCHMENT
        )
    }
}