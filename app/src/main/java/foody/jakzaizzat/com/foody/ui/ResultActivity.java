package foody.jakzaizzat.com.foody.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.parceler.Parcels;

import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.model.Recipe;

public class ResultActivity extends AppCompatActivity {
    private TextView ResultName;
    private TextView ResultCost;
    private TextView ResultSell;
    private TextView ResultQuantity;
    private Button ResultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Recipe singleRecipe = (Recipe) Parcels.unwrap(getIntent().getParcelableExtra("RecipeObj"));


        TextView ResultName = (TextView) findViewById(R.id.ResultName);
        TextView ResultCost = (TextView) findViewById(R.id.ResultCost);
        TextView ResultSell = (TextView) findViewById(R.id.ResultSell);
        TextView ResultQuantity = (TextView) findViewById(R.id.ResultQuantity);
        Button ResultBtn = (Button) findViewById(R.id.ResultBtn);
        //ResultText.setText(JsonFile);


        //Set Text on Result Page
        ResultName.setText(singleRecipe.getName());
        ResultCost.setText("RM " + singleRecipe.getCost() + "0");

        double priceSell = singleRecipe.getCost() * 1.50;
        ResultSell.setText("RM " + priceSell + "0");

        ResultQuantity.setText(singleRecipe.getQuantity() + "");

        //Button Back to Dashboard
        ResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDashboard();
            }
        });


    }

    public void goDashboard(){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
}
