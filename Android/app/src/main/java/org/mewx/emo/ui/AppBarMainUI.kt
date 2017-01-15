package org.mewx.emo.ui

import android.app.Activity
import android.support.annotation.AttrRes
import android.util.TypedValue
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.floatingActionButton
import org.mewx.emo.R

/**
 * Created by MewX on 1/15/2017.
 */

class AppBarMainUI : AnkoComponent<Activity> {
    val ID_TOOLBAR = 1
    val ID_FLOATING_ACTION_BUTTON = 2
    val ID_CONTENT_MAIN = 3

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        coordinatorLayout {
            lparams(width = matchParent, height = matchParent)
            fitsSystemWindows = true

            appBarLayout(theme = R.style.AppTheme_AppBarOverlay) {
                lparams(width = matchParent, height = wrapContent)

                toolbar(theme = R.style.AppTheme_PopupOverlay) {
                    lparams(width = matchParent, height = owner.getAttrDimen(R.attr.actionBarSize))
                    id = ID_TOOLBAR
                }
            }

            // content main
            relativeLayout {
                lparams (width = matchParent, height = matchParent)
                setPadding(dip(64), dip(16), dip(64), dip(16))

                textView {
                    text = "Test MewX"
                }
            }

            // floating action button
            floatingActionButton {
                lparams {
                    margin = dip(16)
                    gravity = bottom or right
                }
                id = ID_FLOATING_ACTION_BUTTON
                imageResource = android.R.drawable.ic_dialog_email
            }
        }
    }

    /**
     * For activity to get attribute values
     */
    fun Activity.getAttrDimen(@AttrRes attr: Int): Int {
        val outValue = TypedValue()
        theme.resolveAttribute(attr, outValue, true)
        return resources.getDimension(outValue.resourceId).toInt()
    }

}
