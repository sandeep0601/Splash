package com.foamkart.Activitys;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.foamkart.Helper.ImageUtils;
import com.foamkart.R;

import java.io.File;
import java.util.ArrayList;

public class Demo extends AppCompatActivity implements ImageUtils.ImageAttachmentListener {

    ImageView imageView;
    Button imagePickBtn;

    private Bitmap bitmap;
    private String file_name;

    ImageUtils imageutils;
    ListView list;
    ArrayList<Bitmap> fileList;
    ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        imageutils = new ImageUtils(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        imagePickBtn = (Button) findViewById(R.id.imagePickBtn);
        list = findViewById(R.id.list);
        fileList  = new ArrayList<>();

        imagePickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageutils.imagepicker(1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageutils.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        imageutils.request_permission_result(requestCode, permissions, grantResults);




    }

    @Override
    public void image_attachment(int from, String filename, Bitmap file, Uri uri) {

        bitmap = file;
        file_name = filename;
        imageView.setImageBitmap(file);

//        fileList.add(file);
        String path = Environment.getExternalStorageDirectory() + File.separator + "ImagePicker" + File.separator;
        imageutils.createImage(file, filename, path, false);

        final ListView list = findViewById(R.id.list);

        arrayList.add(new SubjectData(bitmap, "https://www.tutorialspoint.com/java/", "https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);

    }
}
class CustomAdapter implements ListAdapter {
    ArrayList<SubjectData> arrayList;
    Context context;
    public CustomAdapter(Context context, ArrayList<SubjectData> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SubjectData subjectData = arrayList.get(position);
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_row, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView tittle = convertView.findViewById(R.id.title);
            ImageView imag = convertView.findViewById(R.id.list_image);
//            tittle.setText(subjectData.SubjectName);
            imag.setImageBitmap(subjectData.SubjectName);
            /*Picasso.with(context)
                    .load(subjectData.Image)
                    .into(imag);*/
        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
}
class SubjectData {
    Bitmap SubjectName;
    String Link;
    String Image;
    public SubjectData(Bitmap subjectName, String link, String image) {
        this.SubjectName = subjectName;
        this.Link = link;
        this.Image = image;
    }
}
