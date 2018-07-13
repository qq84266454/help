package com.weijun.helpcircle.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ReleaseAlertDialog extends Dialog {
    public ReleaseAlertDialog(@NonNull Context context) {
        super(context);
    }

    public ReleaseAlertDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ReleaseAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
