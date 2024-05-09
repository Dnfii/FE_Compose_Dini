package com.dini.book.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dini.book.R

data class Category(
    @DrawableRes val imageCategory: Int,
    @StringRes val textCategory: Int
)

val dummyCategory = listOf(
    R.drawable.book to R.string.category_all,
    R.drawable.book_2 to R.string.category_americano,
    R.drawable.book_3 to R.string.category_cappuccino,
    R.drawable.book_4 to R.string.category_espresso,
    R.drawable.book_5 to R.string.category_frappe,
    R.drawable.book_6 to R.string.category_latte,
    R.drawable.book_7 to R.string.category_macchiato,
    R.drawable.book_8 to R.string.category_mocha,
    R.drawable.book_9 to R.string.category_book_9,
    R.drawable.book_10 to R.string.category_book_10,
).map { Category(it.first, it.second) }
