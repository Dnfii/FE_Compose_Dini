package com.dini.book.model

import com.dini.book.R

data class Menu(
    val image: Int,
    val title: String,
    val price: String,
)

val dummyMenu = listOf(
    Menu(R.drawable.book_banner1, "Buku Tulis Terbaru", "Paling laku"),
    Menu(R.drawable.book_banner2, "Buku Kuliah", "Terbaru"),
    Menu(R.drawable.book_banner3, "Buku Tulis", "Tulisan kenangan"),
    Menu(R.drawable.book_banner4, "Buku mewarnai", "Mewarnai hatimu"),
    Menu(R.drawable.book_banner5, "Buku Semester Awal", "Semangat awal doang"),
    Menu(R.drawable.book_banner6, "Buku Semester Tengah", "Semangat kuliah"),
    Menu(R.drawable.book_banner7, "Buku Semester Akhir", "Semangat skripsi"),
    Menu(R.drawable.book_banner8, "Kumpulan Skripsi", "Paling Copas"),
    Menu(R.drawable.book_banner4, "Cerita Pendek", "Paling berdebu"),
    Menu(R.drawable.book_banner2, "Buku Pinjam", "Lupa dikembaliin"),
)

val dummyBestSellerMenu = dummyMenu.shuffled()