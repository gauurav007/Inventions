package maps1.com.color_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by home on 08/03/2017.
 */
public class Calculator extends AppCompatActivity
{

    Button b1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.demo_task);

        b1 = (Button)findViewById(R.id.button1);

        e1 = (EditText)findViewById(R.id.editText);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                e1.setText("1");
            }
        });




    }
}
