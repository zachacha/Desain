package id.chacha.desain.activity.halaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import id.chacha.desain.R;

import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Halaman1 extends AppCompatActivity {

    String[] menuItem = {"Safari", "Firefox", "UC Browser", "Camera"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman1);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_list_halaman1, menuItem);

        ListView listview = (ListView) findViewById(R.id.mobilelist);
        listview.setAdapter(adapter);
    }
}