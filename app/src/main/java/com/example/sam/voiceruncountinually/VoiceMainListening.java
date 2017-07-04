package com.example.sam.voiceruncountinually;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sam on 4/20/2017.
 */

public class VoiceMainListening extends ListeningActivity{
    private TextView content;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (TextView) findViewById(R.id.commands);
        layout = (ConstraintLayout) findViewById(R.id.layoutContent);

        // The following 3 lines are needed in every onCreate method of a ListeningActivity
        context = getApplicationContext(); // Needs to be set
        VoiceRecognitionListener.getInstance().setListener(this); // Here we set the current listener
        startListening(); // starts listening
    }

    // Setup
    @Override
    public void processVoiceCommands(String... voiceCommands) {

        content.setText(voiceCommands[0].toString());
        content.setTextSize(20);
        content.setTextColor(Color.BLACK);
        content.setGravity(Gravity.CENTER);

        Toast.makeText(this, voiceCommands[0], Toast.LENGTH_SHORT).show();

        restartListeningService();
    }
}
