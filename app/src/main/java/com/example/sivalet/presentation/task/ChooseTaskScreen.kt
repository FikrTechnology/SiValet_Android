package com.example.sivalet.presentation.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.home.LazyColumnToDoList
import com.example.sivalet.ui.theme.ConfirmTaskStrings
import com.example.sivalet.ui.theme.SiValetColor

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChooseTaskScreen(
    onClickBack: () -> Unit = {},
    onClickItem: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(SiValetColor.BorderColor),
                title = {
                    TextBodyLargeBlack500(text = "Pilih Tugas")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onClickBack()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.height(24.dp),
                            painter = painterResource(id = R.drawable.ico_arrow_back),
                            contentDescription = null
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumnToDoList(
                onClickToDoList = { onClickItem() }
            )
        }
    }
}