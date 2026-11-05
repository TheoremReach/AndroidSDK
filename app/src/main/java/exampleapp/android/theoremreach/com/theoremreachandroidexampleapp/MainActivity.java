package exampleapp.android.theoremreach.com.theoremreachandroidexampleapp;

import android.os.Bundle;
import android.util.Log;
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
        takeSurveyButton.setOnClickListener(v -> openRewardCenter("#1B0C47", "#FFFFFF"));
        // The status bar's icons over the reward center follow its title: dark under a dark title on a light title bar.
        findViewById(R.id.lightTitleBarButton).setOnClickListener(v -> openRewardCenter("#F2F2F7", "#1C1C1E"));
    }

    private void openRewardCenter(String titleBarColor, String titleColor) {
        //initialize TheoremReach
        TheoremReach.initWithApiKeyAndUserIdAndActivityContext("f4bfc509292953a3cf4274038763", "ANDROID_TEST_ID", this);

        //customize navigation header
        TheoremReach.getInstance().setNavigationBarText("Demo App");
        TheoremReach.getInstance().setNavigationBarColor(titleBarColor);
        TheoremReach.getInstance().setNavigationBarTextColor(titleColor);

        //set reward and survey status listeners
        TheoremReach.getInstance().setTheoremReachRewardListener(this);
        TheoremReach.getInstance().setTheoremReachSurveyListener(this);
        TheoremReach.getInstance().setTheoremReachSurveyAvailableListener(this);
        TheoremReach.getInstance().setAdjoePlaytimeEnabled(true);

        TheoremReach.getInstance().showRewardCenter();
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
