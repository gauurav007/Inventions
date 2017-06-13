package maps1.com.color_demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;

/**
 * Created by Gaurav on 03/01/2017.
 */
public class StageTwo extends AppCompatActivity
{
    LinearLayout homframe1,homframe2,homframe3,homframe4,homframe5,homframe6,homframe7,
            homframe8,homframe9,homframe10,homframe11,homframe12,homframe13;

    LinearLayout stagetwo_timeplate,stagetwo_thred,your_time_layout;

    Animation stagetwo_thread_anim,stagetwo_timeplate_anim,yourtime_anim,cycle_bounce;

    FrameLayout alert_winnig_frame,stage_two_gameOvr_frame,stage_two_last_turn_frame,stage_two_last_fram;
    Button alert_win_button,stage_two_gameOver_button,stage_two_last_turn_button,stage_two_last_button;
    Animation anim_winnig_alert_frame;
    TextView gameOverTextView;


    final BounceInterpolator interpolator = new BounceInterpolator();

    LinkedList<String> demolist = new LinkedList<String>();
    LinkedList<String> name = new LinkedList<String>();
    LinkedList<String> color = new LinkedList<String>();

  //  VideoView vv;

    TextView mTextField,text2;
    //Toolbar toolbar;
    View v;
    Vibrator vibrator;
    CountDownTimer Count;
    String yourtime;
    int length;
    MyChances db;
    ArrayList<String> chances = new ArrayList<String>();
    Animation anim_rotate_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.three_three_layout);

        setContentView(R.layout.homeframe2);

        alert_win_button= (Button)findViewById(R.id.stagetwo_winning_alert_button);

        alert_winnig_frame = (FrameLayout)findViewById(R.id.stagetwo_winning_alert_box);
        anim_winnig_alert_frame = AnimationUtils.loadAnimation(this,R.anim.bounce_scale);
        alert_winnig_frame.setVisibility(View.INVISIBLE);

        stage_two_gameOvr_frame =(FrameLayout)findViewById(R.id.stagetwo_gameover_alert);

        //stage_two_gameOver_button = (Button)findViewById(R.id.stagetwo_game_over_button);

        gameOverTextView = (TextView)findViewById(R.id.stagetwo_game_over_button);

        stage_two_gameOvr_frame.setVisibility(View.INVISIBLE);


        stage_two_last_turn_frame = (FrameLayout)findViewById(R.id.stage_two_lastturn_frame);

        stage_two_last_turn_button =(Button)findViewById(R.id.stage_two_lastturn_button);
        stage_two_last_turn_frame.setVisibility(View.INVISIBLE);

        stage_two_last_fram = (FrameLayout)findViewById(R.id.stage_two_lost_turns_frame);
        stage_two_last_button  =(Button)findViewById(R.id.stage_two_lost_turn_button);
        stage_two_last_fram.setVisibility(View.INVISIBLE);

        anim_rotate_in = AnimationUtils.loadAnimation(this,R.anim.rotate_vertical);

        db = new MyChances(this);

        stagetwo_thred = (LinearLayout)findViewById(R.id.stagetwothread);
        stagetwo_timeplate = (LinearLayout)findViewById(R.id.stagetwotimeplate);

        your_time_layout = (LinearLayout)findViewById(R.id.stage2_yourtime_layout);

        your_time_layout.setVisibility(View.INVISIBLE);
        stagetwo_thread_anim = AnimationUtils.loadAnimation(this,R.anim.pendulum);
        stagetwo_timeplate_anim = AnimationUtils.loadAnimation(this,R.anim.pendulum);
        yourtime_anim = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cycle_bounce = AnimationUtils.loadAnimation(this,R.anim.cycle_trans);

        stagetwo_thred.startAnimation(stagetwo_thread_anim);
        stagetwo_timeplate.startAnimation(stagetwo_timeplate_anim);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        //toolbar = (Toolbar)findViewById(R.id.stagetwotools);

        mTextField = (TextView)findViewById(R.id.stagetwotextView);

      //  setSupportActionBar(toolbar);

        text2 = (TextView)findViewById(R.id.stagetwotextView2);

        text2.setVisibility(View.INVISIBLE);


        homframe1 = (LinearLayout)findViewById(R.id.homeframe1);
            homframe2 = (LinearLayout)findViewById(R.id.homeframe2);
        homframe3 = (LinearLayout)findViewById(R.id.homeframe3);
        homframe4 = (LinearLayout)findViewById(R.id.homeframe4);
        homframe5 = (LinearLayout)findViewById(R.id.homeframe5);
        homframe6 = (LinearLayout)findViewById(R.id.homeframe6);
        homframe7 = (LinearLayout)findViewById(R.id.homeframe7);
        homframe8 = (LinearLayout)findViewById(R.id.homeframe8);
        homframe9 = (LinearLayout)findViewById(R.id.homeframe9);
        homframe10 = (LinearLayout)findViewById(R.id.homeframe10);
        homframe11 = (LinearLayout)findViewById(R.id.homeframe11);
        homframe12 = (LinearLayout)findViewById(R.id.homeframe12);
        homframe13 = (LinearLayout)findViewById(R.id.homeframe13);

        startTimer();

     /*   vv = (VideoView)findViewById(R.id.videoview22);
        vv.setVisibility(View.INVISIBLE);
        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tiggger));
*/


        homframe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {



                homframe1.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe1.setVisibility(View.GONE);
                        homframe1.setRotationX(-90);
                        homframe1.setVisibility(View.VISIBLE);

                        homframe1.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });


                ColorDrawable viewcolor = (ColorDrawable) homframe1.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe1";
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

        homframe1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {



                homframe1.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe1.setVisibility(View.GONE);
                        homframe1.setRotationX(-90);
                        homframe1.setVisibility(View.VISIBLE);

                        homframe1.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe1.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe1";
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

                    homframe1.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                    chkifmatch();

                }

                return true;
            }
        });


        homframe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                homframe2.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe2.setVisibility(View.GONE);
                        homframe2.setRotationX(-90);
                        homframe2.setVisibility(View.VISIBLE);

                        homframe2.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });

                ColorDrawable viewcolor = (ColorDrawable) homframe2.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe2";
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

        homframe2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe2.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe2.setVisibility(View.GONE);
                        homframe2.setRotationX(-90);
                        homframe2.setVisibility(View.VISIBLE);

                        homframe2.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });


                ColorDrawable viewcolor = (ColorDrawable) homframe2.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe2";
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

                    homframe2.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                      chkifmatch();

                }

                return true;
            }
        });


        homframe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe3.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe3.setVisibility(View.GONE);
                        homframe3.setRotationX(-90);
                        homframe3.setVisibility(View.VISIBLE);

                        homframe3.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });

                ColorDrawable viewcolor = (ColorDrawable) homframe3.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe3";
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

        homframe3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe3.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe3.setVisibility(View.GONE);
                        homframe3.setRotationX(-90);
                        homframe3.setVisibility(View.VISIBLE);

                        homframe3.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });

                ColorDrawable viewcolor = (ColorDrawable) homframe3.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe3";
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

                    homframe3.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                      chkifmatch();

                }


                return true;
            }
        });

        homframe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe4.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe4.setVisibility(View.GONE);
                        homframe4.setRotationX(-90);
                        homframe4.setVisibility(View.VISIBLE);

                        homframe4.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });

                ColorDrawable viewcolor = (ColorDrawable) homframe4.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe4";
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

        homframe4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {



                homframe4.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe4.setVisibility(View.GONE);
                        homframe4.setRotationX(-90);
                        homframe4.setVisibility(View.VISIBLE);

                        homframe4.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });

                ColorDrawable viewcolor = (ColorDrawable) homframe4.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe4";
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

                    homframe4.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                       chkifmatch();

                }


                return true;
            }
        });

        homframe5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe5.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe5.setVisibility(View.GONE);
                        homframe5.setRotationX(-90);
                        homframe5.setVisibility(View.VISIBLE);

                        homframe5.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe5.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe5";
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

        homframe5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe5.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe5.setVisibility(View.GONE);
                        homframe5.setRotationX(-90);
                        homframe5.setVisibility(View.VISIBLE);

                        homframe5.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe5.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe5";
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

                    homframe5.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                       chkifmatch();

                }

                return true;
            }
        });

        homframe6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe6.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe6.setVisibility(View.GONE);
                        homframe6.setRotationX(-90);
                        homframe6.setVisibility(View.VISIBLE);

                        homframe6.animate().rotationX(0).setDuration(200).setListener(null);
                    }
                });
      //          homframe6.startAnimation(anim_rotate_in);
                ColorDrawable viewcolor = (ColorDrawable) homframe6.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe6";
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

        homframe6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


        //        homframe6.startAnimation(anim_rotate_in);


                homframe6.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe6.setVisibility(View.GONE);
                        homframe6.setRotationX(-90);
                        homframe6.setVisibility(View.VISIBLE);

                        homframe6.animate().rotationX(0).setDuration(200).setListener(null);//setInterpolator(interpolator);
                    }
                });

                ColorDrawable viewcolor = (ColorDrawable) homframe6.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe6";
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

                    homframe6.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                       chkifmatch();

                }


                return true;
            }
        });

        homframe7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe7.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe7.setVisibility(View.GONE);
                        homframe7.setRotationX(-90);
                        homframe7.setVisibility(View.VISIBLE);

                        homframe7.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
          //      homframe7.startAnimation(anim_rotate_in);

                ColorDrawable viewcolor = (ColorDrawable) homframe7.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe7";
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

        homframe7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe7.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe7.setVisibility(View.GONE);
                        homframe7.setRotationX(-90);
                        homframe7.setVisibility(View.VISIBLE);

                        homframe7.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });

//                homframe7.startAnimation(anim_rotate_in);
                ColorDrawable viewcolor = (ColorDrawable) homframe7.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe7";
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

                    homframe7.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                       chkifmatch();

                }


                return true;
            }
        });


        homframe8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {



                homframe8.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe8.setVisibility(View.GONE);
                        homframe8.setRotationX(-90);
                        homframe8.setVisibility(View.VISIBLE);

                        homframe8.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
  //              homframe8.startAnimation(anim_rotate_in);
                ColorDrawable viewcolor = (ColorDrawable) homframe8.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe8";
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

        homframe8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe8.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe8.setVisibility(View.GONE);
                        homframe8.setRotationX(-90);
                        homframe8.setVisibility(View.VISIBLE);

                        homframe8.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
    //            homframe8.startAnimation(anim_rotate_in);
                ColorDrawable viewcolor = (ColorDrawable) homframe8.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe8";
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

                    homframe8.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                    chkifmatch();

                }



                return true;
            }
        });


        homframe9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe9.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe9.setVisibility(View.GONE);
                        homframe9.setRotationX(-90);
                        homframe9.setVisibility(View.VISIBLE);

                        homframe9.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });

      //          homframe9.startAnimation(anim_rotate_in);
                ColorDrawable viewcolor = (ColorDrawable) homframe9.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe9";
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

        homframe9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe9.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe9.setVisibility(View.GONE);
                        homframe9.setRotationX(-90);
                        homframe9.setVisibility(View.VISIBLE);

                        homframe9.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
        //        homframe9.startAnimation(anim_rotate_in);
                ColorDrawable viewcolor = (ColorDrawable) homframe9.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe9";
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

                    homframe9.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                       chkifmatch();

                }



                return true;
            }
        });


        homframe10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe10.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe10.setVisibility(View.GONE);
                        homframe10.setRotationX(-90);
                        homframe10.setVisibility(View.VISIBLE);

                        homframe10.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe10.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe10";
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

        homframe10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe10.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe10.setVisibility(View.GONE);
                        homframe10.setRotationX(-90);
                        homframe10.setVisibility(View.VISIBLE);

                        homframe10.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });


                ColorDrawable viewcolor = (ColorDrawable) homframe10.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe10";
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

                    homframe10.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                    chkifmatch();

                }



                return true;
            }
        });

        homframe11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe11.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe11.setVisibility(View.GONE);
                        homframe11.setRotationX(-90);
                        homframe11.setVisibility(View.VISIBLE);

                        homframe11.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe11.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe11";
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

        homframe11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe11.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe11.setVisibility(View.GONE);
                        homframe11.setRotationX(-90);
                        homframe11.setVisibility(View.VISIBLE);

                        homframe11.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe11.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe11";
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

                    homframe11.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                    chkifmatch();

                }


                return true;
            }
        });

        homframe12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe12.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe12.setVisibility(View.GONE);
                        homframe12.setRotationX(-90);
                        homframe12.setVisibility(View.VISIBLE);

                        homframe12.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe12.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe12";
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

        homframe12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe12.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe12.setVisibility(View.GONE);
                        homframe12.setRotationX(-90);
                        homframe12.setVisibility(View.VISIBLE);

                        homframe12.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });

                ColorDrawable viewcolor = (ColorDrawable) homframe12.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe12";
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

                    homframe12.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
                    }


                    //}
                       chkifmatch();

                }

                return true;
            }
        });

        homframe13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                homframe13.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe13.setVisibility(View.GONE);
                        homframe13.setRotationX(-90);
                        homframe13.setVisibility(View.VISIBLE);

                        homframe13.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe13.getBackground();

                int colors = viewcolor.getColor();

                Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                String myname = "homframe13";
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

        homframe13.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {


                homframe13.animate().rotationX(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        homframe13.setVisibility(View.GONE);
                        homframe13.setRotationX(-90);
                        homframe13.setVisibility(View.VISIBLE);

                        homframe13.animate().rotationX(0).setDuration(200).setListener(null);//.setInterpolator(interpolator);
                    }
                });
                ColorDrawable viewcolor = (ColorDrawable) homframe13.getBackground();

                int colors = viewcolor.getColor();

                String myname = "homframe13";
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

                    homframe13.setBackgroundColor(currcolor);

                    if (currname.equals("homframe1")) {
                        //orange.setBackgroundColor(Color.parseColor(mycolor));

                        homframe1.setBackgroundColor(colors);
                    } else if (currname.equals("homframe2")) {
                        homframe2.setBackgroundColor(colors);
                    } else if (currname.equals("homframe3")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe3.setBackgroundColor(colors);
                    } else if (currname.equals("homframe4")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe4.setBackgroundColor(colors);
                    } else if (currname.equals("homframe5")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe5.setBackgroundColor(colors);
                    } else if (currname.equals("homframe6")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe6.setBackgroundColor(colors);
                    } else if (currname.equals("homframe7")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe7.setBackgroundColor(colors);
                    } else if (currname.equals("homframe8")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe8.setBackgroundColor(colors);
                    } else if (currname.equals("homframe9")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe9.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe10")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe10.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe11")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe11.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe12")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe12.setBackgroundColor(colors);
                    }
                    else if (currname.equals("homframe13")) {
                        // orange.setBackgroundColor(Color.parseColor(mycolor));
                        homframe13.setBackgroundColor(colors);
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
                ColorDrawable viewcolor1 = (ColorDrawable)homframe1.getBackground();

                color1 = viewcolor1.getColor();

                //second
                ColorDrawable viewcolor2 = (ColorDrawable)homframe2.getBackground();

                color2 = viewcolor2.getColor();

                //third
                ColorDrawable viewcolor3 = (ColorDrawable)homframe3.getBackground();

                color3 = viewcolor3.getColor();

                //four
                ColorDrawable viewcolor4 = (ColorDrawable)homframe4.getBackground();

                color4 = viewcolor4.getColor();


                //fifth
                ColorDrawable viewcolor5 = (ColorDrawable)homframe5.getBackground();

                color5 = viewcolor5.getColor();

                //sixth
                ColorDrawable viewcolor6 = (ColorDrawable)homframe6.getBackground();

                color6 = viewcolor6.getColor();


                //seventh
                ColorDrawable viewcolor7 = (ColorDrawable)homframe7.getBackground();

                color7 = viewcolor7.getColor();


                //eighth
                ColorDrawable viewcolor8 = (ColorDrawable)homframe8.getBackground();

                color8 = viewcolor8.getColor();


                //ninth
                ColorDrawable viewcolor9 = (ColorDrawable)homframe9.getBackground();

                color9 = viewcolor9.getColor();



                //tenth
                ColorDrawable viewcolor10 = (ColorDrawable)homframe10.getBackground();

                color10 = viewcolor10.getColor();


                //eleventh
                ColorDrawable viewcolor11 = (ColorDrawable)homframe11.getBackground();

                color11 = viewcolor11.getColor();

                //twelevth
                ColorDrawable viewcolor12 = (ColorDrawable)homframe12.getBackground();

                color12 = viewcolor12.getColor();


                //Thirteen
                ColorDrawable viewcolor13 = (ColorDrawable)homframe13.getBackground();

                color13 = viewcolor13.getColor();



                if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                        color1==color6 && color1==color7 && color1==color8 && color1==color9 &&
                        color1==color10 && color1==color11 && color1==color12 && color1==color13)
                {


                    stagetwo_thread_anim.cancel();
                    stagetwo_timeplate_anim.cancel();

                    vibrator.cancel();
                    stagetwo_thred.startAnimation(cycle_bounce);
                    stagetwo_timeplate.startAnimation(cycle_bounce);

                    vibrator.cancel();
                    stagetwo_thred.setVisibility(View.INVISIBLE);
                    stagetwo_timeplate.setVisibility(View.INVISIBLE);


                    your_time_layout.setVisibility(View.VISIBLE);
                    your_time_layout.startAnimation(yourtime_anim);

                    vibrator.cancel();


                    //new implementations
                    //make visible
                    //add anim
                    //all actions of alertbox on button

                    alert_winnig_frame.setVisibility(View.VISIBLE);
                    alert_winnig_frame.startAnimation(anim_winnig_alert_frame);
                    alert_win_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(getApplicationContext(), "" + "working", Toast.LENGTH_SHORT).show();


                            vibrator.cancel();
                            Intent i = new Intent(StageTwo.this, StageThree.class);
                            startActivity(i);
                            //cancle to stop timer
                            cancel();

                            //delete chance n go

                            String sql = "delete from mychances";
                            SQLiteDatabase sd = db.getWritableDatabase();

                            sd.execSQL(" delete from mychances ");


                            sd.close();

                            Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();


                            Toast.makeText(getApplicationContext(), "" + length, Toast.LENGTH_SHORT).show();

                            overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);


                        }
                    });


/*

                    final Dialog dialog1 = new Dialog(StageTwo.this);
                    dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog1.setContentView(R.layout.custom_dialog);

//                dialog1.setCancelable(false);
                    // v.startAnimation(anim);

                    Button b2 = (Button) dialog1.findViewById(R.id.stage2_game_over_button);

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(getApplicationContext(),""+"working",Toast.LENGTH_SHORT).show();


                            vibrator.cancel();
                            Intent i = new Intent(StageTwo.this, StageThree.class);
                            startActivity(i);
                            //cancle to stop timer
                            cancel();

                            //delete chance n go

                            String sql = "delete from mychances";
                            SQLiteDatabase sd = db.getWritableDatabase();

                            sd.execSQL(" delete from mychances ");


                            sd.close();

                            Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();


                            Toast.makeText(getApplicationContext(),""+length,Toast.LENGTH_SHORT).show();

                            overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

                        }
                    });

                    dialog1.show();*/

/*
                    AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);

                    adb.setTitle("you won");

                    adb.setMessage("frame completed :)");

                    adb.setCancelable(false);

                    adb.setPositiveButton("next stage", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                          *//*  vibrator.cancel();
                            Intent i = new Intent(StageTwo.this, StageThree.class);
                            startActivity(i);
                            //cancle to stop timer
                            cancel();

                            //delete chance n go

                            String sql = "delete from mychances";
                            SQLiteDatabase sd = db.getWritableDatabase();

                            sd.execSQL(" delete from mychances ");


                            sd.close();

                            Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();


                            Toast.makeText(getApplicationContext(),""+length,Toast.LENGTH_SHORT).show();

                            overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);
*//*
                        }
                    });

                    adb.show();*/

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

                    text2.setText("your time" + "\n   " + yourtime);

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


             public void savescore()
             {
                 SharedPreferences sd = getSharedPreferences("stage2", Context.MODE_PRIVATE);

                 SharedPreferences.Editor ed = sd.edit();

                 ed.putString("stage2score",yourtime);

                 ed.commit();


             }


             public void onFinish()
            {



                //new implementations
                //make visible
                //add anim
                //all actions of alertbox on button


                mTextField.setText(" ");

                stage_two_gameOvr_frame.setVisibility(View.VISIBLE);
                stage_two_gameOvr_frame.startAnimation(anim_winnig_alert_frame);

                gameOverTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


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


                            Intent i = new Intent(StageTwo.this, StageTwo.class);
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


                            //new implementations
                            //make visible
                            //add anim
                            //all actions of alertbox on button
                            //chances.clear();

                            //warning to the palyer of last chance
                            stage_two_last_turn_frame.setVisibility(View.VISIBLE);
                            stage_two_last_turn_frame.startAnimation(anim_winnig_alert_frame);
                            stage_two_last_turn_button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(StageTwo.this, StageTwo.class);
                                    startActivity(i);

                                }
                            });
                            /*AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);
                            adb.setMessage("this will be your last turn to play...");
                            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(StageTwo.this, StageTwo.class);
                                    startActivity(i);

                                }
                            });
                            adb.show();*/


                        }

                        //if chances are three then below action
                        else if(length>2)
                        {
                            //new implementations
                            //make visible
                            //add anim
                            //all actions of alertbox on button


                            stage_two_last_fram.setVisibility(View.VISIBLE);
                            stage_two_last_fram.startAnimation(anim_winnig_alert_frame);
                            stage_two_last_button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {


                                    String sql = "delete from mychances";
                                    SQLiteDatabase sd = db.getWritableDatabase();

                                    sd.execSQL(" delete from mychances ");


                                    sd.close();

                                    Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();


                                    Toast.makeText(getApplicationContext(), "" + length, Toast.LENGTH_SHORT).show();


                                    Intent i = new Intent(StageTwo.this, MainActivity.class);
                                    startActivity(i);

                                }
                            });

                            //then player will be redirectedt to first level
                           /* AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);
                            adb.setMessage("you lost your all turns... play again..");
                            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    String sql = "delete from mychances";
                                    SQLiteDatabase sd = db.getWritableDatabase();

                                    sd.execSQL(" delete from mychances ");


                                    sd.close();

                                    Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();


                                    Toast.makeText(getApplicationContext(), "" + length, Toast.LENGTH_SHORT).show();


                                    Intent i = new Intent(StageTwo.this, MainActivity.class);
                                    startActivity(i);

                                }
                            });
                          //  adb.show();*/
                        }


                    }
                });
                AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);

                adb.setTitle("game over");

                adb.setMessage("time over... :(");

                adb.setCancelable(false);

                adb.setPositiveButton("restart game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

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


                            Intent i = new Intent(StageTwo.this, StageTwo.class);
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


                            //new implementations
                            //make visible
                            //add anim
                            //all actions of alertbox on button
                            //chances.clear();

                            //warning to the palyer of last chance
                           /* stage_two_last_turn_frame.setVisibility(View.VISIBLE);
                            stage_two_last_turn_frame.startAnimation(anim_winnig_alert_frame);
                            stage_two_last_turn_button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(StageTwo.this, StageTwo.class);
                                    startActivity(i);

                                }
                            });*/
/*
                            AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);
                            adb.setMessage("this will be your last turn to play...");
                            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(StageTwo.this, StageTwo.class);
                                    startActivity(i);

                                }
                            });
                            adb.show();
*/


                        }

                        //if chances are three then below action
                        else if(length>2)
                        {
                            //new implementations
                            //make visible
                            //add anim
                            //all actions of alertbox on button




                            //then player will be redirectedt to first level
                            AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);
                            adb.setMessage("you lost your all turns... play again..");
                            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    String sql = "delete from mychances";
                                    SQLiteDatabase sd = db.getWritableDatabase();

                                    sd.execSQL(" delete from mychances ");


                                    sd.close();

                                    Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();


                                    Toast.makeText(getApplicationContext(), "" + length, Toast.LENGTH_SHORT).show();


                                    Intent i = new Intent(StageTwo.this, MainActivity.class);
                                    startActivity(i);

                                }
                            });
                           // adb.show();
                        }

                    }
                });


                //adb.show();

            }
        }.start();
    }

    public void chkifmatch()
    {
        int color1,color2,color3,color4,color5,color6,color7,color8,color9,
                color10,color11,color12,color13;

        //frst
        ColorDrawable viewcolor1 = (ColorDrawable)homframe1.getBackground();

        color1 = viewcolor1.getColor();

        //second
        ColorDrawable viewcolor2 = (ColorDrawable)homframe2.getBackground();

        color2 = viewcolor2.getColor();

        //third
        ColorDrawable viewcolor3 = (ColorDrawable)homframe3.getBackground();

        color3 = viewcolor3.getColor();

        //four
        ColorDrawable viewcolor4 = (ColorDrawable)homframe4.getBackground();

        color4 = viewcolor4.getColor();


        //fifth
        ColorDrawable viewcolor5 = (ColorDrawable)homframe5.getBackground();

        color5 = viewcolor5.getColor();

        //sixth
        ColorDrawable viewcolor6 = (ColorDrawable)homframe6.getBackground();

        color6 = viewcolor6.getColor();


        //seventh
        ColorDrawable viewcolor7 = (ColorDrawable)homframe7.getBackground();

        color7 = viewcolor7.getColor();


        //eighth
        ColorDrawable viewcolor8 = (ColorDrawable)homframe8.getBackground();

        color8 = viewcolor8.getColor();


        //ninth
        ColorDrawable viewcolor9 = (ColorDrawable)homframe9.getBackground();

        color9 = viewcolor9.getColor();


        //tenth
        ColorDrawable viewcolor10 = (ColorDrawable)homframe10.getBackground();

        color10 = viewcolor10.getColor();


        //eleventh
        ColorDrawable viewcolor11 = (ColorDrawable)homframe11.getBackground();

        color11 = viewcolor11.getColor();

        //twelevth
        ColorDrawable viewcolor12 = (ColorDrawable)homframe12.getBackground();

        color12 = viewcolor12.getColor();


        //Thirteen
        ColorDrawable viewcolor13 = (ColorDrawable)homframe13.getBackground();

        color13 = viewcolor13.getColor();







        if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                color1==color6 && color1==color7 && color1==color8 && color1==color9 &&
                color1==color10 && color1==color11 && color1==color12 && color1==color13)

        {

            //new Implementations
            //make layout visibles
            //add animations
            //add all actions of alert box on button click

            alert_winnig_frame.setVisibility(View.VISIBLE);
            alert_winnig_frame.startAnimation(anim_winnig_alert_frame);
            alert_win_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    Toast.makeText(getApplicationContext(), "" + "working", Toast.LENGTH_SHORT).show();


                    stagetwo_thread_anim.cancel();
                    stagetwo_timeplate_anim.cancel();

                    vibrator.cancel();
                    stagetwo_thred.startAnimation(cycle_bounce);
                    stagetwo_timeplate.startAnimation(cycle_bounce);

                    stagetwo_thred.setVisibility(View.INVISIBLE);
                    stagetwo_timeplate.setVisibility(View.INVISIBLE);
                    vibrator.cancel();

                    your_time_layout.setVisibility(View.VISIBLE);
                    your_time_layout.startAnimation(yourtime_anim);


                    vibrator.cancel();
                    Intent i = new Intent(StageTwo.this, StageThree.class);
                    startActivity(i);

                    //cancle to stop timer
                    Count.cancel();

                    //delete chance n go


                    String sql = "delete from mychances";
                    SQLiteDatabase sd = db.getWritableDatabase();

                    sd.execSQL(" delete from mychances ");


                    sd.close();

                    Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();


                    Toast.makeText(getApplicationContext(), "" + length, Toast.LENGTH_SHORT).show();
                    overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);


                }
            });


/*
            final Dialog dialog1 = new Dialog(StageTwo.this);
            dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog1.setContentView(R.layout.custom_dialog);

//                dialog1.setCancelable(false);
            // v.startAnimation(anim);

            Button b2 = (Button) dialog1.findViewById(R.id.stage2_game_over_button);

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "" + "working", Toast.LENGTH_SHORT).show();


                    stagetwo_thread_anim.cancel();
                    stagetwo_timeplate_anim.cancel();

                    vibrator.cancel();
                    stagetwo_thred.startAnimation(cycle_bounce);
                    stagetwo_timeplate.startAnimation(cycle_bounce);

                    stagetwo_thred.setVisibility(View.INVISIBLE);
                    stagetwo_timeplate.setVisibility(View.INVISIBLE);
                    vibrator.cancel();

                    your_time_layout.setVisibility(View.VISIBLE);
                    your_time_layout.startAnimation(yourtime_anim);


                    vibrator.cancel();
                    Intent i = new Intent(StageTwo.this, StageThree.class);
                    startActivity(i);

                    //cancle to stop timer
                    Count.cancel();

                    //delete chance n go


                    String sql = "delete from mychances";
                    SQLiteDatabase sd = db.getWritableDatabase();

                    sd.execSQL(" delete from mychances ");


                    sd.close();

                    Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();


                    Toast.makeText(getApplicationContext(), "" + length, Toast.LENGTH_SHORT).show();
                    overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

                }
            });
*/



            /*AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);

            adb.setTitle("you won");

            adb.setMessage("frame completed :)");

           // adb.show();

            adb.setCancelable(false);

            adb.setPositiveButton("next stage", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    *//*stagetwo_thread_anim.cancel();
                    stagetwo_timeplate_anim.cancel();

                    vibrator.cancel();
                    stagetwo_thred.startAnimation(cycle_bounce);
                    stagetwo_timeplate.startAnimation(cycle_bounce);

                    stagetwo_thred.setVisibility(View.INVISIBLE);
                    stagetwo_timeplate.setVisibility(View.INVISIBLE);
                    vibrator.cancel();

                    your_time_layout.setVisibility(View.VISIBLE);
                    your_time_layout.startAnimation(yourtime_anim);


                    vibrator.cancel();
                    Intent i = new Intent(StageTwo.this, StageThree.class);
                    startActivity(i);

                    //cancle to stop timer
                    Count.cancel();

                    //delete chance n go


                    String sql = "delete from mychances";
                    SQLiteDatabase sd = db.getWritableDatabase();

                    sd.execSQL(" delete from mychances ");


                    sd.close();

                    Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();


                    Toast.makeText(getApplicationContext(),""+length,Toast.LENGTH_SHORT).show();
                    overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);
*//*
                }
            });*/






        }

        else
        {


            Toast.makeText(getApplicationContext(),"not done yet",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();



        final AlertDialog.Builder adb = new AlertDialog.Builder(StageTwo.this);
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

                vibrator.cancel();

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
