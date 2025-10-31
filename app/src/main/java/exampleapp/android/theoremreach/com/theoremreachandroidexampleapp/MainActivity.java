package exampleapp.android.theoremreach.com.theoremreachandroidexampleapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
        EdgeToEdge.enable(this);

        takeSurveyButton = (Button) findViewById(R.id.takeSurveyButton);
        takeSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity parentActivity = MainActivity.this;
                //initialize TheoremReach
                TheoremReach.initWithApiKeyAndUserIdAndActivityContext("884e30650fc43197d10813ff8e68", "ANDROID_TEST_ID", parentActivity);

                //customize navigation header
                TheoremReach.getInstance().setNavigationBarText("Demo App");
                TheoremReach.getInstance().setNavigationBarColor("#1B0C47");
                TheoremReach.getInstance().setNavigationBarTextColor("#FFFFFF");

                //set reward and survey status listeners
                TheoremReach.getInstance().setTheoremReachRewardListener(parentActivity);
                TheoremReach.getInstance().setTheoremReachSurveyListener(parentActivity);
                TheoremReach.getInstance().setTheoremReachSurveyAvailableListener(parentActivity);
                TheoremReach.getInstance().setAdjoePlaytimeEnabled(true);

                TheoremReach.getInstance().showRewardCenter();
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
