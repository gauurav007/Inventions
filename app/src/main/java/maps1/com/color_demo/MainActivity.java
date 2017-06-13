package maps1.com.color_demo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    CardView card1,card2,card3,card4,card5,card6,card7,card8,
            card9,card10,card11,card12,card13,card14,card15,card16;

    TextView nextStage1,nextStage2;

    LinearLayout handle1,handle2,banner;
    LinearLayout red;
    LinearLayout orange;
    LinearLayout purple;
    LinearLayout blue;
    LinearLayout lightgreen;
    LinearLayout yellow;
    LinearLayout darkbrown;
    LinearLayout mehndigreen;
    LinearLayout violet;

    LinearLayout newcolor33;
    LinearLayout newcolor66;
    LinearLayout newcolor99;
    LinearLayout newcolor10;
    LinearLayout newcolor11;
    LinearLayout newcolor12;
    LinearLayout newcolor13;

    LinearLayout time,thread,yourtme_layout,restart_layout;
    Animation anim_time,anim_thread,yourtime_anim,bounce_translate,anim_bounce;

//added for video view purpose
    VideoView vv;
    //private MediaController mc;
//    Button b1;

    TextView mTextField,text2;
    Toolbar toolbar;
    View v;

    View view_for_alert,win_view;

    CountDownTimer Count;


    Button nextstage;
    Vibrator vibrator;
    String myredframe,myredColor,myorangeframe,myorangecolor;
    String yourtime;


    ///String name,color;
    //Button b1;
    int length;
    static int count =0;
    static int count1 =0;

    //ArrayList<String> demolist = new ArrayList<String>();
    //Vector<String>  demolist  = new Vector<String>();
    LinkedList<String> demolist = new LinkedList<String>();
    LinkedList<String> name = new LinkedList<String>();
    LinkedList<String> color = new LinkedList<String>();

    ArrayList<String> chances = new ArrayList<>();
    MyChances db;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_three_layout);


          handle1 = (LinearLayout)findViewById(R.id.handle1);
          handle2 = (LinearLayout)findViewById(R.id.handle2);
          banner = (LinearLayout)findViewById(R.id.banner);
          handle1.setVisibility(View.INVISIBLE);
          handle2.setVisibility(View.INVISIBLE);
          banner.setVisibility(View.INVISIBLE);

          nextStage1 = (TextView)findViewById(R.id.next);
          nextStage2 = (TextView)findViewById(R.id.stage);

          card1 = (CardView)findViewById(R.id.card1);
          card2 = (CardView)findViewById(R.id.card2);
          card3 = (CardView)findViewById(R.id.card3);
          card4 = (CardView)findViewById(R.id.card4);
          card5 = (CardView)findViewById(R.id.card5);
          card6 = (CardView)findViewById(R.id.card6);
          card7 = (CardView)findViewById(R.id.card7);
          card8 = (CardView)findViewById(R.id.card8);
          card9 = (CardView)findViewById(R.id.card9);
          card10 = (CardView)findViewById(R.id.card10);
          card11 = (CardView)findViewById(R.id.card11);
          card12 = (CardView)findViewById(R.id.card12);
          card13 = (CardView)findViewById(R.id.card13);
          card14 = (CardView)findViewById(R.id.card14);
          card15 = (CardView)findViewById(R.id.card15);
          card16 = (CardView)findViewById(R.id.card16);
 //         FrameLayout fm = (FrameLayout)findViewById(R.id.video_lay);


 //added for playing videos at the background
          vv = (VideoView)findViewById(R.id.videoview);
          vv.setVisibility(View.INVISIBLE);
         vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tiggger));

   /*     *//**//*  DisplayMetrics metrics = new DisplayMetrics(); getWindowManager().getDefaultDisplay().getMetrics(metrics);
          android.widget.FrameLayout.LayoutParams params = (android.widget.FrameLayout.LayoutParams) vv.getLayoutParams();
          params.width =  metrics.widthPixels;
          params.height = metrics.heightPixels;
          params.leftMargin = 0;
        *//**//* // vv.setLayoutParams(params);
*/
          //mc = new MediaController(MainActivity.this);

       
          vv.requestFocus();


//          vv.start();





          // mc = new MediaController(MainActivity.this);
          //vv.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=Wd2B8OAotU8"));
          //mc =  new MediaController(MainActivity.this);

          /*mc=  new MediaController(MainActivity.this);

          vv.setMediaController(mc);

          vv.requestFocus();


          vv.start();
*/
   //       vv.start();

  //       b1 = (Button)findViewById(R.id.myybutton);

         //animation

/*
         LayoutInflater inflater = (LayoutInflater) this
                 .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

         view_for_alert = inflater.inflate(R.layout.alert_background,null);

         win_view = inflater.inflate(R.layout.alert_win_background,null);
*/


          nextStage1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  Toast.makeText(getApplicationContext(),"next stage here",Toast.LENGTH_SHORT).show();
              }
          });


          nextStage2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  Toast.makeText(getApplicationContext(),"next stage here",Toast.LENGTH_SHORT).show();
              }
          });
         nextstage = (Button)findViewById(R.id.button_stage_one);

         restart_layout = (LinearLayout)findViewById(R.id.layoutsatge_one_id);

         restart_layout.setVisibility(View.INVISIBLE);

         thread = (LinearLayout)findViewById(R.id.thread);
         time = (LinearLayout)findViewById(R.id.timeplate);

         yourtme_layout = (LinearLayout)findViewById(R.id.yourtime_layout);

         yourtme_layout.setVisibility(View.INVISIBLE);

         anim_bounce = AnimationUtils.loadAnimation(this,R.anim.bounce_scale);

         anim_thread = AnimationUtils.loadAnimation(this,R.anim.pendulum);
         anim_time = AnimationUtils.loadAnimation(this,R.anim.pendulum);

         yourtime_anim = AnimationUtils.loadAnimation(this,R.anim.bounce);

         bounce_translate=AnimationUtils.loadAnimation(this,R.anim.bounce_trans);

         thread.startAnimation(anim_thread);
         time.startAnimation(anim_time);

         db = new MyChances(this);
         vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

       //  toolbar = (Toolbar)findViewById(R.id.tools);

       //  mTextField = (TextView)toolbar.findViewById(R.id.textView);
         mTextField = (TextView)findViewById(R.id.textView);

//         setSupportActionBar(toolbar);

         //text2 = (TextView)toolbar.findViewById(R.id.textView2);
         text2 = (TextView)findViewById(R.id.textView2);

         text2.setVisibility(View.INVISIBLE);

        red = (LinearLayout)findViewById(R.id.frame1);
        orange = (LinearLayout)findViewById(R.id.frame2);

         purple = (LinearLayout)findViewById(R.id.frame3);
         blue = (LinearLayout)findViewById(R.id.frame4);

         lightgreen = (LinearLayout)findViewById(R.id.frame5);

         yellow = (LinearLayout)findViewById(R.id.frame6);

         darkbrown = (LinearLayout)findViewById(R.id.frame7);

         mehndigreen = (LinearLayout)findViewById(R.id.frame8);

         violet = (LinearLayout)findViewById(R.id.frame9);

         newcolor33 = (LinearLayout)findViewById(R.id.frame33);

         newcolor66 = (LinearLayout)findViewById(R.id.frame66);

         newcolor99 = (LinearLayout)findViewById(R.id.frame99);

         newcolor10 = (LinearLayout)findViewById(R.id.frame10);

         newcolor11 = (LinearLayout)findViewById(R.id.frame11);

         newcolor12 = (LinearLayout)findViewById(R.id.frame12);

         newcolor13 = (LinearLayout)findViewById(R.id.frame13);

         nextstage.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent i = new Intent(MainActivity.this,MainActivity.class);
                 startActivity(i);

             }
         });

         startTimer();

    /*     b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent i = new Intent(MainActivity.this,StageFour.class);
                 startActivity(i);
             }
         });
*/

         red.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                 red.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) red.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 String myname = "red";
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

         red.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 red.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) red.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "red";
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

                     red.setBackgroundColor(currcolor);

                     if (currname.equals("orange")) {
                         //orange.setBackgroundColor(Color.parseColor(mycolor));

                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("red")) {
                         red.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     //}
                     chkifmatch();

                 }


                 return true;


             }


         });


         orange.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 orange.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) orange.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "orange";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         orange.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {

                 orange.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) orange.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "orange";
                 String mycolor = String.valueOf(colors);

              /*   if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 // else {

                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please frst perform d single click and then the long on other color", Toast.LENGTH_LONG).show();
                 } else {

                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     orange.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     //}

                     chkifmatch();


                 }



                 /*String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 orange.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 }
                 else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }


                 //}

                 chkifmatch();
*/
                 return true;
             }
         });


         purple.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 purple.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) purple.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "purple";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         purple.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v)
             {

                 purple.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) purple.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "purple";
                 String mycolor = String.valueOf(colors);

              /*   if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 // else {


                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please perform a single click frst then a long click on other color u wnt", Toast.LENGTH_LONG).show();
                 } else {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     purple.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     chkifmatch();

                 }


                 /*String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 purple.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 }
                 else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }


                 chkifmatch();
*/
                 return true;
             }
         });


         blue.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 blue.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) blue.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "blue";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         blue.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {

                 blue.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) blue.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "blue";
                 String mycolor = String.valueOf(colors);

              /*   if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 // else {


                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please perform a single click frst then a long click on other color u wnt", Toast.LENGTH_LONG).show();
                 } else {

                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     blue.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }

                     chkifmatch();


                 }


                 /*String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 blue.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 }
                 else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }

                 chkifmatch();
*/
                 return true;
             }
         });

         lightgreen.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 lightgreen.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) lightgreen.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "lightgreen";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });


         lightgreen.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v)
             {
                 lightgreen.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) lightgreen.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "lightgreen";
                 String mycolor = String.valueOf(colors);

                /* if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 // else {


                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please perform a single click frst then a long click on other color u wnt", Toast.LENGTH_LONG).show();
                 } else {

                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     lightgreen.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }

                     chkifmatch();


                 }


                 /*String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 lightgreen.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 } else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }

                 chkifmatch();
*/
                 return true;
             }
         });


         yellow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 yellow.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) yellow.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "yellow";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         yellow.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 yellow.startAnimation(anim_bounce);
                 ColorDrawable viewcolor = (ColorDrawable) yellow.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "yellow";
                 String mycolor = String.valueOf(colors);

              /*  if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }
*/
                 // else {

                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please perform a single click frst then a long click on other color u wnt", Toast.LENGTH_LONG).show();
                 } else {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     yellow.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }

                     chkifmatch();


                 }


                 /*String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 yellow.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 } else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }

                 chkifmatch();
*/
                 return true;
             }
         });


         darkbrown.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {



                 darkbrown.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) darkbrown.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "darkbrown";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         darkbrown.setOnLongClickListener(
                 new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 darkbrown.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) darkbrown.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "darkbrown";
                 String mycolor = String.valueOf(colors);

               /* if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 // else {

                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please perform a single click frst then a long click on other color u wnt", Toast.LENGTH_LONG).show();
                 } else {

                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     darkbrown.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }

                     chkifmatch();


                 }



                     /*String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 darkbrown.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 } else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }

                 chkifmatch();
*/
                 return true;
             }
         });

         mehndigreen.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 mehndigreen.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) mehndigreen.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "mehndigreen";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         mehndigreen.setOnLongClickListener(
                 new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {

                 mehndigreen.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) mehndigreen.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "mehndigreen";
                 String mycolor = String.valueOf(colors);

                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 // else {


                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please perform a single click frst then a long click on other color u wnt", Toast.LENGTH_LONG).show();
                 } else {

                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     mehndigreen.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }
                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     chkifmatch();


                 }

    /*                 String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 mehndigreen.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 } else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }


                 chkifmatch();

    */
                 return true;
             }
         });

         violet.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 violet.startAnimation(anim_bounce);


                 ColorDrawable viewcolor = (ColorDrawable) violet.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "violet";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         violet.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 violet.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) violet.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "violet";
                 String mycolor = String.valueOf(colors);

              /*   if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }
*/
                 // else {

                 if (name.isEmpty() || color.isEmpty()) {
                     Toast.makeText(getApplicationContext(), "please perform a single click frst then a long click on other color u wnt", Toast.LENGTH_LONG).show();
                 } else {

                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     violet.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }
                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }

                     chkifmatch();


                 }



                     /*String currname;//,currcolor;

                 currname = name.getLast();

                 int currcolor = Integer.valueOf(color.getLast());


                 //orange.setBackgroundColor(Color.parseColor(currcolor));

                 violet.setBackgroundColor(currcolor);

                 if (currname.equals("red")) {
                     // red.setBackgroundColor(Color.parseColor(mycolor));

                     red.setBackgroundColor(colors);
                 } else if (currname.equals("orange")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     orange.setBackgroundColor(colors);
                 } else if (currname.equals("purple")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     purple.setBackgroundColor(colors);
                 } else if (currname.equals("blue")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     blue.setBackgroundColor(colors);
                 } else if (currname.equals("lightgreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     lightgreen.setBackgroundColor(colors);
                 } else if (currname.equals("yellow")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     yellow.setBackgroundColor(colors);
                 } else if (currname.equals("darkbrown")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     darkbrown.setBackgroundColor(colors);
                 } else if (currname.equals("mehndigreen")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     mehndigreen.setBackgroundColor(colors);
                 } else if (currname.equals("violet")) {
                     // orange.setBackgroundColor(Color.parseColor(mycolor));
                     violet.setBackgroundColor(colors);
                 }

                 chkifmatch();
*/
                 return true;
             }
         });



         newcolor33.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {



                 newcolor33.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor33.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 String myname = "newcolor33";
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

         newcolor33.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 newcolor33.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor33.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "newcolor33";
                 String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 //else
                 //{
                 if(name.isEmpty() || color.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(),"please frst perform d single click and then the long on other color",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                     //red.setBackgroundColor(Color.parseColor(currcolor));

                     newcolor33.setBackgroundColor(currcolor);

                     if (currname.equals("orange")) {
                         //orange.setBackgroundColor(Color.parseColor(mycolor));

                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("red")) {
                         red.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     }
                     else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     //}
                     chkifmatch();

                 }


                 return true;


             }


         });


         newcolor66.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {



                 newcolor66.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor66.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 //red.setBackgroundColor(colors);


                 String myname = "newcolor66";
                 String mycolor = String.valueOf(colors);

                 name.add(myname);
                 color.add(mycolor);

                 Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();

                 chkifmatch();
             }
         });

         newcolor66.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v)
             {


                 newcolor66.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable)newcolor66.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "newcolor66";
                 String mycolor = String.valueOf(colors);

              /*   if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }
*/
                 // else {

                 if(name.isEmpty() || color.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(),"please perform a single click frst then a long click on other color u wnt",Toast.LENGTH_LONG).show();
                 }
                 else
                 {

                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());


                     //orange.setBackgroundColor(Color.parseColor(currcolor));

                     newcolor66.setBackgroundColor(currcolor);

                     if (currname.equals("red")) {
                         // red.setBackgroundColor(Color.parseColor(mycolor));

                         red.setBackgroundColor(colors);
                     } else if (currname.equals("orange")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     } else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }
                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }

                     chkifmatch();


                 }



                   return true;
             }
         });


         newcolor99.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 newcolor99.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor99.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 String myname = "newcolor99";
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

         newcolor99.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 newcolor99.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor99.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "newcolor99";
                 String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 //else
                 //{
                 if(name.isEmpty() || color.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(),"please frst perform d single click and then the long on other color",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                     //red.setBackgroundColor(Color.parseColor(currcolor));

                     newcolor99.setBackgroundColor(currcolor);

                     if (currname.equals("orange")) {
                         //orange.setBackgroundColor(Color.parseColor(mycolor));

                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("red")) {
                         red.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     }
                     else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     //}
                     chkifmatch();

                 }


                 return true;


             }


         });



         newcolor10.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 newcolor10.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor10.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 String myname = "newcolor10";
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

         newcolor10.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {

                 newcolor10.startAnimation(anim_bounce);


                 ColorDrawable viewcolor = (ColorDrawable) newcolor10.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "newcolor10";
                 String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 //else
                 //{
                 if(name.isEmpty() || color.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(),"please frst perform d single click and then the long on other color",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                     //red.setBackgroundColor(Color.parseColor(currcolor));

                     newcolor10.setBackgroundColor(currcolor);

                     if (currname.equals("orange")) {
                         //orange.setBackgroundColor(Color.parseColor(mycolor));

                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("red")) {
                         red.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     }
                     else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     //}
                     chkifmatch();

                 }


                 return true;


             }


         });


         newcolor11.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 newcolor11.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor11.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 String myname = "newcolor11";
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

         newcolor11.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {



                 newcolor11.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor11.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "newcolor11";
                 String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 //else
                 //{
                 if(name.isEmpty() || color.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(),"please frst perform d single click and then the long on other color",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                     //red.setBackgroundColor(Color.parseColor(currcolor));

                     newcolor11.setBackgroundColor(currcolor);

                     if (currname.equals("orange")) {
                         //orange.setBackgroundColor(Color.parseColor(mycolor));

                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("red")) {
                         red.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     }
                     else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     //}
                     chkifmatch();

                 }


                 return true;


             }


         });


         newcolor12.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 newcolor12.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor12.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 String myname = "newcolor12";
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

         newcolor12.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 newcolor12.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor12.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "newcolor12";
                 String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 //else
                 //{
                 if(name.isEmpty() || color.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(),"please frst perform d single click and then the long on other color",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                     //red.setBackgroundColor(Color.parseColor(currcolor));

                     newcolor12.setBackgroundColor(currcolor);

                     if (currname.equals("orange")) {
                         //orange.setBackgroundColor(Color.parseColor(mycolor));

                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("red")) {
                         red.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     }
                     else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
                     }


                     //}
                     chkifmatch();

                 }


                 return true;


             }


         });



         newcolor13.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 newcolor13.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor13.getBackground();

                 int colors = viewcolor.getColor();

                 Toast.makeText(getApplicationContext(), "" + colors, Toast.LENGTH_LONG).show();

                 String myname = "newcolor13";
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

         newcolor13.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {


                 newcolor13.startAnimation(anim_bounce);

                 ColorDrawable viewcolor = (ColorDrawable) newcolor13.getBackground();

                 int colors = viewcolor.getColor();

                 String myname = "newcolor13";
                 String mycolor = String.valueOf(colors);



                 /*if(name.getLast().equals(myname))
                 {
                     Toast.makeText(getApplicationContext(),"please long click on another slode u wnt to replace not same",Toast.LENGTH_LONG).show();
                 }*/

                 //else
                 //{
                 if(name.isEmpty() || color.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(),"please frst perform d single click and then the long on other color",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     String currname;//,currcolor;

                     currname = name.getLast();

                     int currcolor = Integer.valueOf(color.getLast());//color.getLast();


                     //red.setBackgroundColor(Color.parseColor(currcolor));

                     newcolor13.setBackgroundColor(currcolor);

                     if (currname.equals("orange")) {
                         //orange.setBackgroundColor(Color.parseColor(mycolor));

                         orange.setBackgroundColor(colors);
                     } else if (currname.equals("red")) {
                         red.setBackgroundColor(colors);
                     } else if (currname.equals("purple")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         purple.setBackgroundColor(colors);
                     } else if (currname.equals("blue")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         blue.setBackgroundColor(colors);
                     }
                     else if (currname.equals("lightgreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         lightgreen.setBackgroundColor(colors);
                     } else if (currname.equals("yellow")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         yellow.setBackgroundColor(colors);
                     } else if (currname.equals("darkbrown")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         darkbrown.setBackgroundColor(colors);
                     } else if (currname.equals("mehndigreen")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         mehndigreen.setBackgroundColor(colors);
                     } else if (currname.equals("violet")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         violet.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor33")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor33.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor66")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor66.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor99")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor99.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor10")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor10.setBackgroundColor(colors);
                     }

                     else if (currname.equals("newcolor11")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor11.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor12")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor12.setBackgroundColor(colors);
                     } else if (currname.equals("newcolor13")) {
                         // orange.setBackgroundColor(Color.parseColor(mycolor));
                         newcolor13.setBackgroundColor(colors);
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


         Count =  new CountDownTimer(50000, 1000)
        {

            public void onTick(long millisUntilFinished)
            {
               // chkifmatch();


                int color1,color2,color3,color4,color5,color6,color7,color8,color9,
                        color10,color11,color12,color13,color14,color15,color16;

                //frst
                ColorDrawable viewcolor1 = (ColorDrawable)red.getBackground();

                color1 = viewcolor1.getColor();

                //second
                ColorDrawable viewcolor2 = (ColorDrawable)orange.getBackground();

                color2 = viewcolor2.getColor();

                //third
                ColorDrawable viewcolor3 = (ColorDrawable)purple.getBackground();

                color3 = viewcolor3.getColor();

                //four
                ColorDrawable viewcolor4 = (ColorDrawable)blue.getBackground();

                color4 = viewcolor4.getColor();


                //fifth
                ColorDrawable viewcolor5 = (ColorDrawable)lightgreen.getBackground();

                color5 = viewcolor5.getColor();

                //sixth
                ColorDrawable viewcolor6 = (ColorDrawable)yellow.getBackground();

                color6 = viewcolor6.getColor();


                //seventh
                ColorDrawable viewcolor7 = (ColorDrawable)darkbrown.getBackground();

                color7 = viewcolor7.getColor();


                //eighth
                ColorDrawable viewcolor8 = (ColorDrawable)mehndigreen.getBackground();

                color8 = viewcolor8.getColor();


                //ninth
                ColorDrawable viewcolor9 = (ColorDrawable)violet.getBackground();

                color9 = viewcolor9.getColor();



                //tenth
                ColorDrawable viewcolor10 = (ColorDrawable)newcolor33.getBackground();

                color10 = viewcolor10.getColor();


                //eleventh
                ColorDrawable viewcolor11 = (ColorDrawable)newcolor66.getBackground();

                color11 = viewcolor11.getColor();

                //twelevth
                ColorDrawable viewcolor12 = (ColorDrawable)newcolor99.getBackground();

                color12 = viewcolor12.getColor();


                //Thirteen
                ColorDrawable viewcolor13 = (ColorDrawable)newcolor10.getBackground();

                color13 = viewcolor13.getColor();


                //Fourteen
                ColorDrawable viewcolor14 = (ColorDrawable)newcolor11.getBackground();

                color14 = viewcolor14.getColor();


                //Fifteen
                ColorDrawable viewcolor15 = (ColorDrawable)newcolor12.getBackground();

                color15 = viewcolor15.getColor();

                //Sixteen
                ColorDrawable viewcolor16 = (ColorDrawable)newcolor13.getBackground();

                color16 = viewcolor16.getColor();

                if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                        color1==color6 && color1==color7 && color1==color8 && color1==color9 &&
                        color1==color10 && color1==color11 && color1==color12 && color1==color13 &&
                        color1==color14 && color1==color15 && color1==color16)
                {


                    anim_thread.cancel();
                    anim_time.cancel();
           /* time.setVisibility(View.INVISIBLE);
            thread.setVisibility(View.INVISIBLE);
          */  vibrator.cancel();
                    vv.setVisibility(View.VISIBLE);
                    vv.start();

                    red.setVisibility(View.INVISIBLE);
                    orange.setVisibility(View.VISIBLE);
                    purple.setVisibility(View.INVISIBLE);
                    blue.setVisibility(View.INVISIBLE);
                    lightgreen.setVisibility(View.INVISIBLE);
                    yellow.setVisibility(View.INVISIBLE);
                    darkbrown.setVisibility(View.INVISIBLE);
                    violet.setVisibility(View.INVISIBLE);
                    mehndigreen.setVisibility(View.INVISIBLE);
                    newcolor10.setVisibility(View.INVISIBLE);
                    newcolor11.setVisibility(View.INVISIBLE);
                    newcolor12.setVisibility(View.INVISIBLE);
                    newcolor13.setVisibility(View.INVISIBLE);
                    newcolor33.setVisibility(View.INVISIBLE);
                    newcolor66.setVisibility(View.INVISIBLE);
                    newcolor99.setVisibility(View.INVISIBLE);


                    card1.setVisibility(View.INVISIBLE);
                    card2.setVisibility(View.INVISIBLE);
                    card3.setVisibility(View.INVISIBLE);
                    card4.setVisibility(View.INVISIBLE);
                    card5.setVisibility(View.INVISIBLE);
                    card6.setVisibility(View.INVISIBLE);
                    card7.setVisibility(View.INVISIBLE);
                    card8.setVisibility(View.INVISIBLE);
                    card9.setVisibility(View.INVISIBLE);
                    card10.setVisibility(View.INVISIBLE);
                    card11.setVisibility(View.INVISIBLE);
                    card12.setVisibility(View.INVISIBLE);
                    card13.setVisibility(View.INVISIBLE);
                    card14.setVisibility(View.INVISIBLE);
                    card15.setVisibility(View.INVISIBLE);
                    card16.setVisibility(View.INVISIBLE);

                    //making handle and banner visible and applying animation on them
                /*    handle1.setVisibility(View.VISIBLE);
                    handle2.setVisibility(View.VISIBLE);
                    banner.setVisibility(View.VISIBLE);
                    handle1.startAnimation(anim_thread);
                    handle2.startAnimation(anim_thread);
                    banner.startAnimation(anim_thread);

                */    time.startAnimation(bounce_translate);
                    thread.startAnimation(bounce_translate);


                    time.setVisibility(View.INVISIBLE);
                    thread.setVisibility(View.INVISIBLE);

                    yourtme_layout.setVisibility(View.VISIBLE);
                    yourtme_layout.startAnimation(yourtime_anim);


                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);

  //                  adb.setView(win_view);

                    adb.setTitle("you won");

                    adb.setMessage("frame completed :)");

                    adb.setCancelable(false);

                    adb.setPositiveButton("next stage", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent i = new Intent(MainActivity.this, StageTwo.class);
                            startActivity(i);
                            vibrator.cancel();

                            overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

                        }
                    });

                    //made invisible for video view purpose
                    adb.show();

                //    mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);

                    long no = millisUntilFinished/1000;

                    String finalcount = String.valueOf(no);
                    text2.setText(finalcount);

                 //   onFinish();

         //               cancel();

                            cancel();

                    mTextField.setVisibility(View.INVISIBLE);


                    String finaltime = text2.getText().toString();

                    Toast.makeText(getApplicationContext(),finaltime,Toast.LENGTH_LONG).show();

                    int completedtime = Integer.valueOf(finaltime);

                    int framecompletedtime = 50 - completedtime;

                     yourtime = String.valueOf(framecompletedtime);


                    text2.setVisibility(View.VISIBLE);
                    //PUT THIS TIME ON YOUR ANIMATED FRAME
                    text2.setText("your time" + "\n   " + yourtime);



                    savescore();

                        vibrator.cancel();


                            }

                else
                {


                    Toast.makeText(getApplicationContext(),"not done yet",Toast.LENGTH_SHORT).show();
                }


/*
                seconds
                "+"remaining "+"
*/

                mTextField.setText(""+millisUntilFinished / 1000);

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


                restart_layout.setVisibility(View.VISIBLE);
                restart_layout.startAnimation(anim_bounce);
/*
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);

//                adb.setView(view_for_alert);

                adb.setTitle("game over");

                adb.setMessage("time over... :(");

                adb.setCancelable(false);

                adb.setPositiveButton("restart game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //check cahnces by reading from databases

                        Intent i = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(i);




                    }
                });


                adb.show();
*/

            }
        }.start();
    }

    public void savescore()
    {
        SharedPreferences sd = getSharedPreferences("stage1", Context.MODE_PRIVATE);

        SharedPreferences.Editor ed = sd.edit();

        ed.putString("stage1score",yourtime);

        ed.commit();


    }

    public void chkifmatch()
    {

        Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();

        int color1,color2,color3,color4,color5,color6,color7,color8,color9,
                color10,color11,color12,color13,color14,color15,color16;

        //frst
        ColorDrawable viewcolor1 = (ColorDrawable)red.getBackground();

        color1 = viewcolor1.getColor();

        //second
        ColorDrawable viewcolor2 = (ColorDrawable)orange.getBackground();

        color2 = viewcolor2.getColor();

        //third
        ColorDrawable viewcolor3 = (ColorDrawable)purple.getBackground();

        color3 = viewcolor3.getColor();

        //four
        ColorDrawable viewcolor4 = (ColorDrawable)blue.getBackground();

        color4 = viewcolor4.getColor();


        //fifth
        ColorDrawable viewcolor5 = (ColorDrawable)lightgreen.getBackground();

        color5 = viewcolor5.getColor();

        //sixth
        ColorDrawable viewcolor6 = (ColorDrawable)yellow.getBackground();

        color6 = viewcolor6.getColor();


        //seventh
        ColorDrawable viewcolor7 = (ColorDrawable)darkbrown.getBackground();

        color7 = viewcolor7.getColor();


        //eighth
        ColorDrawable viewcolor8 = (ColorDrawable)mehndigreen.getBackground();

        color8 = viewcolor8.getColor();


        //ninth
        ColorDrawable viewcolor9 = (ColorDrawable)violet.getBackground();

        color9 = viewcolor9.getColor();


        //tenth
        ColorDrawable viewcolor10 = (ColorDrawable)newcolor33.getBackground();

        color10 = viewcolor10.getColor();


        //eleventh
        ColorDrawable viewcolor11 = (ColorDrawable)newcolor66.getBackground();

        color11 = viewcolor11.getColor();

        //twelevth
        ColorDrawable viewcolor12 = (ColorDrawable)newcolor99.getBackground();

        color12 = viewcolor12.getColor();


        //Thirteen
        ColorDrawable viewcolor13 = (ColorDrawable)newcolor10.getBackground();

        color13 = viewcolor13.getColor();


        //Fourteen
        ColorDrawable viewcolor14 = (ColorDrawable)newcolor11.getBackground();

        color14 = viewcolor14.getColor();


        //Fifteen
        ColorDrawable viewcolor15 = (ColorDrawable)newcolor12.getBackground();

        color15 = viewcolor15.getColor();

        //Sixteen
        ColorDrawable viewcolor16 = (ColorDrawable)newcolor13.getBackground();

        color16 = viewcolor16.getColor();






        if(color1==color2 && color1==color3 && color1==color4 && color1==color5 &&
                color1==color6 && color1==color7 && color1==color8 && color1==color9 &&
        color1==color10 && color1==color11 && color1==color12 && color1==color13 &&
                color1==color14 && color1==color15 && color1==color16)
        {

            anim_thread.cancel();
            anim_time.cancel();
           /* time.setVisibility(View.INVISIBLE);
            thread.setVisibility(View.INVISIBLE);
          */  vibrator.cancel();

/*
            time.startAnimation(bounce_translate);
            thread.startAnimation(bounce_translate);
*/
            vv.setVisibility(View.VISIBLE);
            vv.start();
            red.setVisibility(View.INVISIBLE);
            orange.setVisibility(View.VISIBLE);
            purple.setVisibility(View.INVISIBLE);
            blue.setVisibility(View.INVISIBLE);
            lightgreen.setVisibility(View.INVISIBLE);
            yellow.setVisibility(View.INVISIBLE);
            darkbrown.setVisibility(View.INVISIBLE);
            violet.setVisibility(View.INVISIBLE);
            mehndigreen.setVisibility(View.INVISIBLE);
            newcolor10.setVisibility(View.INVISIBLE);
            newcolor11.setVisibility(View.INVISIBLE);
            newcolor12.setVisibility(View.INVISIBLE);
            newcolor13.setVisibility(View.INVISIBLE);
            newcolor33.setVisibility(View.INVISIBLE);
            newcolor66.setVisibility(View.INVISIBLE);
            newcolor99.setVisibility(View.INVISIBLE);

            card1.setVisibility(View.INVISIBLE);
            card2.setVisibility(View.INVISIBLE);
            card3.setVisibility(View.INVISIBLE);
            card4.setVisibility(View.INVISIBLE);
            card5.setVisibility(View.INVISIBLE);
            card6.setVisibility(View.INVISIBLE);
            card7.setVisibility(View.INVISIBLE);
            card8.setVisibility(View.INVISIBLE);
            card9.setVisibility(View.INVISIBLE);
            card10.setVisibility(View.INVISIBLE);
            card11.setVisibility(View.INVISIBLE);
            card12.setVisibility(View.INVISIBLE);
            card13.setVisibility(View.INVISIBLE);
            card14.setVisibility(View.INVISIBLE);
            card15.setVisibility(View.INVISIBLE);
            card16.setVisibility(View.INVISIBLE);

            //making handle and banner visible and applying animation on them
 /*           handle1.setVisibility(View.VISIBLE);
            handle2.setVisibility(View.VISIBLE);
            banner.setVisibility(View.VISIBLE);
            handle1.startAnimation(anim_thread);
            handle2.startAnimation(anim_thread);
            banner.startAnimation(anim_thread);

*/
            time.setVisibility(View.INVISIBLE);
            thread.setVisibility(View.INVISIBLE);

           yourtme_layout.setVisibility(View.VISIBLE);
            yourtme_layout.startAnimation(yourtime_anim);
            AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);

//            adb.setView(win_view);

            adb.setTitle("you won");

            adb.setMessage("frame completed :)");
////made it invisble to chk the video concept
            adb.show();

            adb.setCancelable(false);

            adb.setPositiveButton("next stage", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    vibrator.cancel();
                    Intent i = new Intent(MainActivity.this, StageTwo.class);
                    startActivity(i);
                    Count.cancel();


                    overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

                }
            });




        }

        else
        {


            Toast.makeText(getApplicationContext(),"not done yet",Toast.LENGTH_SHORT).show();
/*
            import android.os.Vibrator;
            ...
            Vibrator v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            v.vibrate(500);*/
        }

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        final AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
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
