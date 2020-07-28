package me.csxiong.uiux.ui.seek.part

import android.graphics.Canvas
import me.csxiong.library.utils.XDisplayUtil
import me.csxiong.uiux.ui.seek.XSeekBar
import me.csxiong.uiux.ui.seek.XSeekDrawPart

/**
 * @Desc : SeekBar中心指示器部分
 * @Author : Bear - 2020/7/27
 */
class XSeekThumbIndicatorPart(xSeekBar: XSeekBar) : XSeekDrawPart(xSeekBar) {

    /**
     * 中心点X
     */
    var cx = 0f

    /**
     * 中心点Y
     */
    var cy = 0f

    override fun onDraw(canvas: Canvas) {
        // 绘制手指拖动的thumb中的indicator标记点
        if (parent.isEnableThumbIndicator) {
            canvas.drawCircle(cx, cy, XDisplayUtil.dpToPxInt(2.5f).toFloat(), parent.mThumbIndicatorPaint)
        }
    }

    override fun initSize(width: Int, height: Int) {

    }

    override fun onProgressChange(progressX: Float, progress: Float, intProgress: Int, fromUser: Boolean) {
        calculateThumb()
    }

    fun calculateThumb() {
        cx = parent.progressX
        var percent = (parent.progressX - parent.limitLeft) / parent.barWidth
        cy = parent.customHeight / 2f - (parent.contentHeight - parent.mSeekBarHeight) * percent / 2f
    }
}
