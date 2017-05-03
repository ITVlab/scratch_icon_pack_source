package news.androidtv.bannerpack;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

/**
 * Created by Nick on 5/2/2017.
 *
 * This demo activity on TVs and phones shows what the app is and how it works.
 */
public class DemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        getActionBar().hide();

        // Check if the app is on our device.
        if (isPackageInstalled("news.androidtv.tvapprepo") || isPackageInstalled("news.androidtv.tvapprepo.playstore")) {
            // Yes
            ((TextView) findViewById(R.id.tvapprepo_status)).setText("Tv App Repo is installed");
        } else {
            ((TextView) findViewById(R.id.tvapprepo_status)).setText("Tv App Repo is not installed. Click Enter to open Google Play.");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_A:
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                // Open that app in the store.
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=news.androidtv.tvapprepo.playstore"));
                startActivity(i);
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean isPackageInstalled(String packagename) {
        PackageManager packageManager = getPackageManager();
        try {
            packageManager.getPackageInfo(packagename, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
