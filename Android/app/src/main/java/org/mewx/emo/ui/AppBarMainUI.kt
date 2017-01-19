package org.mewx.emo.ui

import android.support.design.widget.AppBarLayout
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.View.generateViewId
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.floatingActionButton
import org.mewx.emo.R

/**
 * Created by MewX on 1/15/2017.
 */

class AppBarMainUI : AnkoComponent<DrawerLayout> {

    companion object {
        val ID_TOOLBAR = generateViewId()
        val ID_FLOATING_ACTION_BUTTON = generateViewId()
        val ID_CONTENT_MAIN = generateViewId()
    }

    override fun createView(ui: AnkoContext<DrawerLayout>) = with(ui) {
        coordinatorLayout {
            lparams(width = matchParent, height = matchParent)
            appBarLayout(theme = R.style.AppTheme_AppBarOverlay) {
                toolbar {
                    lparams(width = matchParent, height = dip(56)) // todo: height = dimenAttr(R.attr.actionBarSize))
                    id = ID_TOOLBAR
                    backgroundColor = resources.getColor(R.color.colorPrimary)
                    popupTheme = R.style.AppTheme_PopupOverlay
                }
            }.lparams(width = matchParent, height = wrapContent)

            // content main
            relativeLayout {
                id = ID_CONTENT_MAIN
                verticalPadding = dimen(R.dimen.activity_vertical_margin)
                horizontalPadding = dimen(R.dimen.activity_horizontal_margin)

                textView {
                    text = "Test MewX"
                }
            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }

            // floating action button
            floatingActionButton {
                id = ID_FLOATING_ACTION_BUTTON
                imageResource = android.R.drawable.ic_dialog_email
            }.lparams {
                margin = dimen(R.dimen.fab_margin)
                gravity = Gravity.BOTTOM or Gravity.END
            }
        }
    }
}
