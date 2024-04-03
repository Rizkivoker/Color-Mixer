package org.d3if3168.assessment1.ui.screen

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3168.assessment1.R
import org.d3if3168.assessment1.navigation.Screen
import org.d3if3168.assessment1.ui.theme.Assessment1Theme
import org.d3if3168.assessment1.ui.theme.GreenJC
import org.d3if3168.assessment1.ui.theme.Orange
import org.d3if3168.assessment1.ui.theme.Purple

enum class PrimaryColor(val label: Int, val colorLabel: Color) {
    RED(R.string.red, Color.Red),
    YELLOW(R.string.yellow, Color.Yellow),
    BLUE(R.string.blue, Color.Blue)
}

enum class SecondaryColor(val label: Int, val colorLabel: Color) {
    RED(R.string.red, Color.Red),
    YELLOW(R.string.yellow, Color.Yellow),
    BLUE(R.string.blue, Color.Blue)
}

data class CombineColor(
    val Result: Int,
    val primaryColor: PrimaryColor,
    val secondaryColor: SecondaryColor,
    val colorRes: Color,
    val colorImg: Int
)

val result = listOf(
    CombineColor(
        R.string.purple,
        PrimaryColor.RED,
        SecondaryColor.BLUE,
        Purple,
        R.drawable.ungu
    ),
    CombineColor(
        R.string.green,
        PrimaryColor.YELLOW,
        SecondaryColor.BLUE,
        Color.Green,
        R.drawable.hijau
    ),
    CombineColor(
        R.string.orange,
        PrimaryColor.RED,
        SecondaryColor.YELLOW,
        Orange,
        R.drawable.oranye
    ),//need orange
    CombineColor(
        R.string.green,
        PrimaryColor.BLUE,
        SecondaryColor.YELLOW,
        Color.Green,
        R.drawable.hijau
    ),
    CombineColor(
        R.string.orange,
        PrimaryColor.YELLOW,
        SecondaryColor.RED,
        Orange,
        R.drawable.oranye
    ),//need orange
    CombineColor(
        R.string.purple,
        PrimaryColor.BLUE,
        SecondaryColor.RED,
        Purple,
        R.drawable.ungu
    ),
    CombineColor(
        R.string.blue,
        PrimaryColor.BLUE,
        SecondaryColor.BLUE,
        Color.Blue,
        R.drawable.biru
    ),
    CombineColor(
        R.string.yellow,
        PrimaryColor.YELLOW,
        SecondaryColor.YELLOW,
        Color.Yellow,
        R.drawable.kuning
    ),
    CombineColor(R.string.red, PrimaryColor.RED, SecondaryColor.RED, Color.Red, R.drawable.merah)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = GreenJC,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.About.route)
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = stringResource(id = R.string.tentang_aplikasi),
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { padding ->
        GabunganWarnaa(Modifier.padding(padding))
    }
}


//@Composable
//fun GabunganWarna(modifier: Modifier) {
//    val PrimaryColor = PrimaryColor.entries.toTypedArray()
//    val SecondaryColor = SecondaryColor.entries.toTypedArray()
//    var TextColorError by remember { mutableStateOf(false) }
//    var showResult by remember { mutableStateOf(false) }
//    val selectedPrimaryColor = remember { mutableStateOf(PrimaryColor[0]) }
//    val selectedSecondaryColor = remember { mutableStateOf(SecondaryColor[0]) }
//    val selectedColorCombination = remember { mutableStateOf(result[0]) }
//    val inputText = remember { mutableStateOf("") }
//    result.forEach { combination -> if (combination.primaryColor == selectedPrimaryColor.value && combination.secondaryColor == selectedSecondaryColor.value) { selectedColorCombination.value = combination } }
//    Column(modifier = modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 16.dp), verticalArrangement = Arrangement.spacedBy(24.dp), horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Column(
//            modifier = Modifier, verticalArrangement = Arrangement.spacedBy(24.dp), horizontalAlignment = Alignment.CenterHorizontally
//        ) { Image(painter = painterResource(id = R.drawable.paint), contentDescription = null,)
//            Text(text = "Color Mixer", fontWeight = FontWeight.Bold, fontSize = 32.sp) }
//        Text(text = stringResource(id = R.string.primary_colors))
//        Row{
//            PrimaryColor.forEach { color ->
//                Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
//                ) {
//                    RadioButton(selected = selectedPrimaryColor.value == color, onClick = { selectedPrimaryColor.value = color })
//                    Text(text = stringResource(id = color.label), modifier = Modifier.padding(start = 4.dp)) } } }
//        Text(text = stringResource(id = R.string.secondary_colors))
//        Row() { SecondaryColor.forEach { color ->
//                Row(modifier = Modifier.padding(vertical = 1.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
//                    RadioButton(selected = selectedSecondaryColor.value == color, onClick = { selectedSecondaryColor.value = color })
//                    Text(text = stringResource(id = color.label), modifier = Modifier.padding(start = 4.dp)) } } }
//        OutlinedTextField(value = inputText.value, onValueChange = { inputText.value = it }, trailingIcon = { IconPicker(TextColorError) }, supportingText = { ErrorHint(TextColorError) }, label = { Text(text = stringResource(id = R.string.combined_color)) }, textStyle = TextStyle(color = selectedColorCombination.value.colorRes),)
//        Button(
//            onClick = {
//                TextColorError = inputText.value == ""
//                if (TextColorError) return@Button
//                showResult = true
//            }, modifier = Modifier.padding(top = 8.dp), contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp), colors = ButtonDefaults.buttonColors(Color.Yellow, contentColor = Color.Red)
//        ) { Text(text = stringResource(id = R.string.button)) }
//        if (showResult && inputText.value != "") {
//            Column(
//            ) {
//                // Combine Result
//                Text(text = stringResource(id = R.string.result, stringResource(id = selectedPrimaryColor.value.label), stringResource(id = selectedSecondaryColor.value.label), stringResource(id = selectedColorCombination.value.Result)))
//                // Output Colorize text
//                Text(text = inputText.value, style = TextStyle(color = selectedColorCombination.value.colorRes))
//                // Img Output
//                Image(painter = painterResource(id = selectedColorCombination.value.colorImg), contentDescription = stringResource(id = selectedColorCombination.value.Result))
//            }
//        }
//    }
//}


@Composable
fun IconPicker(isError: Boolean) {
    if (isError) {
        Icon(imageVector = Icons.Filled.Warning, contentDescription = null)
    }
}

@Composable
fun ErrorHint(isError: Boolean) {
    if (isError)
        Text(text = stringResource(id = R.string.error_text))
}

@Composable
fun GabunganWarnaa(modifier: Modifier) {
    val PrimaryColor = PrimaryColor.entries.toTypedArray()
    val SecondaryColor = SecondaryColor.entries.toTypedArray()
    var TextColorError by rememberSaveable { mutableStateOf(false) }
    var showResult by rememberSaveable { mutableStateOf(false) }
    val selectedPrimaryColor = rememberSaveable { mutableStateOf(PrimaryColor[0]) }
    val selectedSecondaryColor = rememberSaveable { mutableStateOf(SecondaryColor[0]) }
    val selectedColorCombination = remember { mutableStateOf(result[0]) }
    val inputText = rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    // Separate function for color checking
    fun checkColor() {
        TextColorError = inputText.value == ""
        if (!TextColorError) {
            showResult = true
        }
    }

    result.forEach { combination ->
        if (combination.primaryColor == selectedPrimaryColor.value && combination.secondaryColor == selectedSecondaryColor.value) {
            selectedColorCombination.value = combination
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.paint), contentDescription = null)
            Text(text = "Color Mixer", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        }

        Text(text = stringResource(id = R.string.primary_colors))

        Row(
            modifier = Modifier.border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ) {
            PrimaryColor.forEach { color ->
                Row(
                    modifier = Modifier.padding(2.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedPrimaryColor.value == color,
                        onClick = { selectedPrimaryColor.value = color })
                    Text(text = stringResource(id = color.label), modifier = Modifier.padding(4.dp))
                }
            }
        }

        Text(text = stringResource(id = R.string.secondary_colors))

        Row(
            modifier = Modifier.border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ) {
            SecondaryColor.forEach { color ->
                Row(
                    modifier = Modifier.padding(2.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedSecondaryColor.value == color,
                        onClick = { selectedSecondaryColor.value = color })
                    Text(text = stringResource(id = color.label), modifier = Modifier.padding(4.dp))
                }
            }
        }



        OutlinedTextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            trailingIcon = { IconPicker(TextColorError) },
            supportingText = { ErrorHint(TextColorError) },
            label = { Text(text = stringResource(id = R.string.combined_color)) },
            textStyle = TextStyle(color = selectedColorCombination.value.colorRes),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { checkColor() },
                modifier = Modifier.padding(top = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(Color.Yellow, contentColor = Color.Red)
            ) {
                Text(text = stringResource(id = R.string.button))
            }
            if (showResult && inputText.value != "") {
                Button(
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
                    onClick = {
                        shareData(
                            context = context,
                            message = context.getString(
                                R.string.share_content,
                                getColor(selectedPrimaryColor.value.label),
                                getColor(selectedSecondaryColor.value.label),
                                getColor(selectedColorCombination.value.Result)
//                                selectedPrimaryColor.value.label.toString(),
//                                selectedSecondaryColor.value.label.toString(),
//                                selectedColorCombination.value.Result.toString()
                            )
                        )
                    }
                ) {
                    Text(text = stringResource(id = R.string.button_share))
                }
            }

        }




        if (showResult && inputText.value != "") {
            Column(
                modifier = Modifier.padding(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(
                        id = R.string.result,
                        stringResource(id = selectedPrimaryColor.value.label),
                        stringResource(id = selectedSecondaryColor.value.label),
                        stringResource(id = selectedColorCombination.value.Result)
                    )

                )
                Text(
                    textAlign = TextAlign.Center,
                    text = inputText.value,
                    style = TextStyle(color = selectedColorCombination.value.colorRes)
                )
                Image(
                    painter = painterResource(id = selectedColorCombination.value.colorImg),
                    contentDescription = stringResource(id = selectedColorCombination.value.Result),
                    )
            }
        }
    }
}


private fun getColor(idColor: Int): String {
    return when (idColor) {
        2131296326 -> "Merah/Red"
        2131296351 -> "Kuning/Yellow"
        2131296258 -> "Biru/Blue"
        2131296328 -> "Hijau/Green"
        2131296321 -> "Oranye/Orange"
        2131296323 -> "Ungu/Purple"

        2131296312 -> "Hijau/Green"
        // Tambahkan lebih banyak kondisi jika diperlukan
        else -> "warna tidak dikenali/color not recognized"
    }
}

private fun shareData(context: Context, message: String) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(shareIntent)
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GreetingPreview() {
    Assessment1Theme {
        MainScreen(rememberNavController())
    }
}

