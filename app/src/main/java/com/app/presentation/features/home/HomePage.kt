package com.app.presentation.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.app.R

@ExperimentalMaterialApi
@Composable
fun HomePage() {
    Scaffold(
        topBar = {
            HomeTopAppBar(0.dp) {

            }
        }
    ) {
        Column(
        ) {
            Divider(
                color = Color.Black,
                thickness = 0.5.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            HomeDevicesList()
        }
    }
}

@Composable
private fun HomeTopAppBar(
    elevation: Dp,
    openDrawer: () -> Unit
) {
    val title = "Mesh Networking"
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.Black
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(90.dp),
        backgroundColor = Color.White,
        elevation = elevation
    )
}

@Composable
fun HomeSearchButton() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Image(
            painterResource(id = R.drawable.ic_search),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {}, shape = CircleShape, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
            )
        ) {
            Text(text = "SEARCH DEVICES")
        }

    }
}

@Composable
fun HomeSearchAnimation() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(
            LottieCompositionSpec
                .Asset("blue_ripple.json")
        )
        val progress by animateLottieCompositionAsState(
            composition,
            iterations = LottieConstants.IterateForever,
        )
        LottieAnimation(composition = composition, progress = progress)
    }
}

@ExperimentalMaterialApi
@Composable
fun HomeDevicesList() {
    Column {
        DeviceCard(
            device = "Device 1",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lectus mauris",
        )
        DeviceCard(
            device = "Device 2",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lectus mauris",
        )
        DeviceCard(
            device = "Device 3",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lectus mauris",
        )
        DeviceCard(
            device = "Device 4",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lectus mauris",
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun DeviceCard(device: String, description: String) {

    ListItem(
        icon = {
        Image(
            painterResource(id = R.drawable.ic_profile),
            contentDescription = "",
        )
    }, text = { Text(device) }, secondaryText = {
        Text(description)
    })
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewHomePage() {
    MaterialTheme(
        content = { HomePage() }
    )
}