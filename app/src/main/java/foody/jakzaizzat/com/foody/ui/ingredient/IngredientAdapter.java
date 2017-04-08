package foody.jakzaizzat.com.foody.ui.ingredient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.model.Ingredient;

public class IngredientAdapter extends ArrayAdapter<Ingredient> {

    public IngredientAdapter(Context context, List ingredients) {
        super(context, R.layout.ingredient_row ,ingredients);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ingInflater = LayoutInflater.from(getContext());
        View customView = ingInflater.inflate(R.layout.ingredient_row, parent, false);

        Ingredient singleIng = getItem(position);
        TextView ingName = (TextView) customView.findViewById(R.id.IngName);

        ingName.setText(singleIng.getName());

        return customView;

    }
}
