package id.chacha.desain.activity.halaman;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import id.chacha.desain.R;

import java.io.IOException;

public class Halaman5 extends AppCompatActivity implements View.OnClickListener{

    private String url_radio = "https://www.pramborsfm.com/pages/streaming_window.php";
    private ProgressBar playSeekBar;
    private TextView tvRadioUrl;
    private Button buttonPlay;
    private Button buttonStop;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman5);
        initializeUIElements();
        initializeMediaPlayer();
    }

    private void initializeMediaPlayer() {
        player = new MediaPlayer();
        try {
            player.setDataSource(url_radio);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                playSeekBar.setIndeterminate(false);
                playSeekBar.setSecondaryProgress(100);
                Log.i("Buffering", "" + percent);
            }
        });

    }

    private void initializeUIElements() {
        playSeekBar = (ProgressBar) findViewById(R.id.progresBar);
        playSeekBar.setMax(100);
        playSeekBar.setVisibility(View.INVISIBLE);
        playSeekBar.setIndeterminate(true);

        buttonPlay = (Button) findViewById(R.id.btnPlay);
        buttonPlay.setOnClickListener(this);

        buttonStop = (Button) findViewById(R.id.btnStop);
        buttonStop.setEnabled(false);
        buttonStop.setOnClickListener(this);

        tvRadioUrl = (TextView) findViewById(R.id.textUrlRadio);
        tvRadioUrl.setText("Radio url : " + url_radio);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonPlay) {
            startPlaying();
        } else if (v == buttonStop) {
            stopPlaying();
        }

    }

    private void stopPlaying() {
        if (player == null) return;
        try{
            if (player.isPlaying()) {
                player.stop();
                player.release();
                initializeMediaPlayer();
            }
        } catch (IllegalStateException e) {

        }
        buttonPlay.setEnabled(true);
        buttonStop.setEnabled(false);
        playSeekBar.setIndeterminate(true);
        playSeekBar.setVisibility(View.INVISIBLE);
    }

    private void startPlaying() {
        buttonStop.setEnabled(true);
        buttonPlay.setEnabled(false);
        playSeekBar.setVisibility(View.VISIBLE);
        player.prepareAsync();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                player.start();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if(isTaskRoot() && player.isPlaying()) {
                    Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                    homeIntent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(homeIntent);
                    return true;
                } else {
                    super.onKeyDown(keyCode, event);
                    return true;
                }

            default:super.onKeyDown(keyCode, event);
                return true;
        }
    }
}