package me.dm7.barcodescanner.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.Camera;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public abstract class BarcodeScannerView extends FrameLayout implements Camera.PreviewCallback  {

    private CameraWrapper mCameraWrapper;
    private CameraPreview mPreview;
    private IViewFinder mViewFinderView;
    private Rect mFramingRectInPreview;
    private CameraHandlerThread mCameraHandlerThread;
    private Boolean mFlashState;
    private boolean mAutofocusState = true;
    private boolean mShouldScaleToFill = true;

    private boolean mIsLaserEnabled = true;
    @ColorInt private int mLaserColor = getResources().getColor(R.color.viewfinder_laser);
    @ColorInt private int mBorderColor = getResources().getColor(R.color.viewfinder_border);
    private int mMaskColor = getResources().getColor(R.color.viewfinder_mask);
    private int mBorderWidth = getResources().getInteger(R.integer.viewfinder_border_width);
    private int mBorderLength = getResources().getInteger(R.integer.viewfinder_border_length);
    private boolean mRoundedCorner = false;
    private int mCornerRadius = 0;
    private boolean mSquaredFinder = false;
    private float mBorderAlpha = 1.0f;
    private int mViewFinderOffset = 0;
    private float mAspectTolerance = 0.1f;

    public BarcodeScannerView(Context context) {
        super(context);
        init();
    }

    public BarcodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attributeSet,
                R.styleable.BarcodeScannerView,
                0, 0);

        try {
            setShouldScaleToFill(a.getBoolean(R.styleable.BarcodeScannerView_shouldScaleToFill, true));
            mIsLaserEnabled = a.getBoolean(R.styleable.BarcodeScannerView_laserEnabled, mIsLaserEnabled);
            mLaserColor = a.getColor(R.styleable.BarcodeScannerView_lase