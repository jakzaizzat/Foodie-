package foody.jakzaizzat.com.foody.ui.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import foody.jakzaizzat.com.foody.Controller.FileController;
import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.model.Recipe;
import foody.jakzaizzat.com.foody.model.UserSimple;
import foody.jakzaizzat.com.foody.ui.ResultActivity;

public class RecipeName extends AppCompatActivity {

    private TextView recipeName;
    private Button recipeNameNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_name);


        recipeName = (TextView) findViewById(R.id.RecipeName);
        recipeNameNext = (Button) findViewById(R.id.RecipeNameNext);




        recipeNameNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = recipeName.getText().toString();

                //JSON
                Recipe recipeObj = new Recipe("Nasi Ikan", 2.00, 20);
                Gson gson = new Gson();
                String recipeJson = gson.toJson(recipeObj);
                System.out.println(recipeJson);

                //Write into new Recipe File
                writeMessage(name,recipeJson);

                //Write into List Recipe File
                    //writeMessage("list", recipeJson);
                updateListFile(recipeObj);


                //File
                goAddIngredient(name);
            }
        });



    }


    public void updateListFile(Recipe recipe){
        Recipe newRecipe = recipe;
        String filename = "list.json";

        //Store existing data on ArrayList
        String listString = readMessage("list");

        Gson updateGson = new Gson();

        Type recipeListType = new TypeToken<ArrayList<Recipe>>(){}.getType();
        List<Recipe> recipeList = updateGson.fromJson(listString, recipeListType);
        System.out.println("New JSON FIlE " + recipeList);
        //Add New Object in ArrayList
        recipeList.add(recipe);

        // Convert to JSON String
        String newListRecipe = updateGson.toJson(recipeList);
        System.out.println("New JSON FIlE " + newListRecipe);

        //Re-Write in List.json File
        String Message = newListRecipe;

        try{
            FileOutputStream fileOutputStream = openFileOutput(filename, MODE_PRIVATE);
            fileOutputStream.write(Message.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "List JSON Updated", Toast.LENGTH_LONG).show();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeMessage(String name, String json){
        String Message = json;
        String filename = name + ".json";
        try{
            FileOutputStream fileOutputStream = openFileOutput(filename, MODE_PRIVATE);
            fileOutputStream.write(Message.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Message Saved", Toast.LENGTH_LONG).show();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

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

    public void goAddIngredient(String name){
        Intent intent = new Intent(this, ResultActivity.class);

        //get message
        String tempJSON = readMessage(name);

        intent.putExtra("JsonFile", tempJSON);
        startActivity(intent);
    }
}
