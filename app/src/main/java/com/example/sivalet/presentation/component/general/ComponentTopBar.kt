package com.example.sivalet.presentation.component.general

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ComponentTopBar(
    onlyLogo: Boolean = false,
    leading: Boolean = false,
    title: Boolean = false,
    trailing: Boolean = false,
    profile: Boolean = false,
    imgProfile: Painter? = null,
    nameProfile: String? = null,
    onClickLeading: () -> Unit = {},
    onClickTrailing: () -> Unit = {},
    imgLeading: Painter? = null,
    textTitle: String? = null,
    imgTrailing: Painter? = null,
    borderBottom: Boolean = false,
    backgroundColor: Color = SiValetColor.White
) {
    Box(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 18.dp)
                .background(backgroundColor),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (onlyLogo) {
                imgLeading?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier.height(24.dp)
                    )
                }
            }

            if (leading) {
                imgLeading?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .clickable { onClickLeading() }
                    )
                }
            }

            if (profile) {
                Row(
                    modifier = Modifier
                        .background(SiValetColor.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    imgProfile?.let {
                        Image(
                            modifier = Modifier.width(43.dp),
                            painter = it,
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    nameProfile?.let { TextBodySemiLargeBlack500(text = it) }
                }
            }

            if (title) {
                textTitle?.let { TextBodyLargeBlack500(text = it) }
            }

            if (trailing) {
                imgTrailing?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .clickable { onClickTrailing() }
                    )
                }
            }
        }
        if (borderBottom) {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                thickness = 1.dp,
                color = SiValetColor.Black.copy(alpha = 0.05f)
            )
        }
    }
}