package pl.ipepe.android.globalbuttonclickcounter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MainActivity extends AppCompatActivity {
    WebView webView;
    String BUTTONS_URL = "http://buttons.azurewebsites.net/";
    String IPEPE_APP_STORE_URL = "https://play.google.com/store/apps/developer?id=Patryk+Ptasinski";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
//        setContentView(R.layout.main_activity);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(BUTTONS_URL);

    }
    @Override
    public void onResume(){
        super.onResume();
        webView.loadUrl(BUTTONS_URL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.more_apps:
                final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(IPEPE_APP_STORE_URL));
                this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
