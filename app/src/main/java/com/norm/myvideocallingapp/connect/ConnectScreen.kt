package com.norm.myvideocallingapp.connect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.norm.myvideocallingapp.ui.theme.MyVideoCallingAppTheme

@Composable
fun ConnectScreen(
    state: ConnectState,
    onAction: (ConnectAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Chooses a name",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = state.name,
            onValueChange = {
                onAction(ConnectAction.OnNameChange(it))
            },
            maxLines = 1,
            placeholder = {
                Text(
                    text = "Name"
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                onAction(ConnectAction.OnConnectClick)
            },
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Text(
                text = "Connect"
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        state.errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview
@Composable
private fun ConnectScreenPreview() {
    MyVideoCallingAppTheme {
        ConnectScreen(
            state = ConnectState(
                errorMessage = "This Error!"
            ),
            onAction = {},
        )
    }
}