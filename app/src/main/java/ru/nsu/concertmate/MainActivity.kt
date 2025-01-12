package ru.nsu.concertmate

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.nsu.concertmate.ui.screens.LoginScreen
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import ru.nsu.concertmate.MyFirebaseMessagingService.Companion.CHANNEL_DESCRIPTION
import ru.nsu.concertmate.MyFirebaseMessagingService.Companion.CHANNEL_ID
import ru.nsu.concertmate.MyFirebaseMessagingService.Companion.CHANNEL_NAME
import ru.nsu.concertmate.ui.components.exampleConcertInfoDto

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission()
        }

        setContent {
            LoginScreen("", activity = this, isCodeEnter = false)
        }
    }

    private fun requestNotificationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val requestPermissionLauncher = registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    Log.d("Permission", "Разрешение на уведомления предоставлено")
                } else {
                    Log.d("Permission", "Разрешение на уведомления отклонено")
                }
            }
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = CHANNEL_DESCRIPTION
            }
            notificationManager.createNotificationChannel(channel)
        }

        val intent = Intent(App.context, ConcertInfoActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        intent.putExtra("dto", exampleConcertInfoDto)

        val pendingIntent = PendingIntent.getActivity(
            App.context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Новый концерт")
            .setContentText( "У " + exampleConcertInfoDto.groupName + " в " + exampleConcertInfoDto.city)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setColor(ContextCompat.getColor(this, R.color.teal_200))
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .build()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        NotificationManagerCompat.from(this).notify(System.currentTimeMillis().toInt(), notification)
    }

}
