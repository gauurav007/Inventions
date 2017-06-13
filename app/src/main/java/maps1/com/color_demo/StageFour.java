package maps1.com.color_demo;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by home on 05/01/2017.
 */
public class StageFour extends AppCompatActivity
{
    LinearLayout brick1,brick2,brick3,brick4,brick5,brick6,
            brick7,brick8;

    LinearLayout stagefour_layout_thread,stagefour_layout_timeplate,stagefive_yourtime_layout;

    Animation anim_Layout_thread,anim_Layout_timeplate,anim_bounce,anim_bounce_trans,anim_cycle;


    LinkedList<String> demolist = new LinkedList<String>();
    LinkedList<String> name = new LinkedList<String>();
    LinkedList<String> color = new LinkedList<String>();

    TextView mTextField,text2;
//    Toolbar toolbar;
    View v;
    Vibrator vibrator;
    CountDownTimer Count;
    String yourtime;
    int length;
    ArrayList<String> chances = new ArrayList<String>();
    MyChances db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.brickdesign);

        db = new MyChances(this);

        stagefour_layout_thread = (LinearLayout)findViewById(R.id.stagefour_threadlayout);

        stagefour_layout_timeplate = (LinearLayout)findViewById(R.id.stagefour_timeplatelayout);

        stagefive_yourtime_layout = (LinearLayout)findViewById(R.id.stagefive_layout);

        stagefive_yourtime_layout.setVisibility(View.INVISIBLE);

        anim_bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);

        anim_bounce_trans = AnimationUtils.loadAnimation(this,R.anim.bounce_trans);

        anim_Layout_thread = AnimationUtils.loadAnimation(this,R.anim.pendulum);

        anim_Layout_timeplate = AnimationUtils.loadAnimation(this,R.anim.pendulum);

        anim_cycle = AnimationUtils.loadAnimation(this,R.anim.cycle_trans);

        stagefour_layout_thread.startAnimation(anim_Layout_thread);

        stagefour_layout_timeplate.startAnimation(anim_Layout_thread);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

  //      toolbar = (Toolbar)findViewById(R.id.stagefourtools);

        mTextField = (TextView)findViewById(R.id.stagefourtextView);

        //setSupportActionBar(toolbar);

        text2 = (TextView)findViewById(R.id.stagefourtextView2);

        text2.setVisibility(View.INVISIBLE);




        brick1 =(LinearLayout)findViewById(R.id.brickdesign1);

        brick2 =(LinearLayout)findViewById(R.id.brickdesign2);

        brick3 =(LinearLayout)findViewById(R.id.brickdesign3);

        brick4 =(LinearLayout)findViewById(R.id.brickdesign4);

        brick5 =(LinearLayout)findViewById(R.id.brickdesign5);

        brick6 =(LinearLayout)findViewById(R.id.brickdesign6);

        brick7 =(LinearLayout)findViewById(R.id.brickdesign7);

        brick8 =(LinearLayout)findViewById(R.id.brickdesign8);

        startTimer();


        brick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brick1.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick1.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick1";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);
c
                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                chkifmatch();

            }
        });

        brick1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                brick1.startAnimation(anim_cycle);
                ColorDrawable viewcolor = (ColorDrawable)brick1.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick1";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick1.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                    chkifmatch();

                }


                return true;
            }
        });

        brick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                brick2.startAnimation(anim_cycle);
                ColorDrawable viewcolor = (ColorDrawable)brick2.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick2";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);

                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                         chkifmatch();


            }
        });

        brick2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                brick2.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick2.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick2";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick2.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                      chkifmatch();

                }
                return true;
            }
        });


        brick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                brick3.startAnimation(anim_cycle);
                ColorDrawable viewcolor = (ColorDrawable)brick3.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick3";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);

                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                           chkifmatch();

            }
        });

        brick3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                brick3.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick3.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick3";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick3.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                      chkifmatch();

                }

                return true;
            }
        });


        brick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                brick4.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick4.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick4";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);

                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                         chkifmatch();


            }
        });

        brick4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                brick4.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick4.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick4";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick4.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                      chkifmatch();

                }

                return true;
            }
        });


        brick5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                brick5.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick5.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick5";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);

                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                           chkifmatch();

            }
        });

        brick5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                brick5.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick5.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick5";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick5.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                      chkifmatch();

                }


                return true;
            }
        });


        brick6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brick6.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick6.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick6";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);

                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                         chkifmatch();

            }
        });

        brick6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                brick6.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick6.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick6";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick6.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                      chkifmatch();

                }
                return true;
            }
        });

        brick7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                brick7.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick7.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick7";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);

                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                         chkifmatch();


            }
        });

        brick7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                brick7.startAnimation(anim_cycle);
                ColorDrawable viewcolor = (ColorDrawable)brick7.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick7";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick7.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                      chkifmatch();

                }
                return true;
            }
        });


        brick8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                brick8.startAnimation(anim_cycle);
                ColorDrawable viewcolor = (ColorDrawable)brick8.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "brick8";
                String mycolor = String.valueOf(colors);

                 /*Toast.makeText(getApplicationContext(),"after parsing"+mycolor,Toast.LENGTH_LONG).show();

                 Integer vol = Integer.valueOf(mycolor);

                 Toast.makeText(getApplicationContext(),"again after parsing"+vol,Toast.LENGTH_LONG).show();
*/

                name.add(myname);
                color.add(mycolor);

                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                           chkifmatch();

            }
        });

        brick8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                brick8.startAnimation(anim_cycle);

                ColorDrawable viewcolor = (ColorDrawable)brick8.getBackground();

                int colors = viewcolor.getColor();

                String myname = "brick8";
                String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                //else
                //{
                if (name.isEmpty() || color.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                } else {
                    String currname;//,currcolor;

                    currname = name.getLast();

                    int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                    //red.setBackgroundColor(Color.parseColor(currcolor));

                    brick8.setBackgroundColor(currcolor);

                    if (currname.equals("brick1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        brick1.setBackgroundColor(colors);
                    } else if (currname.equals("brick2")) {
                        brick2.setBackgroundColor(colors);
                    } else if (currname.equals("brick3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick3.setBackgroundColor(colors);
                    } else if (currname.equals("brick4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick4.setBackgroundColor(colors);
                    } else if (currname.equals("brick5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick5.setBackgroundColor(colors);
                    } else if (currname.equals("brick6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick6.setBackgroundColor(colors);
                    } else if (currname.equals("brick7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick7.setBackgroundColor(colors);
                    } else if (currname.equals("brick8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        brick8.setBackgroundColor(colors);
                    }

                    //}
                      chkifmatch();

                }

                return true;
            }
        });
    }


    private void startTimer()
    {


        Count =  new CountDownTimer(30000, 1000)
        {

            public void onTick(long millisUntilFinished)
            {
                // chkifmatch();


                int color1,color2,color3,color4,color5,color6,color7,color8,color9,
                        color10,color11,color12,color13,color14,color15,color16;

                //frst
                ColorDrawable viewcolor1 = (ColorDrawable)brick1.getBackground();

                color1 = viewcolor1.getColor();

                //second
                ColorDrawable viewcolor2 = (ColorDrawable)brick2.getBackground();

                color2 = viewcolor2.getColor();

                //third
                ColorDrawable viewcolor3 = (ColorDrawable)brick3.getBackground();

                color3 = viewcolor3.getColor();

                //four
                ColorDrawable viewcolor4 = (ColorDrawable)brick4.getBackground();

                color4 = viewcolor4.getColor();


                //fifth
                ColorDrawable viewcolor5 = (ColorDrawable)brick5.getBackground();

                color5 = viewcolor5.getColor();

                //sixth
                ColorDrawable viewcolor6 = (ColorDrawable)brick6.getBackground();

                color6 = viewcolor6.getColor();


                //seventh
                ColorDrawable viewcolor7 = (ColorDrawable)brick7.getBackground();

                color7 = viewcolor7.getColor();


                //eighth
                ColorDrawable viewcolor8 = (ColorDrawable)brick8.getBackground();

                color8 = viewcolor8.getColor();





                if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                        color1==color6 && color1==color7 && color1==color8)
                {

                    anim_Layout_thread.cancel();
                    anim_Layout_timeplate.cancel();
                    vibrator.cancel();

                    stagefour_layout_thread.startAnimation(anim_bounce_trans);
                    stagefour_layout_timeplate.startAnimation(anim_bounce_trans);

                    vibrator.cancel();
                    stagefour_layout_thread.setVisibility(View.INVISIBLE);
                    stagefour_layout_timeplate.setVisibility(View.INVISIBLE);

                    vibrator.cancel();
                    stagefive_yourtime_layout.setVisibility(View.VISIBLE);
                    stagefive_yourtime_layout.startAnimation(anim_bounce);



                    AlertDialog.Builder adb = new AlertDialog.Builder(StageFour.this);

                    adb.setTitle("you won");

                    adb.setMessage("frame completed :)");

                    adb.setCancelable(false);

                    adb.setPositiveButton("check score", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            vibrator.cancel();
                            Intent i = new Intent(StageFour.this, UserScore.class);
                            startActivity(i);
                            //cancle to stop timer
                            cancel();

                            String sql = "delete from mychances";
                            SQLiteDatabase sd = db.getWritableDatabase();

                            sd.execSQL(" delete from mychances ");


                            sd.close();

                            Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();


                            Toast.makeText(getApplicationContext(),""+length,Toast.LENGTH_SHORT).show();

                            overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

                        }
                    });

                    adb.show();

                    //    mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);

                    long no = millisUntilFinished/1000;

                    String finalcount = String.valueOf(no);
                    text2.setText(finalcount);

                    //   onFinish();

                    //               cancel();
                    //cancle to stop timer
                    cancel();

                    mTextField.setVisibility(View.INVISIBLE);


                    String finaltime = text2.getText().toString();

                    Toast.makeText(getApplicationContext(),finaltime,Toast.LENGTH_LONG).show();

                    int completedtime = Integer.valueOf(finaltime);

                    int framecompletedtime = 50 - completedtime;

                     yourtime = String.valueOf(framecompletedtime);


                    text2.setVisibility(View.VISIBLE);

                    text2.setText("your time" + "\n" + yourtime);

                    savescore();

                    vibrator.cancel();


                }

                else
                {


                    Toast.makeText(getApplicationContext(),"not done yet",Toast.LENGTH_SHORT).show();
                }



                mTextField.setText("    "+millisUntilFinished / 1000);

                long timer = millisUntilFinished/1000;
                if(timer==5)
                {

                    vibrator.vibrate(5000);
                    /*if(timer==0)
                    {

                    }*/
                }

            }

            public void onFinish()
            {
                mTextField.setText(" ");

                AlertDialog.Builder adb = new AlertDialog.Builder(StageFour.this);

                adb.setTitle("game over");

                adb.setMessage("time over... :(");

                adb.setCancelable(false);

                adb.setPositiveButton("restart game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        chances.clear();
                        SQLiteDatabase sd = db.getReadableDatabase();

                        Cursor c = sd.query(db.TABLE_NAME,null,null,null,null,null,null);

                        while(c.moveToNext())
                        {
                            chances.add(c.getString(0));
                        }

                        length = chances.size();

                        //chances are 0 or 1 perform below action
                        if(length==0 || length==1)
                        {
                            SQLiteDatabase sdstore = db.getWritableDatabase();
                            ContentValues cv = new ContentValues();
                            cv.put(db.COL_TOTAL_CHANCES, "1");
                            sdstore.insert(db.TABLE_NAME, db.COL_TOTAL_CHANCES, cv);
                            cv.clear();
                            db.close();



                            Intent i = new Intent(StageFour.this, StageFour.class);
                            startActivity(i);
                        }
                        //if chances are two then below action
                        else if(length==2)
                        {
                            SQLiteDatabase sdstore = db.getWritableDatabase();
                            ContentValues cv = new ContentValues();
                            cv.put(db.COL_TOTAL_CHANCES, "1");
                            sdstore.insert(db.TABLE_NAME, db.COL_TOTAL_CHANCES, cv);
                            cv.clear();
                            db.close();

                            //chances.clear();

                            //warning to the palyer of last chance
                            AlertDialog.Builder adb = new AlertDialog.Builder(StageFour.this);
                            adb.setMessage("this will be your last turn to play...");
                            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(StageFour.this, StageFour.class);
                                    startActivity(i);

                                }
                            });
                            adb.show();


                        }

                        //if chances are three then below action
                        else if(length>2)
                        {
                            //then player will be redirectedt to first level
                            AlertDialog.Builder adb = new AlertDialog.Builder(StageFour.this);
                            adb.setMessage("you lost your all turns... play again..");
                            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {

                                    String sql = "delete from mychances";
                                    SQLiteDatabase sd = db.getWritableDatabase();

                                    sd.execSQL(" delete from mychances ");


                                    sd.close();

                                    Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();


                                    Toast.makeText(getApplicationContext(),""+length,Toast.LENGTH_SHORT).show();


                                    Intent i = new Intent(StageFour.this, MainActivity.class);
                                    startActivity(i);

                                }
                            });
                            adb.show();
                        }

                    }
                });


                adb.show();

            }
        }.start();
    }


    public void savescore()
    {
        SharedPreferences sd = getSharedPreferences("stage4", Context.MODE_PRIVATE);

        SharedPreferences.Editor ed = sd.edit();

        ed.putString("stage4score",yourtime);

        ed.commit();


    }


    public void chkifmatch()
    {
        int color1,color2,color3,color4,color5,color6,color7,color8;

        //frst
        ColorDrawable viewcolor1 = (ColorDrawable)brick1.getBackground();

        color1 = viewcolor1.getColor();

        //second
        ColorDrawable viewcolor2 = (ColorDrawable)brick2.getBackground();

        color2 = viewcolor2.getColor();

        //third
        ColorDrawable viewcolor3 = (ColorDrawable)brick3.getBackground();

        color3 = viewcolor3.getColor();

        //four
        ColorDrawable viewcolor4 = (ColorDrawable)brick4.getBackground();

        color4 = viewcolor4.getColor();


        //fifth
        ColorDrawable viewcolor5 = (ColorDrawable)brick5.getBackground();

        color5 = viewcolor5.getColor();

        //sixth
        ColorDrawable viewcolor6 = (ColorDrawable)brick6.getBackground();

        color6 = viewcolor6.getColor();


        //seventh
        ColorDrawable viewcolor7 = (ColorDrawable)brick7.getBackground();

        color7 = viewcolor7.getColor();


        //eighth
        ColorDrawable viewcolor8 = (ColorDrawable)brick8.getBackground();

        color8 = viewcolor8.getColor();













        if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                color1==color6 && color1==color7 && color1==color8)

        {
            AlertDialog.Builder adb = new AlertDialog.Builder(StageFour.this);

            adb.setTitle("you won");

            adb.setMessage("frame completed :)");

            adb.show();

            adb.setCancelable(false);

            adb.setPositiveButton("Check Score", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    anim_Layout_thread.cancel();
                    anim_Layout_timeplate.cancel();
                    vibrator.cancel();

                    stagefour_layout_thread.startAnimation(anim_bounce_trans);
                    stagefour_layout_timeplate.startAnimation(anim_bounce_trans);

                    vibrator.cancel();
                    stagefour_layout_thread.setVisibility(View.INVISIBLE);
                    stagefour_layout_timeplate.setVisibility(View.INVISIBLE);

                    vibrator.cancel();
                    stagefive_yourtime_layout.setVisibility(View.VISIBLE);
                    stagefive_yourtime_layout.startAnimation(anim_bounce);



                    vibrator.cancel();
                    Intent i = new Intent(StageFour.this, UserScore.class);
                    startActivity(i);
                    //cancle to stop timer
                    Count.cancel();

                    String sql = "delete from mychances";
                    SQLiteDatabase sd = db.getWritableDatabase();

                    sd.execSQL(" delete from mychances ");


                    sd.close();

                    Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();


                    Toast.makeText(getApplicationContext(),""+length,Toast.LENGTH_SHORT).show();

                    overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

                }
            });




        }

        else
        {


            Toast.makeText(getApplicationContext(),"not done yet",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();


        final AlertDialog.Builder adb = new AlertDialog.Builder(StageFour.this);
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
//