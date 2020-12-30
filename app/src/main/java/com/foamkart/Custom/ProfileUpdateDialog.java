package com.foamkart.Custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.foamkart.R;
import com.foamkart.databinding.LayoutAddressBinding;
import com.foamkart.databinding.LayoutUpdateProfileBinding;

public class ProfileUpdateDialog extends Dialog implements AdapterView.OnItemClickListener {

    public Activity c;
    public ImageView dialog_cancel_btn;
    public TextView title;
    public Context context;
    String mOperatorcode;


    public ProfileUpdateDialog(Context context, String mOperatorcode){
        super(context, R.style.FullWidth_Dialog);
        this.context=context;
        this.mOperatorcode=mOperatorcode;
    }

    public ProfileUpdateDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(WindowManager.LayoutParams.FILL_PARENT);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.layout_address);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        getWindow().setAttributes(layoutParams);

//        dialog_cancel_btn = findViewById(R.id.img_back);
//        title = findViewById(R.id.title);

        LayoutUpdateProfileBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout. layout_update_profile, null, false);
        setContentView(binding.getRoot());

        binding.toolbar.title.setText("Profile Update");

        binding.toolbar.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        dismiss();
    }
}
