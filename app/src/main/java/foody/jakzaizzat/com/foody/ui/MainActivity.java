package foody.jakzaizzat.com.foody.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.ui.ingredient.ListIngredientActivity;
import foody.jakzaizzat.com.foody.ui.recipe.RecipeName;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    private  EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/ProximaNova-Regular.otf");


        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.StartButton);

        mNameField.setTypeface(custom_font);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                goDashboard(name);

            }
        });

    }

        public void goDashboard(String name){
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }





}
