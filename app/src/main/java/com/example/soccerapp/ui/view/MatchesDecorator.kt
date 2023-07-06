package com.example.soccerapp.ui.view

import android.content.res.Configuration
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MatchesDecorator : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val margin = 10f
        val space = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            margin,
            view.resources.displayMetrics
        ).toInt()

        if(view.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            if(parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 2){
                outRect.bottom = space
            }
        }

        if(parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1){
            outRect.bottom = space
        }
    }
}