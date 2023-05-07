package com.dox.heroe.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dox.heroe.R

data class Superheroes(@StringRes val name:Int,
                       @StringRes val description: Int,
                       @DrawableRes val imageResourceId : Int)

val superheroes = listOf(
                    Superheroes(R.string.Name_1, R.string.Description_1, R.drawable.android_superhero1),
                    Superheroes(R.string.Name_2, R.string.Description_2, R.drawable.android_superhero2),
                    Superheroes(R.string.Name_3, R.string.Description_2, R.drawable.android_superhero3),
                    Superheroes(R.string.Name_4, R.string.Description_4, R.drawable.android_superhero4),
                    Superheroes(R.string.Name_5, R.string.Description_5, R.drawable.android_superhero5),
                    Superheroes(R.string.Name_6, R.string.Description_6, R.drawable.android_superhero6)
)