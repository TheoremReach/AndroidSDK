package exampleapp.android.theoremreach.com.theoremreachandroidexampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyAvailableListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

public class MainActivity extends Activity implements TheoremReachRewardListener, TheoremReachSurveyListener, TheoremReachSurveyAvailableListener {

    Button takeSurveyButton;

    private final String TAG = "TheoremReach";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize TheoremReach
        TheoremReach.initWithApiKeyAndUserIdAndActivityContext("40cdb7704cacbaeb4c4e491f4ece", "ANDROID_TEST_ID", this);

        //customize navigation header
        TheoremReach.getInstance().setNavigationBarText("Demo App");
        TheoremReach.getInstance().setNavigationBarColor("#211548");
        TheoremReach.getInstance().setNavigationBarTextColor("#FFFFFF");

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
