### Android设备传感器相关的应用demo

1. 摇一摇功能之加速度传感器

```
class ShakeActivity : AppCompatActivity() {

    private var shakeDetector: ShakeDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ...

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

   ...

```
