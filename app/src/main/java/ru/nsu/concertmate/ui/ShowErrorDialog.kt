package ru.nsu.concertmate.ui

import android.app.Activity
import android.app.AlertDialog
import java.lang.Exception

fun ShowErrorDialog(activity: Activity, exception: Exception){
    val dialogBuilder = AlertDialog.Builder(activity)
    // set message of alert dialog
    dialogBuilder.setMessage("error: " + exception.message)
        // if the dialog is cancelable
        .setCancelable(false)
        // positive button text and action
        .setPositiveButton("OK") { dialog, _ -> dialog.cancel() }
    // negative button text and action
    // create dialog box
    val alert = dialogBuilder.create()
    // set title for alert dialog box
    alert.setTitle("error")
    // show alert dialog
    alert.show()
}