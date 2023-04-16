package me.iwareq.readbook.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.iwareq.readbook.R
import me.iwareq.readbook.ui.SearchBar

@Composable
fun HomeScreen() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(start = 20.dp, top = 8.dp, end = 20.dp)
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
		) {
			SearchBar(
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(end = 10.dp),
				onQueryChanged = {
					Log.i("SearchBar", it)
				}
			)

			Icon(
				modifier = Modifier.fillMaxWidth(),
				painter = painterResource(R.drawable.ic_notification),
				contentDescription = null
			)
		}
	}

	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text("Home Screen")
	}
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
	HomeScreen()
}
