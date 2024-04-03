package org.d3if3168.assessment1.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3168.assessment1.R
import org.d3if3168.assessment1.ui.theme.Assessment1Theme
import org.d3if3168.assessment1.ui.theme.GreenJC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.kembali),
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.tentang_aplikasi)) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = GreenJC,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Text(
            text = stringResource(id = R.string.copyright),
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AboutPreview() {
    Assessment1Theme {
        AboutScreen(rememberNavController())
    }
}