package maps1.com.color_demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by home on 14/01/2017.
 */
public class UserScore extends AppCompatActivity
{
    ImageView iv;
    TextView tv,stage1,stage2,stage3,stage4;
    Bitmap bitmap;
    Button share;
    File imagePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.userscore);

        share = (Button)findViewById(R.id.share_score_button);

        iv = (ImageView)findViewById(R.id.scorepic);

        tv = (TextView)findViewById(R.id.score_textView);

        stage1 = (TextView)findViewById(R.id.stage1scoretextView4);

        stage2 = (TextView)findViewById(R.id.stage2scoretextView);

        stage3 = (TextView)findViewById(R.id.stage3scoretextView);

        stage4 = (TextView)findViewById(R.id.stage4scoretextView);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);
                shareIt();


            }
        });

        SharedPreferences sd = getSharedPreferences("logindata", Context.MODE_PRIVATE);

        String username = sd.getString("username", "");
        String userprofile = sd.getString("pic","");

        Uri uri = Uri.parse(userprofile);

        tv.setText(username);

       // tv.setPaintFlags(tv.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);


        try{


            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

            iv.setImageBitmap(bitmap);


            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    iv.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            iv.setVisibility(View.GONE);
                            iv.setRotationX(-90);
                            iv.setVisibility(View.VISIBLE);

                            iv.animate().rotationX(0).setDuration(200).setListener(null);
                        }
                    });

                }
            });

            iv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });

        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),"image no loaded",Toast.LENGTH_SHORT).show();
        }



        SharedPreferences sd1 = getSharedPreferences("stage1", Context.MODE_PRIVATE);

        String getscorestage1 = sd1.getString("stage1score", "");


       stage1.setText(getscorestage1);


        SharedPreferences sd2 = getSharedPreferences("stage2", Context.MODE_PRIVATE);

        String getscorestage2 = sd2.getString("stage2score", "");


        stage2.setText(getscorestage2);


        SharedPreferences sd3 = getSharedPreferences("stage3", Context.MODE_PRIVATE);

        String getscorestage3 = sd3.getString("stage3score", "");


        stage3.setText(getscorestage3);


        SharedPreferences sd4 = getSharedPreferences("stage4", Context.MODE_PRIVATE);

        String getscorestage4 = sd4.getString("stage4score", "");


        stage4.setText(getscorestage4);




    }


        /*SharedPreferences.Editor ed = sd.edit();

        ed.putString("stage1score",yourtime);

        ed.commit();
*/

    public Bitmap takeScreenshot()
    {

        // anim.cancel();
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
        imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }



    private void shareIt() {
        Uri uri = Uri.fromFile(imagePath);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("image/*");
        String shareBody = "In Tip Tap Color, My highest score here :) hippii...";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My Tweecher score");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();


        AlertDialog.Builder adb = new AlertDialog.Builder(UserScore.this);

        adb.setTitle("Exit");
        adb.setMessage("Do you want to finish the game or play again?");
        adb.setPositiveButton("play again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent i = new Intent(UserScore.this,Login.class);
                startActivity(i);
            }
        });


        adb.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
        adb.show();
    }
}
