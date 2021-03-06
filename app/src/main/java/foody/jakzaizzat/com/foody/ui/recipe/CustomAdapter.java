package foody.jakzaizzat.com.foody.ui.recipe;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import foody.jakzaizzat.com.foody.R;
import foody.jakzaizzat.com.foody.model.Recipe;

public class CustomAdapter extends ArrayAdapter<Recipe>{

    public CustomAdapter(Context context, Recipe[] recipes) {
        super(context, R.layout.dashboard_row ,recipes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater recipesInflater = LayoutInflater.from(getContext());
        View customView = recipesInflater.inflate(R.layout.dashboard_row, parent, false);

        Recipe singleRecipe = getItem(position);

        //Set Initial Font
        Typeface ProximaReg = Typeface.createFromAsset(getContext().getAssets(),  "fonts/ProximaNova-Regular.otf");
        Typeface ProximaBold = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Proxima Nova Semibold.otf");

        TextView dashboardRowName = (TextView) customView.findViewById(R.id.dashboardRowName);
        TextView dashboardRowPrice = (TextView) customView.findViewById(R.id.dashboardRowPrice);

        //Set Font family
        dashboardRowName.setTypeface(ProximaReg);
        dashboardRowPrice.setTypeface(ProximaReg);

        dashboardRowName.setText(singleRecipe.getName());

        String price = "RM " + singleRecipe.getCost();
        dashboardRowPrice.setText(price + "0");

        return customView;

    }
}
