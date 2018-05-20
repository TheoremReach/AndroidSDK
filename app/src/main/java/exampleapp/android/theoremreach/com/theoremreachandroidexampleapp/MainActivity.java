package exampleapp.android.theoremreach.com.theoremreachandroidexampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachMomentListener;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyAvailableListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

public class MainActivity extends AppCompatActivity implements TheoremReachRewardListener, TheoremReachSurveyListener, TheoremReachSurveyAvailableListener, TheoremReachMomentListener {

    Button takeSurveyButton;

    private final String TAG = "TheoremReach";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        TheoremReach.getInstance().setTheoremReachMomentListener(this);

        TheoremReach.getInstance().enableMoments(true);

        takeSurveyButton = (Button) findViewById(R.id.takeSurveyButton);
        takeSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TheoremReach.getInstance().isSurveyAvailable()) {
                    TheoremReach.getInstance().showRewardCenter();
                }

                // For Moments
//                if (TheoremReach.getInstance().isSurveyAvailable(15)) {
//                    TheoremReach.getInstance().showMomentSurvey();
//                }
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

    @Override
    public void onMomentSurveyOpened() {
        Log.d(TAG, "onMomentSurveyOpened");

    }

    @Override
    public void onMomentSurveyClosed() {
        Log.d(TAG, "onMomentSurveyClosed");

    }

    @Override
    public void onMomentSurveyReceived(int surveyLength) {
        Log.d(TAG, "onMomentSurveyReceived: " + surveyLength);
    }

    @Override
    public void onMomentSurveyCompleted() {
        Log.d(TAG, "onMomentSurveyCompleted");
    }

    @Override
    public void onMomentSurveyNotEligible() {
        Log.d(TAG, "onMomentSurveyNotEligible");
    }
}
