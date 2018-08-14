package id.chacha.desain.activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import id.chacha.desain.R;

import java.io.IOException;

public class MusikPlayerSederhanaActivity extends AppCompatActivity {
    MediaPlayer mpPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musik_player_sederhana);

        final Button btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sleep_away);
                mpPlayer = new MediaPlayer();
                mpPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
                    mpPlayer.setDataSource(getApplicationContext(), myUri);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URL correctly", Toast.LENGTH_LONG).show();
                } catch (SecurityException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URL correctly", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try{
                    mpPlayer.prepare();
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URL correctly", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URL correctly", Toast.LENGTH_LONG).show();
                }
                mpPlayer.start();
                Button btnstop = (Button) findViewById(R.id.btnStop);
                btnstop.setEnabled(true);
                btnPlay.setEnabled(false);
            }
        });

        final Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mpPlayer!=null && mpPlayer.isPlaying());
                mpPlayer.stop();
                Button btnplay = (Button) findViewById(R.id.btnPlay);
                btnplay.setEnabled(true);
                btnStop.setEnabled(false);
            }
        });
    }
}