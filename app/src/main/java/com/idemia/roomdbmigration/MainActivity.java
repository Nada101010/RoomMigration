package com.idemia.roomdbmigration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.idemia.roomdbmigration.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private static String sourceBase, targetBase;
    public static boolean copyStatus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });


        binding.buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GetDataActivity.class));
            }
        });

        binding.buttonBackupDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backupDB();
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void backupDB(){
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                //Replace with YOUR_PACKAGE_NAME and YOUR_DB_NAME
                String currentDBPath = "/data/com.idemia.roomdbmigration/databases/";
                //Replace with YOUR_FOLDER_PATH and TARGET_DB_NAME in the SD card
                String copieDBPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "test_migration_db";

                File currentDB = new File(data, currentDBPath);
                File copieDB = new File(sd, copieDBPath);
                if (currentDB.exists()) {
                    copyDirectory(currentDB, sd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void copyDirectory(File sourceLocation, File targetLocation) {
        try {
            if (sourceLocation.isDirectory()) {
                if (!targetLocation.exists()) {
                    targetLocation.mkdirs();
                }

                String[] children = sourceLocation.list();
                for (int i = 0; i < children.length; i++) {
                    if (i >= 1) {
//                        if (targetLocation.list()[i - 1].length() < children[i - 1].length())
//                            copyDirectory(new File(sourceLocation, children[i - 1]), new File(
//                                    targetLocation, children[i - 1]));
                        if (!targetBase.equals(sourceBase))
                            copyFile(new File(sourceLocation, children[i - 1]), new File(
                                    targetLocation, children[i - 1]));
                    }
                    copyDirectory(new File(sourceLocation, children[i]), new File(
                            targetLocation, children[i]));
                }
            } else {
                copyFile(sourceLocation, targetLocation);
            }
        } catch (Exception e) {
            copyStatus = false;
            return;
        }
    }

    public static void copyFile(File sourceLocation, File targetLocation)
            throws FileNotFoundException, IOException {
        InputStream in = new FileInputStream(sourceLocation);
        OutputStream out = new FileOutputStream(targetLocation);

        // Copy the bits from instream to outstream
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        sourceBase = Base64.encodeToString(getBytes(in), Base64.DEFAULT);
        InputStream inTarget = new FileInputStream(targetLocation);
        targetBase = Base64.encodeToString(getBytes(inTarget), Base64.DEFAULT);
        in.close();
        out.close();
    }

    private static byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }
}