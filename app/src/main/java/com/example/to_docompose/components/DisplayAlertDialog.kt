package com.example.to_docompose.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.R

@Composable
fun DisplayAlertDialog(
    title: String,
    message: String,
    openDialog: Boolean,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit
) {
    if (openDialog) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal
                )
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                        //Color(0xFF009688)
                        Color(0xFF009a34)
                    ),
                    onClick = {
                        onYesClicked()
                        closeDialog()
                    },

                    ) {
                    Text(text = stringResource(id = R.string.yes))
                }

            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        closeDialog()
                    },

                    ) {
                    Text(text = stringResource(id = R.string.no), color = Color.Black)

                }
            },
            onDismissRequest = {
                closeDialog()
            },
        )
    }

}

@Preview
@Composable
fun DisplayAlertDialogPreview() {
    val r = true
    DisplayAlertDialog(
        title = "ttt",
        message = "mmmeee",
        openDialog = r,
        closeDialog = { /*TODO*/ }) {

    }
}