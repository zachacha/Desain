package id.chacha.desain.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import id.chacha.desain.R;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MessageInputActivity extends AppCompatActivity {
    Context context = this;

    Button btnKeluar, btnInput, btnreset;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_input);

        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat message box
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("EXIT");
                builder.setMessage("Are you sure to exit?");
                // Membuat tombol negativ
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //Membuat tombol positif
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Bila pilih ok, maka muncul toast
                        finish();
                    }
                });
                builder.show();
            }
        });

        btnInput = (Button) findViewById(R.id.btnInput);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Membuat layout
                LinearLayout layoutinput = new LinearLayout(context);
                layoutinput.setOrientation(LinearLayout.VERTICAL);
                layoutinput.setPadding(50,50,50,50);

                // buat id tersembunyi di alertbuilder
                final TextView txtv = new TextView(context);
                txtv.setText("Panjang");
                txtv.setTextColor(Color.BLACK);
                layoutinput.addView(txtv);

                final EditText teks = new EditText(context);
                teks.setInputType(2);
                layoutinput.addView(teks);

                final TextView txtv2 = new TextView(context);
                txtv2.setText("Lebar");
                txtv2.setTextColor(Color.BLACK);
                layoutinput.addView(txtv2);

                final EditText teks2 = new EditText(context);
                teks.setInputType(2);
                layoutinput.addView(teks2);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Hitung Luas");
                builder.setView(layoutinput);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //Membuat tombol positif
                builder.setPositiveButton("Hitung", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Bila pilih ok, maka muncul toast
                        Toast.makeText(getApplicationContext(), "SUCCES", Toast.LENGTH_SHORT).show();
                        hasil = (TextView) findViewById(R.id.txthasil);
                        // Membuat perhitungan
                        int ang1 = Integer.parseInt(teks.getText().toString());
                        int ang2 = Integer.parseInt(teks2.getText().toString());
                        int hsl = ang1 * ang2;
                        hasil.setText("" +hsl);
                    }
                });
                builder.show();
            }
        });

        btnreset = (Button) findViewById(R.id.btnreset);
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil.setText("HASIL");
            }
        });
    }
}