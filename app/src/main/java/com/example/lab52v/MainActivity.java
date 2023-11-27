package com.example.lab52v;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private TextView headerTextView;

    private ArrayList<String> currencyList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        listView = findViewById(R.id.listView);
        headerTextView = findViewById(R.id.headerTextView);

        currencyList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currencyList);
        listView.setAdapter(adapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filter = editable.toString();
                filterCurrencyList(filter);
            }
        });

        new DataLoader(new Parser()).execute("https://api.exchangeratesapi.io/latest ");
    }

    private void filterCurrencyList(String filter) {
        ArrayList<String> filteredList = new ArrayList<>();
        for (String currency : currencyList) {
            if (currency.toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(currency);
            }
        }
        adapter.clear();
        adapter.addAll(filteredList);
    }
}
