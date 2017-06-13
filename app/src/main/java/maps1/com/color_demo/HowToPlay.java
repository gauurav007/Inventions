package maps1.com.color_demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by home on 20/04/2017.
 */

public class HowToPlay extends AppCompatActivity
{
    Button next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_play);

        next = (Button)findViewById(R.id.nextbutton);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HowToPlay.this,Login.class);
                startActivity(i);
            }
        });
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();


        AlertDialog.Builder adb = new AlertDialog.Builder(HowToPlay.this);
        adb.setTitle("Exit");
        adb.setMessage("Do you want to exit or proceed?");
        adb.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);

            }
        });

        adb.setNegativeBgitutton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        adb.show();

    }
}
