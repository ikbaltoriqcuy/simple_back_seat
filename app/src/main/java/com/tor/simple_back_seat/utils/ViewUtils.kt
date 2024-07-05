package com.tor.simple_back_seat.utils

import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.Dimension

/**
Created by ikbaltoriq on 05,July,2024
 **/
object ViewUtils {

    fun ConstrainScope.linkConstraints(
        top: ConstraintLayoutBaseScope.HorizontalAnchor? = parent.top,
        bottom: ConstraintLayoutBaseScope.HorizontalAnchor? = parent.bottom,
        start: ConstraintLayoutBaseScope.VerticalAnchor? = parent.start,
        end: ConstraintLayoutBaseScope.VerticalAnchor? = parent.end
    ) {

        if (top != null)  this.top.linkTo(top)
        if (bottom != null)  this.bottom.linkTo(bottom)
        if (start != null)  this.start.linkTo(start)
        if (end != null)  this.end.linkTo(end)
    }

    fun ConstrainScope.size(width: Dimension, height: Dimension) {
        this.width = width
        this.height = height
    }

}