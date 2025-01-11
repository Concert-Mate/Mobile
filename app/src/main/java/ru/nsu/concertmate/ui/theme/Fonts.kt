package ru.nsu.concertmate.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import ru.nsu.concertmate.R


private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val fontNameRobotoSlab = GoogleFont("Roboto Slab")

private val fontNameMontserrat = GoogleFont("Montserrat")

private val fontNameRubik = GoogleFont("Rubik")

val FontRobotoSlab = FontFamily(
    Font(
        fontNameRobotoSlab,
        provider,
        FontWeight.Normal,
        FontStyle.Normal)
)

val FontMontserrat = FontFamily(
    Font(
        fontNameMontserrat,
        provider,
        FontWeight.Normal,
        FontStyle.Normal
        )
)


val FontRubik = FontFamily(
    Font(
        fontNameRubik,
        provider,
        FontWeight.Normal,
        FontStyle.Normal
    )
)




