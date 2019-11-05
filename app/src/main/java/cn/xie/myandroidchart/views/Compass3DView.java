package cn.xie.myandroidchart.views;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * @author xiejinbo
 * @date 2019/11/5 0005 9:36
 */
public class Compass3DView extends View {
    private Paint paint;
    private int centerX;
    private int centerY;
    private Camera camera = new Camera();
    private Matrix matrix = new Matrix();
    private float mCanvasRotateX = 0;
    private float mCanvasRotateY = 0;
    private float mCanvasMaxRotateDegree = 20;
    private Path mPath = new Path();
    private float touchX;
    private float touchY;
    private double alpha=255;

    public Compass3DView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        mCanvasMaxRotateDegree = 20;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        //获取控件宽高，在中心画圆
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;

        //控制旋转
        canvas.rotate((float) alpha,centerX,centerY);
        alpha = Math.atan((touchX-centerX)/(centerY-touchY));
        alpha = Math.toDegrees(alpha);
        if(touchY>centerY){
            alpha = alpha+180;
        }

        rotateCanvas(canvas);
        paint.setAlpha(255);
        canvas.drawCircle(centerX, 80, 10, paint);
        drawMyLine(canvas);
        drawPath(canvas);
        drawMyText(canvas);
    }

    /**
     * 画文字
     * @param canvas
     */
    private void drawMyText(Canvas canvas) {
        paint.setAlpha(255);
        paint.setTextSize(40);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        //设置发光
        //paint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));

        canvas.drawText("N",centerX,30,paint);
    }

    /**
     * 画白线
     */
    private void drawMyLine(Canvas canvas) {
        //保存坐标系
        canvas.save();
        for (int i = 0; i < 120; i++) {
            //设置透明度
            paint.setAlpha(255-(120 * i/120));
            canvas.drawLine(centerX, 50, centerX, 70, paint);
            canvas.rotate(3, centerX, centerY);

        }
        //恢复坐标系
        canvas.restore();

    }

    private void rotateCanvas(Canvas canvas) {

        //把camera给旋转一下，并把生成的矩阵给一个矩阵。再把矩阵应用到canvas
        matrix.reset();
        camera.save();
        //此处两个方法控制旋转时候的偏移量
        //camera.rotateX(mCanvasRotateX);
        //camera.rotateY(mCanvasRotateY);
        camera.rotateX(0);
        camera.rotateY(0);
        //camera.rotateZ(10);
        camera.getMatrix(matrix);
        camera.restore();
        //改变矩阵作用点
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        //将矩阵作用于整个canvas
        canvas.concat(matrix);
    }

    /**
     * 画中间指针
     * @param canvas
     */
    private void drawPath(Canvas canvas) {
        mPath.moveTo(centerX,90);
        mPath.lineTo(centerX-30,centerY);
        mPath.lineTo(centerX,2*centerY-90);
        mPath.lineTo(centerX+30,centerY);
        mPath.lineTo(centerX,90);
        mPath.close();
        canvas.drawPath(mPath,paint);
        canvas.drawCircle(centerX,centerY,20,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                rotateCanvasWhenMove(touchX, touchY);
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                rotateCanvasWhenMove(touchX, touchY);
                invalidate();
                return true;
            }
            case MotionEvent.ACTION_UP: {
                mCanvasRotateY = 0;
                mCanvasRotateX = 0;
                invalidate();

                return true;
            }
        }

        return super.onTouchEvent(event);
    }

    private void rotateCanvasWhenMove(float x, float y) {
        float dx = x - centerX;
        float dy = y - centerY;

        float percentX = dx / centerX;
        float percentY = dy / centerY;

        if (percentX > 1f) {
            percentX = 1f;
        } else if (percentX < -1f) {
            percentX = -1f;
        }
        if (percentY > 1f) {
            percentY = 1f;
        } else if (percentY < -1f) {
            percentY = -1f;
        }

        mCanvasRotateY = mCanvasMaxRotateDegree * percentX;
        mCanvasRotateX = -(mCanvasMaxRotateDegree * percentY);

    }
}
