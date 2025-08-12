package exampleapp.android.theoremreach.com.theoremreachandroidexampleapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyAvailableListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

public class MainActivity extends AppCompatActivity implements TheoremReachRewardListener, TheoremReachSurveyListener, TheoremReachSurveyAvailableListener {
    Button takeSurveyButton;
    Boolean launched = false;
    private final String TAG = "TheoremReach";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize TheoremReach
//        TheoremReach.initWithApiKeyAndUserIdAndActivityContext("f4bfc509292953a3cf4274038763", "ANDROID_TEST_ID", this);
//
//        //customize navigation header
//        TheoremReach.getInstance().setNavigationBarText("Demo App");
//        TheoremReach.getInstance().setNavigationBarColor("#1B0C47");
//        TheoremReach.getInstance().setNavigationBarTextColor("#FFFFFF");
//
//        //set reward and survey status listeners
//        TheoremReach.getInstance().setTheoremReachRewardListener(this);
//        TheoremReach.getInstance().setTheoremReachSurveyListener(this);
//        TheoremReach.getInstance().setTheoremReachSurveyAvailableListener(this);

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

                // Subsequent clicks after surveyAvailable callback
                if (launched) {
                    TheoremReach.getInstance().showRewardCenter();
                }

                // Basic showRewardCenter
//                TheoremReach.getInstance().showRewardCenter();

                // Check if surveys are available first
//                if (TheoremReach.getInstance().getIsSurveyAvailable()) {
//                    // for second placement to earn Gems as well as Tokens
////                    TheoremReach.getInstance().showRewardCenter("66cb0225-3af3-4d63-8920-7a7a9e43abb2");
//                    TheoremReach.getInstance().showRewardCenter();
//                } else {
//                    // Handle case where no surveys are available for the user
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

        // Use surveyAvailable callback to launch rewards center
        if (!launched) {
            TheoremReach.getInstance().showRewardCenter();
            launched = true;
        }
    }
}
