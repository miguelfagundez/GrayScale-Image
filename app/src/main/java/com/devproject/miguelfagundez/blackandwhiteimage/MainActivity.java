package com.devproject.miguelfagundez.blackandwhiteimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Members
    private ImageView originalImage;
    private ImageView convertedImage;
    private Button button;
    private Drawable drawable;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupListeners();
        setupOtherMembers();
    }

    // Init Views
    private void setupViews() {
        originalImage = findViewById(R.id.ivOriginal);
        convertedImage = findViewById(R.id.ivConverted);
        button = findViewById(R.id.btnConvert);
    }

    // Init listeners
    private void setupListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertImageToBlackAndWhite();
            }
        });
    }

    // Init other variables
    private void setupOtherMembers() {
        drawable = ContextCompat.getDrawable(this, R.drawable.original);
        bitmap = ((BitmapDrawable)drawable).getBitmap();
    }

    // Converting original image in a grayscale image and setting in an imageview
    private void convertImageToBlackAndWhite() {
        Bitmap newBitmap = convert(bitmap);
        convertedImage.setImageBitmap(newBitmap);
    }

    // Here I take each pixel and define a gray intensity in a new bitmap
    private Bitmap convert(Bitmap bitmap) {

        int R,G,B,A;
        int originalColor;
        int grayLevel;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Bitmap b = Bitmap.createBitmap(width, height, bitmap.getConfig());

        for (int x=0;x<width; x++){
            for(int y=0;y<height;y++){

                originalColor = bitmap.getPixel(x,y);

                R = Color.red(originalColor);
                G = Color.green(originalColor);
                B = Color.blue(originalColor);
                A = Color.alpha(originalColor);

                grayLevel = (R+G+B)/3;

                b.setPixel(x,y,Color.argb(A, grayLevel, grayLevel, grayLevel));
            }
        }

        return b;
    }

}