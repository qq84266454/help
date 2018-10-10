package com.weijun.helpcircle.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import com.weijun.helpcircle.R;

/**
 * Created by ex-lvchaofeng001 on 2017/8/17.
 */

public class GeneralDialog extends Dialog {
    Context context;

    public GeneralDialog(Context context) {
        super(context, R.style.my_dialog_style);
        this.context = context;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(attributes);
    }

    protected GeneralDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_loading_dialog2);
    }
}
