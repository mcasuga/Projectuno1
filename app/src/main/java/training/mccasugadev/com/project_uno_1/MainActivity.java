package training.mccasugadev.com.project_uno_1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start of the code

        Button addButton = (Button) findViewById(R.id.addButton);   // Search on the view for the id of addButton
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // The numbers to be added
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);     // number 1
                EditText secondNumEditText = (EditText)findViewById(R.id.secondNumEditText);    // number 2

                TextView actualTextView = (TextView) findViewById(R.id.actualTextView);

                int firstNumInteger = Integer.parseInt(firstNumEditText.getText().toString());
                int secondNumInteger = Integer.parseInt(secondNumEditText.getText().toString());

                int result = addTheNumbers(firstNumInteger, secondNumInteger);
                hideSoftKeyboard(MainActivity.this);
                actualTextView.setText(result + "");

            }
        });
    }

    public int addTheNumbers(int number1, int number2) {
        return number1 + number2;
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodMgr = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        View view = activity.getCurrentFocus();

        if (view != null) {
            inputMethodMgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } else {
            view = new View(activity);
        }
    }
}
