package me.iwareq.readbook.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.iwareq.readbook.R
import me.iwareq.readbook.ui.ReadBookText
import me.iwareq.readbook.ui.SearchBar

@Composable
fun HomeScreen() {
	Column(
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

		ReadBookText(
			text = "From Your Library",
			modifier = Modifier.padding(top = 20.dp),
			fontWeight = FontWeight.Bold,
			fontSize = 24.sp
		)

		LazyRow(
			horizontalArrangement = Arrangement.spacedBy(20.dp)
		) {
			items(5) {
				BookCard()
			}
		}

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 20.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			ReadBookText(
				text = "Top page turners",
				fontWeight = FontWeight.Bold,
				fontSize = 18.sp
			)

			Icon(
				painter = painterResource(R.drawable.ic_chevron_right),
				contentDescription = null,
				modifier = Modifier.size(16.dp)
			)
		}

	}
}

@Composable
fun BookCard() {
	Column(
		modifier = Modifier
			.width(178.dp)
			.padding(top = 16.dp)
	) {
		Image(
			painter = painterResource(R.drawable.ic_book),
			contentDescription = null,
			modifier = Modifier
				.fillMaxWidth()
				.clip(RoundedCornerShape(20.dp)),
			contentScale = ContentScale.Crop
		)

		ReadBookText(
			text = "There was still love",
			fontSize = 16.sp,
			maxLines = 1
		)

		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			LinearProgressIndicator(
				progress = 0.7f,
				modifier = Modifier
					.weight(0.8F)
					.clip(RoundedCornerShape(3.dp)),
				color = Color(0xFFF86D36),
				strokeCap = StrokeCap.Round
			)

			ReadBookText(
				text = "70%",
				color = Color(0xFFACB1B6),
				modifier = Modifier
					.weight(0.2F)
					.padding(start = 7.dp),
				fontSize = 14.sp
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
	HomeScreen()
}
