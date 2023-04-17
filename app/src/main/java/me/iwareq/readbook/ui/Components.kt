package me.iwareq.readbook.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import me.iwareq.readbook.R
import me.iwareq.readbook.ui.theme.RobotoFamily

@Composable
fun SearchBar(
	modifier: Modifier = Modifier,
	onQueryChanged: (String) -> Unit
) {
	var query by remember { mutableStateOf("") }

	TextField(
		modifier = modifier,
		shape = RoundedCornerShape(110.dp),
		value = query,
		onValueChange = {
			query = it
			onQueryChanged(it)
		},
		placeholder = {
			Text(text = "Search...")
		},
		leadingIcon = {
			Icon(
				imageVector = ImageVector.vectorResource(R.drawable.ic_search),
				contentDescription = null
			)
		},
		keyboardOptions = KeyboardOptions(
			keyboardType = KeyboardType.Text,
			imeAction = ImeAction.Search
		),
		keyboardActions = KeyboardActions(
			onSearch = { onQueryChanged(query) }
		),
		colors = TextFieldDefaults.colors(
			focusedIndicatorColor = Color.Transparent,
			disabledIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent
		)
	)
}

@Composable
fun ReadBookText(
	text: String,
	color: Color = Color.Unspecified,
	modifier: Modifier = Modifier,
	fontWeight: FontWeight = FontWeight.Medium,
	fontSize: TextUnit = TextUnit.Unspecified,
	maxLines: Int = Int.MAX_VALUE
) {
	Text(
		text = text,
		color = color,
		modifier = modifier,
		fontWeight = fontWeight,
		fontFamily = RobotoFamily,
		fontSize = fontSize,
		overflow = TextOverflow.Ellipsis,
		maxLines = maxLines
	)
}

@Preview(showBackground = true)
@Composable
fun PreviewComponents() {
	SearchBar(onQueryChanged = {})
}
