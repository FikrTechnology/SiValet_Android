package com.example.sivalet.presentation.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ScrollableTabRow
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Tab
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TabRowDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.ComponentTopBar
import com.example.sivalet.ui.theme.HistoryStrings
import com.example.sivalet.ui.theme.SiValetColor
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun HistoryScreen() {
    val tabs =
        listOf(HistoryStrings.LABEL_PLAN, HistoryStrings.LABEL_PROCESS, HistoryStrings.LABEL_DONE)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        containerColor = SiValetColor.White,
        contentWindowInsets = WindowInsets(
            left = 17.dp,
            top = 16.dp,
            right = 17.dp,
            bottom = 0.dp
        ),

        topBar = {
            ComponentTopBar(
                profile = true,
                trailing = true,
                imgProfile = painterResource(id = R.drawable.img_profile),
                nameProfile = "Zainudin",
                borderBottom = true,
                imgTrailing = painterResource(id = R.drawable.ico_notification)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Tabs
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                edgePadding = 0.dp,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            .height(4.dp),
                        color = SiValetColor.Primary
                    )
                },
                backgroundColor = SiValetColor.White,
                divider = { },
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = title,
                                style = if (pagerState.currentPage == index) {
                                    MaterialTheme.typography.bodyLarge.copy(color = SiValetColor.Primary)
                                } else {
                                    MaterialTheme.typography.bodyLarge.copy(
                                        color = SiValetColor.Black.copy(
                                            alpha = 0.6f
                                        )
                                    )
                                }
                            )
                        }
                    )
                }
            }

            // Pager Content
            HorizontalPager(
                count = tabs.size,
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> PlanContent()
                    1 -> ProcessContent()
                    2 -> DoneContent()
                }
            }
        }
    }
}