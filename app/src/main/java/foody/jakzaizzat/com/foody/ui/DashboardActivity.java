package foody.jakzaizzat.com.foody.ui;

import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.ui.recipe.RecipeName;

public class DashboardActivity extends AppCompatActivity {

    public static final String TAG = DashboardActivity.class.getSimpleName();

    private String mName;
    private TextView mUserText;
    private FloatingActionButton floatBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();
        mName = intent.getStringExtra("name");

        if (mName == null){
            mName = "Guest";
        }
        System.out.println("His name is " + mName);
        Log.d(TAG, mName);


        mUserText = (TextView) findViewById(R.id.dashboardUserText);
        mUserText.setText("Hi " + mName);

        //Add New Recipe Button
        floatBtn = (FloatingActionButton) findViewById(R.id.DashboardAddNew);

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAddNewRecipe();

            }
        });





    }

    public void goAddNewRecipe(){
        Intent intent = new Intent(this, RecipeName.class);
        startActivity(intent);
    }




}
