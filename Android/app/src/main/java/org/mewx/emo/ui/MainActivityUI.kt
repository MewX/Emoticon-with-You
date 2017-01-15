package org.mewx.emo.ui

import android.os.Build
import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout
import org.mewx.emo.R
import org.mewx.emo.view.MainActivity

/**
 * MainActivity UI
 * Created by MewX on 1/15/2017.
 */

class MainActivityUI : AnkoComponent<MainActivity> {
    val ID_DRAWER_LAYOUT = 1
    val ID_NAVIGATION_VIEW = 2
    val ID_IMAGE_VIEW = 3
    val ID_TEXT_NAME = 4
    val ID_TEXT_DESCRIPTION = 5

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        drawerLayout {
            lparams(width = matchParent, height = matchParent)
            id = ID_DRAWER_LAYOUT
            fitsSystemWindows = true

            // tool bar
            AppBarMainUI().createView(ui)

            navigationView {
                lparams(width = wrapContent, height = matchParent)
                id = ID_NAVIGATION_VIEW
                foregroundGravity = Gravity.START
                fitsSystemWindows = true

                addHeaderView(navHeaderView(ui))
                inflateMenu(R.menu.activity_main_drawer)
            }
        }
    }

    private fun navHeaderView(ui: AnkoContext<MainActivity>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = dip(160))
            backgroundResource =R.drawable.side_nav_bar
            gravity = Gravity.BOTTOM
            orientation = LinearLayout.VERTICAL
            setPadding(dip(64), dip(16), dip(64), dip(16))

            imageView {
                id = ID_IMAGE_VIEW
                topPadding = dip(16)
                imageResource = android.R.drawable.sym_def_app_icon
            }

            textView {
                lparams(width = matchParent, height = wrapContent)
                id = ID_TEXT_NAME
                topPadding = dip(16)
                text = "MewX test"
                if (Build.VERSION.SDK_INT >= 23) {
                    setTextAppearance(R.style.TextAppearance_AppCompat_Body1)
                } else {
                    setTextAppearance(context, android.R.style.TextAppearance_Medium)
                }
            }

            textView {
                id = ID_TEXT_DESCRIPTION
                text = "i@mewx.org"
            }
        }
    }
}
