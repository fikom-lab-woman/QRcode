package com.example.qrcodelabel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class BuatActivity extends AppCompatActivity {

    String TAG="GenerateQRCode";
    String input;
    EditText edttxt;
    ImageView img;
    Button create;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat);

        img = (ImageView) findViewById(R.id.qrcode);
        edttxt = (EditText) findViewById(R.id.edittext);
        create = (Button) findViewById(R.id.createbtn);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = edttxt.getText().toString().trim();
                if (input.length()>0){
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerdimention = width<height ? width:height;
                    smallerdimention = smallerdimention*3/4;
                    qrgEncoder = new QRGEncoder(input, null, QRGContents.Type.TEXT, smallerdimention);
                    try {
                        bitmap = qrgEncoder.encodeAsBitmap();
                        img.setImageBitmap(bitmap);
                    } catch (WriterException e){
                        Log.v(TAG, e.toString());
                    }
                } else {
                    edttxt.setError("Required");
                }
            }
        });
    }
}
