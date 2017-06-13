 package maps1.com.color_demo;

 import android.animation.Animator;
 import android.animation.AnimatorListenerAdapter;
 import android.app.AlertDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

;

/**
 * Created by home on 13/01/2017.
 */
public class Login extends AppCompatActivity
{
    String picpath;
    FloatingActionButton floatingActionButton;
    Bitmap bitmap;
    ImageView imageView;
    Button login;//,read,delete;
    Uri uri;
    EditText e1;
    MyChances myChances;
    ArrayList<String> count = new ArrayList<String>();
    Animation anim;
    //TextInputLayout inputLayout;

    EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

     //   myChances = new MyChances(this);

        e2 = (EditText)findViewById(R.id.editText2);
        myChances = new MyChances(this);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.mybutton);

        anim = AnimationUtils.loadAnimation(this,R.anim.bounce);
  //      inputLayout = (TextInputLayout)findViewById(R.id.input_layout_name);
        login = (Button)findViewById(R.id.loginbutton);
        /*read = (Button)findViewById(R.id.readbutton);
        delete = (Button)findViewById(R.id.deletebutton2);
*/
        e1 = (EditText)findViewById(R.id.editText);

    //    e2.setText(picpath);

        e2.setVisibility(View.INVISIBLE);


  /*      read.setVisibility(View.INVISIBLE);
        delete.setVisibility(View.INVISIBLE);
*/

/*
        ColorStateList colorStateList = new ColorStateList(new int[][] {{0}}, new int[] {0xFF009900}); // 0xAARRGGBB
        login.setSupportBackgroundTintList(colorStateList);*/

//        login.setText("gaurav");

  /*      read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //ArrayList<String> count = new ArrayList<String>();
                    SQLiteDatabase sd = myChances.getReadableDatabase();

                    Cursor c =sd.query(myChances.TABLE_NAME,null,null,null,null,null,null);

                    count.clear();

                    while (c.moveToNext())
                    {
                        count.add(c.getString(0));
                    }

                    Toast.makeText(getApplicationContext(),""+count,Toast.LENGTH_SHORT).show();

                //count.clear();

                Toast.makeText(getApplicationContext(),"list cleared",Toast.LENGTH_SHORT).show();

*//*
                Intent i = new Intent(Login.this,MainActivity.class);
                startActivity(i);*//*
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                String sql = "delete from"+myChances.COL_TOTAL_CHANCES;

                String sql = "delete from mychances";
                SQLiteDatabase sd = myChances.getWritableDatabase();
             //   sd.delete(myChances.TABLE_NAME,myChances.COL_TOTAL_CHANCES+"=?",new String[]{count.get(0)});

                //sd.rawQuery(sql,null);

              //  sd.execSQL(" delete from "+myChances.TABLE_NAME);

                  sd.execSQL(" delete from mychances ");

                //count.add(sd.execSQL("select * from mychances"));

                count.clear();

                sd.close();

                Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();


                Toast.makeText(getApplicationContext(),""+count,Toast.LENGTH_SHORT).show();




            }
        });
*/
        imageView = (ImageView)findViewById(R.id.mypic);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                e2.setText("pic uploaded");

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 300);



                floatingActionButton.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        floatingActionButton.setVisibility(View.GONE);
                        floatingActionButton.setRotationX(-90);
                        floatingActionButton.setVisibility(View.VISIBLE);

                        floatingActionButton.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });




            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                login.startAnimation(anim);

 if(e1.getText().toString().equals("") && e2.getText().toString().equals(""))
 {
     login.setText("your details");
 }

else if(e1.getText().toString().equals(""))
{
    //Toast.makeText(getApplicationContext(),"please fill your details",Toast.LENGTH_SHORT).show();

    login.setText("enter name");
}

else if(e2.getText().toString().equals(""))
{
    //Toast.makeText(getApplicationContext(),"please upload your pic",Toast.LENGTH_SHORT).show();
  //  picpath = uri.toString();

    login.setText("your pic missing");
}
else
    {

        picpath = uri.toString();
        SharedPreferences sd = getSharedPreferences("logindata", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sd.edit();
        ed.putString("pic", picpath);
        ed.putString("username", e1.getText().toString());
        ed.commit();



       /* SQLiteDatabase sdd = myChances.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(myChances.COL_TOTAL_CHANCES, e1.getText().toString());

        sdd.insert(myChances.TABLE_NAME, myChances.COL_TOTAL_CHANCES, cv);

        sdd.close();
        cv.clear();*/


        myChances.close();

        Intent i = new Intent(Login.this,MainActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

    }

            }
        });

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK && requestCode==300)
        {


            try {
               uri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                imageView.setImageBitmap(bitmap);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        final AlertDialog.Builder adb = new AlertDialog.Builder(Login.this);
        adb.setTitle("Exit");
        adb.setMessage("Are you sure you want to exit?");
        adb.setCancelable(false);
        //adb.setIcon(R.drawable.)
        //adb.setInverseBackgroundForced( true);
        adb.setPositiveButton("YES", new DialogInterface.OnClickListener() {





            @Override
            public void onClick(DialogInterface arg0, int arg1)
            {
                // TODO Auto-generated method stub

                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);

            }
        });

        adb.setNegativeButton("NO", new DialogInterface.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface arg0, int arg1)
            {
                // TODO Auto-generated method stub
                //finish();

                adb.setCancelable(true);
            }
        });

        //AlertDialog alert = adb.create();

        //alert.getWindow().setBackgroundDrawableResource(R.drawable.hand_2);

        adb.show();


    }
}
