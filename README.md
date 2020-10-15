# GrayScale-Image
Converting a colored image to a grayscale image

## Code (.java):

Taking each pixel to converting to grayscale. (see code for details)
```
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
```

## Final result:
<p align = "center">
<img src="/images/01.png" width="300">
</p>
