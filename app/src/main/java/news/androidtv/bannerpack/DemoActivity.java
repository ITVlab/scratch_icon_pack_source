package news.androidtv.bannerpack;

import android.app.Activity;
import android.os.Bundle;

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
    }
}
