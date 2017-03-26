package foody.jakzaizzat.com.foody.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import foody.jakzaizzat.com.foody.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String JsonFile = intent.getStringExtra("JsonFile");

        TextView ResultText = (TextView) findViewById(R.id.resultTextView);
        ResultText.setText(JsonFile);

    }
}
