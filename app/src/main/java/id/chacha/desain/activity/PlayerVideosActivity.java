package id.chacha.desain.activity;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;
import id.chacha.desain.R;

public class PlayerVideosActivity extends AppCompatActivity {
    private VideoView videoV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_videos);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_player_videos);

        videoV = (VideoView) findViewById(R.id.videoView);
        videoV.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.exo));
        videoV.setMediaController(new MediaController(this));
        videoV.requestFocus();
        videoV.start();
    }

    public void onConfigurasionChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}