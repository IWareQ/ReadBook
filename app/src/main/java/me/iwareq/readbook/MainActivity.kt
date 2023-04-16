package me.iwareq.readbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import me.iwareq.readbook.ui.home.HomeScreen
import me.iwareq.readbook.ui.theme.ReadBookTheme
import me.iwareq.readbook.ui.trending.TrendingScreen

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		this.setContent {
			ReadBookTheme {
				BottomNavigationBar()
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PreviewMode() {
	ReadBookTheme {
		BottomNavigationBar()
	}
}

@Composable
fun BottomNavigationBar() {
	val screens = listOf(
		Screen.Home,
		Screen.Trending
	)

	val navController = rememberNavController()
	val navBackStackEntry by navController.currentBackStackEntryAsState()
	val currentRoute = navBackStackEntry?.destination?.route

	Scaffold(
		bottomBar = {
			NavigationBar {
				screens.forEach {
					NavigationBarItem(
						icon = {
							Icon(
								imageVector = ImageVector.vectorResource(it.iconId),
								contentDescription = it.title
							)
						},
						label = { Text(it.title) },
						selected = currentRoute == it.route,
						onClick = {
							navController.navigate(it.route) {
								popUpTo(navController.graph.startDestinationId) {
									saveState = true
								}

								launchSingleTop = true
								restoreState = true
							}
						}
					)
				}
			}
		}
	) {
		NavHost(
			navController = navController,
			startDestination = Screen.Home.route,
			modifier = Modifier.padding(it)
		) {
			composable(Screen.Home.route) { HomeScreen() }
			composable(Screen.Trending.route) { TrendingScreen() }
		}
	}
}

sealed class Screen(val route: String, val title: String, val iconId: Int) {

	object Home : Screen("home", "Home", R.drawable.ic_home)
	object Trending : Screen("trending", "Trending", R.drawable.ic_books)
}
