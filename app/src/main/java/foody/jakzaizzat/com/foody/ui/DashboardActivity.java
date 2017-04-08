package foody.jakzaizzat.com.foody.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

import org.parceler.Parcels;
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

        Typeface ProximaB = Typeface.createFromAsset(getAssets(),  "fonts/Proxima Nova Semibold.otf");
        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setTypeface(ProximaB);


        Intent intent = getIntent();
        mName = intent.getStringExtra("name");

        if (mName == null){
            mName = "Guest";
        }
        System.out.println("His name is " + mName);
        Log.d(TAG, mName);



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
                        Recipe recipeSingle = (Recipe) parent.getItemAtPosition(position);
                        Toast.makeText(DashboardActivity.this, recipe, Toast.LENGTH_LONG).show();
                        goResult(recipeSingle);
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

    public void goResult(Recipe recipe){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("RecipeObj", Parcels.wrap(recipe));
        startActivity(intent);
    }




}
