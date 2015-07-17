package edu.washington.echee.wearexample2;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WearActivity extends Activity {

    private TextView mTextView;
    private int numClicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);

        this.numClicks = 0;

        // stub is where all the the views (like button)
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                
                // Most of your code goes in here

                // grab button
                Button btnButton = (Button) stub.findViewById(R.id.btnButton);
                final TextView tvNum = (TextView) stub.findViewById(R.id.tvNum);    // grab textview

                btnButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // When button clicks, update the number of clicks
                        numClicks++;
                        tvNum.setText(numClicks+ "");   // text views take in string so must convert int to String
                    }
                });
            }
        });
    }
}
