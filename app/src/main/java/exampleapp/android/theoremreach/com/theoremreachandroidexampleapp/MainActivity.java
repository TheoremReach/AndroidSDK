package exampleapp.android.theoremreach.com.theoremreachandroidexampleapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyAvailableListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

public class MainActivity extends AppCompatActivity implements TheoremReachRewardListener, TheoremReachSurveyListener, TheoremReachSurveyAvailableListener {

    Button takeSurveyButton;
    private final String TAG = "TheoremReach";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //initialize TheoremReach
//        TheoremReach.getInstance().setDebugMode(true);
        TheoremReach.initWithApiKeyAndUserIdAndActivityContext("9148c4176f36f5302eb0a56695eb","TESTUSERID", this);

        //set reward and survey status listeners
        TheoremReach.getInstance().setTheoremReachRewardListener(this);
        TheoremReach.getInstance().setTheoremReachSurveyListener(this);
        TheoremReach.getInstance().setTheoremReachSurveyAvailableListener(this);

        takeSurveyButton = (Button) findViewById(R.id.takeSurveyButton);
        takeSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TheoremReach.getInstance().isSurveyAvailable()) {
                    TheoremReach.getInstance().showRewardCenter();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TheoremReach.getInstance().onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        TheoremReach.getInstance().onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onReward(int i) {
        Log.d(TAG, "onReward: " + i);
    }

    @Override
    public void onRewardCenterClosed() {
        Log.d(TAG, "onRewardCenterClosed");
    }

    @Override
    public void onRewardCenterOpened() {
        Log.d(TAG, "onRewardCenterOpened");
    }

    @Override
    public void theoremreachSurveyAvailable(boolean surveyAvailable) {
        Log.d(TAG, "TheoremReach Survey Available: " + surveyAvailable);
    }
}
