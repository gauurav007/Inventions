package maps1.com.color_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

/**
 * Created by home on 21/04/2017.
 */

public class ChkAnim extends AppCompatActivity
{
    Animation anim;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chkanim);

        frameLayout = (FrameLayout)findViewById(R.id.chkanimframe);

        anim = AnimationUtils.loadAnimation(this,R.anim.cycle_transss);

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frameLayout.startAnimation(anim);
            }
        });

        frameLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {
                frameLayout.startAnimation(anim);

                return true;
            }
        });

    }
}
