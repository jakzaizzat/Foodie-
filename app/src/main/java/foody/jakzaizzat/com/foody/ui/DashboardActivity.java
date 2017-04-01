package foody.jakzaizzat.com.foody.ui;

import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.model.Recipe;
import foody.jakzaizzat.com.foody.model.UserSimple;
import foody.jakzaizzat.com.foody.ui.recipe.CustomAdapter;
import foody.jakzaizzat.com.foody.ui.recipe.RecipeName;

public class DashboardActivity extends AppCompatActivity {

    public static final String TAG = DashboardActivity.class.getSimpleName();

    private String mName;
    private TextView mUserText;
    private FloatingActionButton floatBtn;
    private TextView dashboardFoodName;
    private TextView dashboardPriceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //dashboardFoodName = (TextView) findViewById(R.id.dashboardFoodName);

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

        //List All Recipe

        String allRecipeJson = readMessage("list");
        Gson allRecipeJSON = new Gson();

        Recipe[] allRecipe = allRecipeJSON.fromJson(allRecipeJson, Recipe[].class);

//        dashboardFoodName = (TextView) findViewById(R.id.dashboardFoodName);
//        dashboardFoodName.setText(allRecipe[0].getName());
//
//        dashboardPriceName = (TextView) findViewById(R.id.dashboardFoodPrice);
//
//        String cost =  "RM " + allRecipe[0].getCost();
//        dashboardPriceName.setText(cost);

        //Using ListView

        String[] recipes = {"Ayam", "Ikan", "Pisang"};

        ListAdapter recipeAdapter = new CustomAdapter(this, allRecipe);

        ListView recipeListView = (ListView) findViewById(R.id.recipeListView);

        recipeListView.setAdapter(recipeAdapter);

        recipeListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String recipe = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(DashboardActivity.this, recipe, Toast.LENGTH_LONG).show();
                    }
                }
        );





    }

    public void goAddNewRecipe(){
        Intent intent = new Intent(this, RecipeName.class);
        startActivity(intent);
    }

    public String readMessage(String name){
        try {
            String Message;
            name = name + ".json";
            FileInputStream fileInputStream = openFileInput(name);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((Message=bufferedReader.readLine())!=null){
                stringBuffer.append(Message + "\n");

            }

            Message = stringBuffer.toString();

            return Message;

        }catch (FileNotFoundException e){
            e.printStackTrace();
            return "FileNotFound readMessage";
        }catch (IOException e){
            e.printStackTrace();
            return "IO exception error";
        }

    }




}
