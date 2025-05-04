package com.example.sivalet.presentation.component.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.CardTag
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.ui.theme.ConfirmTaskStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ContentConfirmationTask(
    carName: String,
    activityType: String,
    textFieldLocFrom: String,
    onValueChangeLocFrom: (String) -> Unit,
    textFieldLocTo: String,
    onValueChangeLocTo: (String) -> Unit,
    textFieldUser: String,
    onValueChangeUser: (String) -> Unit,
    textFieldCustomer: String,
    onValueChangeCustomer: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 17.dp, vertical = 24.dp)
            .wrapContentHeight()
            .shadow(4.dp, shape = RoundedCornerShape(4.dp), clip = false)
            .clip(
                shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
            )
            .background(SiValetColor.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(SiValetColor.BorderColor),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextBodyLargeBlack500(text = ConfirmTaskStrings.TITLE_TASK)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp, vertical = 21.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextBodyMediumBlack500(text = carName)
                    CardTag(
                        text = activityType,
                        backgroundColor = SiValetColor.Third
                    )
                }
                Box {
                    HorizontalDivider(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        thickness = 1.dp,
                        color = SiValetColor.Black.copy(alpha = 0.05f)
                    )
                }
            }

            ComponentTextFieldInformationTask(
                imageVector = Icons.Outlined.LocationOn,
                textTitle = ConfirmTaskStrings.TITLE_LOC_FROM,
                textField = textFieldLocFrom,
                onValueChange = onValueChangeLocFrom
            )

            ComponentTextFieldInformationTask(
                imageVector = Icons.Outlined.LocationOn,
                textTitle = ConfirmTaskStrings.TITLE_LOC_TO,
                textField = textFieldLocTo,
                onValueChange = onValueChangeLocTo
            )

            ComponentTextFieldInformationTask(
                isImageVector = false,
                painter = painterResource(id = R.drawable.ico_user),
                textTitle = ConfirmTaskStrings.TITLE_USER,
                textField = textFieldUser,
                onValueChange = onValueChangeUser
            )

            ComponentTextFieldInformationTask(
                isImageVector = false,
                painter = painterResource(id = R.drawable.ico_user),
                textTitle = ConfirmTaskStrings.TITLE_CUSTOMER,
                textField = textFieldCustomer,
                onValueChange = onValueChangeCustomer
            )
        }
    }
}