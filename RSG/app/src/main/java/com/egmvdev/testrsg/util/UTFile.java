package com.egmvdev.testrsg.util;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UTFile {

    public static String readFileFromAssets(Context context, String fileName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int ctr;

        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(fileName);
            try {
                ctr = inputStream.read();
                while (ctr != -1) {
                    outputStream.write(ctr);
                    ctr = inputStream.read();
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toString();
    }
}
