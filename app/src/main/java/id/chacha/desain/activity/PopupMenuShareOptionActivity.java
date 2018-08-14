package id.chacha.desain.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import id.chacha.desain.R;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PopupMenuShareOptionActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    TextView teksMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu_share_option);
        teksMenu = (TextView) findViewById(R.id.teksMenu);
        Button btnPopup = (Button) findViewById(R.id.btnPopup);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menuPopup = new PopupMenu(PopupMenuShareOptionActivity.this, v);
                menuPopup.setOnMenuItemClickListener(PopupMenuShareOptionActivity.this);
                menuPopup.inflate(R.menu.menu_main);
                menuPopup.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSatu:
                teksMenu.setText("Kamu memilih menu satu");
                return true;
            case R.id.menuDua:
                teksMenu.setText("Kamu memilih menu dua");
                return true;
            case R.id.menuTiga:
                teksMenu.setText("Kamu memilih menu tiga");
                return true;
            case R.id.shareItem:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Ini Judul Sahare");
                share.putExtra(Intent.EXTRA_TEXT, "http://blogsetyaaji.blogspot.com");
                startActivity(Intent.createChooser(share, "Share Link !"));
        }
        return true;
    }
}