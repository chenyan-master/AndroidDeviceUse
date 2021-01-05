package com.cy.androiddeviceuse

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Vibrator
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cy.androiddeviceuse.databinding.ActivityShakeBinding
import com.cy.sensor.ShakeDetector


class ShakeActivity : AppCompatActivity() {

    private var shakeBinding: ActivityShakeBinding? = null
    private var shakeDetector: ShakeDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shakeBinding = ActivityShakeBinding.inflate(layoutInflater)
        setContentView(shakeBinding?.root)

        shakeDetector = ShakeDetector(this, ShakeDetector.Listener {
            vibrate(300)
            playSound()
            playAnimation()
            Toast.makeText(applicationContext, "Device shaken!", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onResume() {
        super.onResume()
        shakeDetector?.start()
    }

    override fun onStop() {
        super.onStop()
        shakeDetector?.stop()
    }

    /**
     * 震动
     * @param ms Long
     */
    private fun vibrate(ms: Long) {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(ms)
    }

    /**
     * playSound
     */
    private fun playSound() {
        val player: MediaPlayer = MediaPlayer.create(this, R.raw.shake_sound)
        player.start()
    }

    /**
     * playAnimation
     */
    private fun playAnimation() {
        val rotateAnimation =
            ObjectAnimator.ofFloat(shakeBinding?.tvShakeMe, "rotation", 0f, 180f, 0f)
        rotateAnimation.setDuration(800)
        rotateAnimation.setRepeatMode(ValueAnimator.RESTART)
        rotateAnimation.setInterpolator(LinearInterpolator())
        rotateAnimation.start()
    }
}