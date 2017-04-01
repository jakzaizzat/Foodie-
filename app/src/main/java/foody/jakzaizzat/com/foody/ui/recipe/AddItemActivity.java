package foody.jakzaizzat.com.foody.ui.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.model.Ingredient;
import foody.jakzaizzat.com.foody.model.Recipe;

public class AddItemActivity extends AppCompatActivity {
    private ListView ingListView;
    private ArrayList<Ingredient> ingredients;
    private ArrayAdapter<Ingredient> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ingListView = (ListView) findViewById(R.id.ingListView);
        ingredients = new ArrayList<Ingredient>();

        itemsAdapter = new ArrayAdapter<Ingredient>(this, android.R.layout.simple_list_item_1, ingredients);

        ingListView.setAdapter(itemsAdapter);

        Ingredient ing1 = new Ingredient("Burger",20,2,3,"material");
        Ingredient ing2 = new Ingredient("Sayur",15,2,5,"material");


        ingredients.add(ing1);
        ingredients.add(ing2);

        //Setup OnClickListener



    }

    public void onAddItem(View v){
        EditText textAddIng = (EditText) findViewById(R.id.textAddIng);

        String singleIng = textAddIng.getText().toString();

        Ingredient tempIng = new Ingredient(singleIng, 10,23, 3,"material");
        itemsAdapter.add(tempIng);

        textAddIng.setText("");

    }

    private void setupListViewListener(){
        ingListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ingredients.remove(position);

                itemsAdapter.notifyDataSetChanged();

                return true;

            }
        });
    }
}
