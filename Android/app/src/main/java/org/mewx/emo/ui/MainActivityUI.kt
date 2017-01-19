package org.mewx.emo.ui

import android.os.Build
import android.support.design.widget.NavigationView
import android.view.Gravity
import android.view.View.generateViewId
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout
import org.mewx.emo.view.MainActivity
import org.mewx.emo.R

/**
 * MainActivity UI
 * Created by MewX on 1/15/2017.
 */

class MainActivityUI : AnkoComponent<MainActivity> {

    companion object {
        val ID_DRAWER_LAYOUT = generateViewId()
        val ID_NAVIGATION_VIEW = generateViewId()
        val ID_IMAGE_VIEW = generateViewId()
        val ID_TEXT_NAME = generateViewId()
        val ID_TEXT_DESCRIPTION = generateViewId()
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        drawerLayout {
            id = ID_DRAWER_LAYOUT
            fitsSystemWindows = true

            // tool bar
            val appBarLayoutContext = AnkoContext.create(ctx, this)
            addView(AppBarMainUI().createView(appBarLayoutContext))

            navigationView {
                id = ID_NAVIGATION_VIEW

                val headerContext = AnkoContext.create(ctx, this);
                val headerView = NavigationHeaderUI().createView(headerContext)
                        .lparams(width = matchParent, height = dimen(R.dimen.nav_header_height))
                addHeaderView(headerView)
                inflateMenu(R.menu.activity_main_drawer)
            }.lparams(width = wrapContent, height = matchParent) {
                gravity = Gravity.START
                fitsSystemWindows = true
            }
        }
    }

    private class NavigationHeaderUI : AnkoComponent<NavigationView> {
        override fun createView(ui: AnkoContext<NavigationView>) = with(ui) {
            linearLayout(theme = R.style.ThemeOverlay_AppCompat_Dark) {
                lparams(width = matchParent, height = dimen(R.dimen.nav_header_height))
                backgroundResource = R.drawable.side_nav_bar
                gravity = Gravity.BOTTOM
                orientation = LinearLayout.VERTICAL
                verticalPadding = dimen(R.dimen.activity_vertical_margin)
                horizontalPadding = dimen(R.dimen.activity_horizontal_margin)

                imageView {
                    id = ID_IMAGE_VIEW
                    topPadding = dimen(R.dimen.nav_header_vertical_spacing)
                    imageResource = android.R.drawable.sym_def_app_icon
                }.lparams {
                    gravity = Gravity.START
                }

                textView {
                    id = ID_TEXT_NAME
                    topPadding = dimen(R.dimen.nav_header_vertical_spacing)
                    text = "MewX test"
                    if (Build.VERSION.SDK_INT >= 23) {
                        setTextAppearance(R.style.TextAppearance_AppCompat_Body1)
                    } else {
                        setTextAppearance(context, R.style.TextAppearance_AppCompat_Body1)
                    }
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    id = ID_TEXT_DESCRIPTION
                    text = "i@mewx.org"
                }
            }
        }
    }
}
