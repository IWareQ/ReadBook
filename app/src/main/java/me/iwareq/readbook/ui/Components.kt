package me.iwareq.readbook.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.iwareq.readbook.R

@Composable
fun SearchBar(
	modifier: Modifier = Modifier,
	onQueryChanged: (String) -> Unit
) {
	var query by remember { mutableStateOf("") }

	TextField(
		modifier = modifier.fillMaxWidth(),
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
	)
}

@Preview(showBackground = true)
@Composable
fun PreviewComponents() {
	SearchBar(onQueryChanged = {})
}
