package com.dox.heroe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dox.heroe.data.Superheroes
import com.dox.heroe.data.superheroes
import com.dox.heroe.ui.theme.HeroeTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroeTheme {
                HeroesApp()
            }
        }
    }
}
@Composable
fun HeroesApp(modifier: Modifier = Modifier){
    Scaffold(topBar = {
        HeroeTopAppBar()
    }) {
        LazyColumn(modifier = modifier.background(MaterialTheme.colors.background)){
            items(superheroes){
                HeroeItem(heroe = it)
            }
        }
    }
}
@Composable
fun HeroeTopAppBar(modifier: Modifier = Modifier){

        Text(text = "Superheroes",modifier = Modifier.padding(start = 150.dp),
            style = MaterialTheme.typography.h1)

}


@Composable
fun HeroeItem(heroe: Superheroes, modifier: Modifier = Modifier){
    Card(modifier = modifier
        .padding(8.dp)
        .fillMaxWidth(), elevation = 4.dp) {
    Row{
        Column {
            HeroeInformation(heroe.name, heroe.description)
        }
        Spacer(Modifier.weight(1f))
        HeroeIcon(heroe.imageResourceId)
    }
    }
}

@Composable
fun HeroeIcon(@DrawableRes heroeIcon: Int, modifier: Modifier = Modifier){
    Image(modifier = modifier
        .size(68.dp)
        .padding(16.dp)
        .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
        ,painter = painterResource(heroeIcon),
        contentDescription = null)
}


@Composable
fun HeroeInformation(@StringRes heroeName: Int, @StringRes heroeDescription: Int, modifier: Modifier = Modifier){
    Column {
        Text(text = stringResource(heroeName),modifier = modifier.padding(start = 16.dp, top = 8.dp),
        style = MaterialTheme.typography.h1)
        Text(text = stringResource(heroeDescription),modifier = modifier.padding(start = 16.dp),
        style = MaterialTheme.typography.h2)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeroeTheme (darkTheme = false){
        HeroesApp()
    }
}

@Preview
@Composable
fun DarkThemePreview(){
    HeroeTheme(darkTheme = true) {
        HeroesApp()
    }
}