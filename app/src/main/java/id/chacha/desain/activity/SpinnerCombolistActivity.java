package id.chacha.desain.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import id.chacha.desain.R;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerCombolistActivity extends AppCompatActivity {

    TextView teksPilih;
    private Spinner sp_negara;
    private String[] list = {"-Pilih-", "Amerika", "Indonesia", "Malaysia", "India"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_combolist);

        teksPilih = (TextView) findViewById(R.id.textView);

        sp_negara = (Spinner) findViewById(R.id.spinner);
        sp_negara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teksPilih.setText(list[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                teksPilih.setText("");
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp_negara.setAdapter(adapter);

    }
}