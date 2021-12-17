package com.example.a20173025_finalappproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.github.channguyen.rsv.RangeSliderView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class Fragment3 extends Fragment {
    private static final String TAG = "Fragment3";


    ImageView pictureImageView;


    Bitmap picture;
    FrameLayout frameLayout;
    File file;
    EditText jinputMessage;
    TextView jinputCount;
    RangeSliderView moodSlider;
    int moodIndex = 2;



    @Override
    public void onResume() {
        super.onResume();
        file = createFile();
        if (file.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), null);
            pictureImageView.setImageBitmap(bitmap);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);




        pictureImageView = rootView.findViewById(R.id.pictureImageView);
        jinputMessage = rootView.findViewById(R.id.contentsInput);
        jinputCount = rootView.findViewById(R.id.xinputCount);
        moodSlider = rootView.findViewById(R.id.sliderView);

        Button saveButton = rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "저장되었습니다.", Toast.LENGTH_LONG).show();

            }

        });

        RangeSliderView sliderView = rootView.findViewById(R.id.sliderView);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {
                String star = String.valueOf(index + 1);
                Toast.makeText(getContext(),  "별점 " + star + "점", Toast.LENGTH_SHORT).show();
                moodIndex = index;
            }
        };





        pictureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence str, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                byte[] bytes = null;
                try {
                    bytes = str.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    jinputCount.setText(strCount + " / 100바이트");
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable strEditable) {
                String str = strEditable.toString();
                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if (strBytes.length > 100) {
                        strEditable.delete(strEditable.length() - 2, strEditable.length() - 1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        jinputMessage.addTextChangedListener(watcher);
        sliderView.setOnSlideListener(listener);
        sliderView.setInitialIndex(2);

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sFile", Context.MODE_PRIVATE);


        return rootView;
    }

    private void takePicture(){
        if(file == null){
            file = createFile();
        }
        Uri fileUri = FileProvider.getUriForFile(getActivity(), "com.example.a20173025_finalappproject.fileprovider",file);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        if(intent.resolveActivity(getActivity().getPackageManager()) != null){
            startActivityForResult(intent, 101);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101 && resultCode == getActivity().RESULT_OK){
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            picture = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            pictureImageView.setImageBitmap(picture);
        }
    }

    private File createFile() {
        String filename = "capture.jpg";
        File storageDir = getActivity().getExternalFilesDir(null);
        File outFile = new File(storageDir, filename);
        return outFile;
    }




    private String BitampConvertString(Bitmap bitmap){
        if(bitmap != null){
            try{
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                byte[] b = outputStream.toByteArray();
                String temp = Base64.encodeToString(b, Base64.DEFAULT);
                return temp;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //사용자가 입력한 데이터 저장

        String image = BitampConvertString(picture);


        editor.putString("image",image);


        ByteArrayOutputStream bos = new ByteArrayOutputStream();


        editor.commit();
    }


}