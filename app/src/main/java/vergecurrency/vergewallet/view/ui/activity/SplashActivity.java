package vergecurrency.vergewallet.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.testfairy.TestFairy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import vergecurrency.vergewallet.R;
import vergecurrency.vergewallet.service.model.PreferencesManager;
import vergecurrency.vergewallet.view.ui.activity.firstlaunch.FirstLaunchActivity;

public class SplashActivity extends AppCompatActivity {

	PreferencesManager pm;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//TestFairy token for getting info on beta testing
		TestFairy.begin(this, "a67a4df6e2a8a0c981638eb0f168297fd45aed73");

		//gets the holy preferences
		pm = PreferencesManager.init(getApplicationContext());

		setContentView(R.layout.activity_splash);

		if (pm.getFirstLaunch()) {
			finish();
			startActivity(new Intent(getApplicationContext(), FirstLaunchActivity.class));
		} else {
			finish();
			startActivity(new Intent(getApplicationContext(), WalletActivity.class));
		}

	}

	@Override
	public void onBackPressed() {
	}

}
