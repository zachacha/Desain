package id.chacha.desain.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import id.chacha.desain.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PerhitunganActivity extends AppCompatActivity {

    public EditText inputan1, inputan2;
    public Button tombol;
    public TextView hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perhitungan);
        inputan1 = (EditText) findViewById(R.id.input1);
        inputan2 = (EditText) findViewById(R.id.input2);
        tombol = (Button) findViewById(R.id.btn1);
        hasil = (TextView) findViewById(R.id.txthasil);

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas();
            }
        });
    }

    private void SetUpView(){

    }

    private void hitungLuas(){
        int angka1 = Integer.parseInt(inputan1.getText().toString());
        int angka2 = Integer.parseInt(inputan2.getText().toString());
        int yaitu = angka1 * angka2;
        hasil.setText("Luasnya adalah " +yaitu);
    }

}