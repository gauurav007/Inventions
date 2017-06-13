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
public class StageThree extends AppCompatActivity
{
    LinearLayout Framedesign1,Framedesign2,Framedesign3,
            Framedesign4,Framedesign5,Framedesign6,
            Framedesign7,Framedesign8,Framedesign9,Framedesign10;

    LinearLayout stagethree_layout_thread,stage_three_layout_timeplate,stagethree_yourtime_layout;

    Animation anim_stage_three,anim_stage_four,anim_bounce_trans,anim_bounce,anim_bounce_scale;

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

        setContentView(R.layout.framedesign);


        stage_three_layout_timeplate = (LinearLayout)findViewById(R.id.stagethree_timeplatelayout);

        stagethree_layout_thread = (LinearLayout)findViewById(R.id.stagethree_threadlayout);

        stagethree_yourtime_layout = (LinearLayout)findViewById(R.id.stagefourrr_yourtime_layout);
            stagethree_yourtime_layout.setVisibility(View.INVISIBLE);

        anim_bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);

        anim_bounce_trans = AnimationUtils.loadAnimation(this,R.anim.bounce_trans);

        anim_stage_three = AnimationUtils.loadAnimation(this,R.anim.pendulum);

        anim_stage_four = AnimationUtils.loadAnimation(this,R.anim.pendulum);

        anim_bounce_scale = AnimationUtils.loadAnimation(this,R.anim.cycle_transss);

        stagethree_layout_thread.startAnimation(anim_stage_three);

        stage_three_layout_timeplate.startAnimation(anim_stage_four);

        db = new MyChances(this);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

//        toolbar = (Toolbar)findViewById(R.id.stagethreetools);

        mTextField = (TextView)findViewById(R.id.stagethreetextView);

        //setSupportActionBar(toolbar);

        text2 = (TextView)findViewById(R.id.stagethreetextView2);

        text2.setVisibility(View.INVISIBLE);



        Framedesign1 = (LinearLayout)findViewById(R.id.framedesign1);

        Framedesign2 = (LinearLayout)findViewById(R.id.framedesign2);

        Framedesign3 = (LinearLayout)findViewById(R.id.framedesign3);

        Framedesign4 = (LinearLayout)findViewById(R.id.framedesign4);

        Framedesign5 = (LinearLayout)findViewById(R.id.framedesign5);

        Framedesign6 = (LinearLayout)findViewById(R.id.framedesign6);

        Framedesign7 = (LinearLayout)findViewById(R.id.framedesign7);

        Framedesign8 = (LinearLayout)findViewById(R.id.framedesign8);

        Framedesign9 = (LinearLayout)findViewById(R.id.framedesign9);

        Framedesign10 = (LinearLayout)findViewById(R.id.framedesign10);

        startTimer();

        Framedesign1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Framedesign1.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign1.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign1";
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

        Framedesign1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                Framedesign1.startAnimation(anim_bounce_scale);
                ColorDrawable viewcolor = (ColorDrawable) Framedesign1.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign1";
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

                    Framedesign1.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                    chkifmatch();

                }

                return true;
            }
        });


        Framedesign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Framedesign2.startAnimation(anim_bounce_scale);
                ColorDrawable viewcolor = (ColorDrawable)Framedesign2.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign2";
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

        Framedesign2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                Framedesign2.startAnimation(anim_bounce_scale);


                ColorDrawable viewcolor = (ColorDrawable) Framedesign2.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign2";
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

                    Framedesign2.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }

                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                        chkifmatch();

                }
                return true;
            }
        });


        Framedesign3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Framedesign3.startAnimation(anim_bounce_scale);


                ColorDrawable viewcolor = (ColorDrawable)Framedesign3.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign3";
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

        Framedesign3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                Framedesign3.startAnimation(anim_bounce_scale);


                ColorDrawable viewcolor = (ColorDrawable) Framedesign3.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign3";
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

                    Framedesign3.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }

                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                        chkifmatch();

                }
                return true;
            }
        });

        Framedesign4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Framedesign4.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign4.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign4";
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

        Framedesign4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                Framedesign4.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable) Framedesign4.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign4";
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

                    Framedesign4.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }

                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                        chkifmatch();

                }
                return true;
            }
        });


        Framedesign5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Framedesign5.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign5.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign5";
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

        Framedesign5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                Framedesign5.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable) Framedesign5.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign5";
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

                    Framedesign5.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }

                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                        chkifmatch();

                }
                return true;
            }
        });


        Framedesign6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Framedesign6.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign6.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign6";
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

        Framedesign6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                Framedesign6.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable) Framedesign6.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign6";
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

                    Framedesign6.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);

                    }
                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                        chkifmatch();

                }
                return true;
            }
        });

        Framedesign7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Framedesign7.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign7.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign7";
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

        Framedesign7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {

                Framedesign7.startAnimation(anim_bounce_scale);


                ColorDrawable viewcolor = (ColorDrawable) Framedesign7.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign7";
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

                    Framedesign7.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }

                    //}
                        chkifmatch();

                }
                return true;
            }
        });


        Framedesign8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Framedesign8.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign8.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign8";
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

        Framedesign8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                Framedesign8.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable) Framedesign8.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign8";
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

                    Framedesign8.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }

                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                        chkifmatch();

                }
                return true;
            }
        });


        Framedesign9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Framedesign9.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign9.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign9";
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

        Framedesign9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                Framedesign9.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable) Framedesign9.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign9";
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

                    Framedesign9.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
                    }
                    //}
                        chkifmatch();

                }
                return true;
            }
        });


        Framedesign10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Framedesign10.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable)Framedesign10.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "Framedesign10";
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

        Framedesign10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                Framedesign10.startAnimation(anim_bounce_scale);

                ColorDrawable viewcolor = (ColorDrawable) Framedesign10.getBackground();

                int colors = viewcolor.getColor();

                String myname = "Framedesign10";
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

                    Framedesign10.setBackgroundColor(currcolor);

                    if (currname.equals("Framedesign1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        Framedesign1.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign2")) {
                        Framedesign2.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign3.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign4.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign5.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign6.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign7.setBackgroundColor(colors);
                    } else if (currname.equals("Framedesign8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign8.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("Framedesign10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        Framedesign10.setBackgroundColor(colors);
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
                ColorDrawable viewcolor1 = (ColorDrawable)Framedesign1.getBackground();

                color1 = viewcolor1.getColor();

                //second
                ColorDrawable viewcolor2 = (ColorDrawable)Framedesign2.getBackground();

                color2 = viewcolor2.getColor();

                //third
                ColorDrawable viewcolor3 = (ColorDrawable)Framedesign3.getBackground();

                color3 = viewcolor3.getColor();

                //four
                ColorDrawable viewcolor4 = (ColorDrawable)Framedesign4.getBackground();

                color4 = viewcolor4.getColor();


                //fifth
                ColorDrawable viewcolor5 = (ColorDrawable)Framedesign5.getBackground();

                color5 = viewcolor5.getColor();

                //sixth
                ColorDrawable viewcolor6 = (ColorDrawable)Framedesign6.getBackground();

                color6 = viewcolor6.getColor();


                //seventh
                ColorDrawable viewcolor7 = (ColorDrawable)Framedesign7.getBackground();

                color7 = viewcolor7.getColor();


                //eighth
                ColorDrawable viewcolor8 = (ColorDrawable)Framedesign8.getBackground();

                color8 = viewcolor8.getColor();


                //ninth
                ColorDrawable viewcolor9 = (ColorDrawable)Framedesign9.getBackground();

                color9 = viewcolor9.getColor();



                //tenth
                ColorDrawable viewcolor10 = (ColorDrawable)Framedesign10.getBackground();

                color10 = viewcolor10.getColor();




                if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                        color1==color6 && color1==color7 && color1==color8 && color1==color9 &&
                        color1==color10)
                {

                    anim_stage_three.cancel();
                    anim_stage_four.cancel();
                    vibrator.cancel();

                    stage_three_layout_timeplate.startAnimation(anim_bounce_trans);
                    stagethree_layout_thread.startAnimation(anim_bounce_trans);

                    vibrator.cancel();
                    stage_three_layout_timeplate.setVisibility(View.INVISIBLE);
                    stagethree_layout_thread.setVisibility(View.INVISIBLE);

                    vibrator.cancel();
                    stagethree_yourtime_layout.setVisibility(View.VISIBLE);
                    stagethree_yourtime_layout.startAnimation(anim_bounce);


                    AlertDialog.Builder adb = new AlertDialog.Builder(StageThree.this);

                    adb.setTitle("you won");

                    adb.setMessage("frame completed :)");

                    adb.setCancelable(false);

                    adb.setPositiveButton("next stage", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            vibrator.cancel();
                            Intent i = new Intent(StageThree.this, StageFour.class);
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

                    text2.setText("your time" + "\n " + yourtime);

                    savescore();

                    vibrator.cancel();


                }

                else
                {


                    Toast.makeText(getApplicationContext(),"not done yet",Toast.LENGTH_SHORT).show();
                }



                mTextField.setText("   "+millisUntilFinished / 1000);

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

                AlertDialog.Builder adb = new AlertDialog.Builder(StageThree.this);

                adb.setTitle("game over");

                adb.setMessage("time over... :(");

                adb.setCancelable(false);

                adb.setPositiveButton("restart game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //check chances from db

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



                            Intent i = new Intent(StageThree.this, StageThree.class);
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
                            AlertDialog.Builder adb = new AlertDialog.Builder(StageThree.this);
                            adb.setMessage("this will be your last turn to play...");
                            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(StageThree.this, StageThree.class);
                                    startActivity(i);

                                }
                            });
                            adb.show();


                        }

                        //if chances are three then below action
                        else if(length>2)
                        {
                            //then player will be redirectedt to first level
                            AlertDialog.Builder adb = new AlertDialog.Builder(StageThree.this);
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


                                    Intent i = new Intent(StageThree.this, MainActivity.class);
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

        SharedPreferences sd = getSharedPreferences("stage3", Context.MODE_PRIVATE);

        SharedPreferences.Editor ed = sd.edit();

        ed.putString("stage3score",yourtime);

        ed.commit();


    }


    public void chkifmatch()
    {
        int color1,color2,color3,color4,color5,color6,color7,color8,color9,
                color10;

        //frst
        ColorDrawable viewcolor1 = (ColorDrawable)Framedesign1.getBackground();

        color1 = viewcolor1.getColor();

        //second
        ColorDrawable viewcolor2 = (ColorDrawable)Framedesign2.getBackground();

        color2 = viewcolor2.getColor();

        //third
        ColorDrawable viewcolor3 = (ColorDrawable)Framedesign3.getBackground();

        color3 = viewcolor3.getColor();

        //four
        ColorDrawable viewcolor4 = (ColorDrawable)Framedesign4.getBackground();

        color4 = viewcolor4.getColor();


        //fifth
        ColorDrawable viewcolor5 = (ColorDrawable)Framedesign5.getBackground();

        color5 = viewcolor5.getColor();

        //sixth
        ColorDrawable viewcolor6 = (ColorDrawable)Framedesign6.getBackground();

        color6 = viewcolor6.getColor();


        //seventh
        ColorDrawable viewcolor7 = (ColorDrawable)Framedesign7.getBackground();

        color7 = viewcolor7.getColor();


        //eighth
        ColorDrawable viewcolor8 = (ColorDrawable)Framedesign8.getBackground();

        color8 = viewcolor8.getColor();


        //ninth
        ColorDrawable viewcolor9 = (ColorDrawable)Framedesign9.getBackground();

        color9 = viewcolor9.getColor();


        //tenth
        ColorDrawable viewcolor10 = (ColorDrawable)Framedesign10.getBackground();

        color10 = viewcolor10.getColor();










        if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                color1==color6 && color1==color7 && color1==color8 && color1==color9 &&
                color1==color10)

        {
            AlertDialog.Builder adb = new AlertDialog.Builder(StageThree.this);

            adb.setTitle("you won");

            adb.setMessage("frame completed :)");

            adb.show();

            adb.setCancelable(false);

            adb.setPositiveButton("next stage", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    anim_stage_three.cancel();
                    anim_stage_four.cancel();
                    vibrator.cancel();

                    stage_three_layout_timeplate.startAnimation(anim_bounce_trans);
                    stagethree_layout_thread.startAnimation(anim_bounce_trans);

                    vibrator.cancel();
                    stage_three_layout_timeplate.setVisibility(View.INVISIBLE);
                    stagethree_layout_thread.setVisibility(View.INVISIBLE);

                    vibrator.cancel();
                    stagethree_yourtime_layout.setVisibility(View.VISIBLE);
                    stagethree_yourtime_layout.startAnimation(anim_bounce);

                    vibrator.cancel();
                    Intent i = new Intent(StageThree.this, StageFour.class);
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


        final AlertDialog.Builder adb = new AlertDialog.Builder(StageThree.this);
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
