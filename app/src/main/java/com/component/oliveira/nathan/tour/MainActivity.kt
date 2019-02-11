package com.component.oliveira.nathan.tour

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import com.component.oliveira.nathan.tour.component.Overlay
import com.component.oliveira.nathan.tour.component.Pointer
import com.component.oliveira.nathan.tour.component.ToolTip
import com.component.oliveira.nathan.tour.component.TourGuide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var tourGuide: TourGuide
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val tourGuide = TourGuide.create(this) {
//            pointer { Pointer() }
//            toolTip {
//                title { "Hey!" }
//                description { "I'm the top guy" }
//                gravity { Gravity.RIGHT }
//            }
//        }.playOn(test)

//        val tourGuide2 = TourGuide.create(this) {
//            pointer { Pointer() }
//            toolTip {
//                title { "Hey!" }
//                description { "I'm the bottom guy" }
//                gravity { Gravity.TOP or Gravity.LEFT }
//            }
//        }.playOn(test)


//         tourGuide = TourGuide.create(this) {
//            pointer {}
//            toolTip {
//                title { "Hello!" }
//                description { "Click to view tutorial. Next button is disabled until tutorial is viewed" }
//            }
//            overlay {
//                disableClick { false }
//                disableClickThroughHole { false }
//                style { Overlay.Style.RECTANGLE }
//                backgroundColor { Color.parseColor("#AAFF0000") }
//                onClickListener { View.OnClickListener { tourGuide.cleanUp() } }
//            }
//        }.playOn(test)
//
//        tourGuide = TourGuide.create(this) {
//            toolTip {
//                title { "Hello!" }
//                description { "Click to view tutorial. Next button is disabled until tutorial is viewed" }
//            }
//            overlay {
//                disableClick { false }
//                disableClickThroughHole { false }
//                style { Overlay.Style.ROUNDED_RECTANGLE }
//                roundedCornerRadius { 8 }
//                onClickListener { View.OnClickListener { tourGuide.cleanUp() } }
//                backgroundColor { Color.parseColor("#AAFF0000") }
//            }
//            pointer {}
//        }.playOn(test)


//        tourGuide = TourGuide
//            .create(this) {
//                toolTip {
//                    title { "Hello!" }
//                    description { String.format("Current OVERLAY Padding: %s", test.text.toString()) }
//                }
//                overlay {
//                    disableClick { false }
//                    disableClickThroughHole { false }
//                    style { Overlay.Style.ROUNDED_RECTANGLE }
//                    holePadding {  10 }
//                    backgroundColor { Color.parseColor("#AAFF0000") }
//                    onClickListener { View.OnClickListener { tourGuide.cleanUp() } }
//                }
//            }
//            .apply { playOn(test) }

        val colorDemo = intent.getBooleanExtra(COLOR_DEMO, false)
        val gravityDemo = intent.getBooleanExtra(GRAVITY_DEMO, false)


//        val tourGuide = TourGuide.create(this) {
//            technique = TourGuide.Technique.CLICK
//            pointer {
//                color {
//                    if (colorDemo) {
//                        Color.RED
//                    } else {
//                        Color.WHITE
//                    }
//                }
//                gravity {
//                    if (gravityDemo) {
//                        Gravity.BOTTOM or Gravity.RIGHT
//                    } else {
//                        Gravity.CENTER
//                    }
//                }
//            }
//            toolTip {
//                title { "Welcome!" }
//                description { "Click on Get Started to begin..." }
//            }
//            overlay {
//                backgroundColor { Color.parseColor("#66FF0000") }
//            }
//        }  .apply { playOn(test) }

//todo esse e o fosco opaco
//        val tourGuide =
//            TourGuide.create(this) {
//                toolTip {
//                    title { "Welcome!" }
//                    description { "Click on Get Started to begin..." }
//                    backgroundColor { Color.parseColor("#2980b9") }
//                    textColor { Color.parseColor("#FFFFFF") }
//                    gravity {     Gravity.RIGHT or Gravity.TOP }
//                    shadow { true }
//                }
//                pointer {}
//                overlay {}
//            }.playOn(test)

//todo esse e o fosco opaco
        val toolTip = ToolTip()
            .setTitle("Welcome!")
            .setDescription("Click on Get Started to begin...")
            .setGravity(Gravity.LEFT or Gravity.BOTTOM)
            .setBackground(ContextCompat.getDrawable(this,R.drawable.boarder_circle)!!)


        val tourGuide = TourGuide.init(this).with(TourGuide.Technique.CLICK)
            .motionType(TourGuide.MotionType.CLICK_ONLY)
            .setPointer(Pointer())
            .setToolTip(toolTip)
            .apply {
                overlay { Overlay() }
            }.playOn(test)

    }
    companion object {
        const val COLOR_DEMO = "color_demo"
        const val GRAVITY_DEMO = "gravity_demo"
    }
}
