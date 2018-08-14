package id.chacha.desain.activity.halaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import id.chacha.desain.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import id.chacha.desain.adapter.CostumListAdapter;

public class Halaman2 extends AppCompatActivity {

    String[] menuItem = {"Gamepad", "Keyboard", "Mouse", "Phone", "Camera", "Computer", "Headphone", "Headset", "Dock"};
    Integer[] menuImage = {
            R.drawable.gamepad,
            R.drawable.keyboard,
            R.drawable.mouse,
            R.drawable.smartphone,
            R.drawable.camera_alt,
            R.drawable.computer,
            R.drawable.headset,
            R.drawable.headset_mic,
            R.drawable.dock};
    String[] menuLagi = {"Alat untuk bermain game", "Alat untuk mengetik", "Alat untuk mengerakkan kursor", "Alat untuk menelepon",
            "Alat untuk mengambil gambar", "Alat untuk berbagai keperluan", "Alat untuk mrndengarkan musik", "Alat untuk mendengarkan musik",
            "Alat untuk menmpilkan gambar"};

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman2);

        CostumListAdapter adapter = new CostumListAdapter(this, menuItem, menuImage, menuLagi);
        listView = (ListView)findViewById(R.id.mobilelist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Yang diklik adalah posisi ke : " + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}