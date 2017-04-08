package foody.jakzaizzat.com.foody.ui.ingredient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.List;

import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.model.Ingredient;
import foody.jakzaizzat.com.foody.model.Recipe;

public class ListIngredientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ingredient);

        Intent intent = getIntent();
        final Recipe singleRecipe = (Recipe) Parcels.unwrap(getIntent().getParcelableExtra("RecipeObj"));


        //initialize object in temp List
        List<Ingredient> ListIng = singleRecipe.getList();

        Ingredient[] ingredients;

        //Move from List to Array
        int count = 0;
        for (Ingredient ing : ListIng){
            //ingredients[count] = ing;
            count++;
        }



        ListAdapter listIngAdapter = new IngredientAdapter(this, ListIng);
        ListView ingListView = (ListView) findViewById(R.id.IngListView);
        ingListView.setAdapter(listIngAdapter);

        ingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(ListIngredientActivity.this, food, Toast.LENGTH_LONG).show();
            }
        });
    }
}
