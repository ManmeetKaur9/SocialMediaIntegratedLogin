package in.terx.socialmediaintegratedlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //1
    private SocialMediaProvider mProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Login with Social Media");
    }

    public void performFacebookLogin(View view) {

        //2
        mProfile = SocialMediaProvider.FACEBOOK;

        //3
        performLogin();
    }

    public void performLinkedInLogin(View view) {
        mProfile = SocialMediaProvider.LINKED_IN;
        performLogin();
    }

    public void performTwitterLogin(View view) {
        mProfile = SocialMediaProvider.TWITTER;
        performLogin();
    }

    public void performGooglePlusLogin(View view) {
        mProfile = SocialMediaProvider.GOOGLE_PLUS;
        performLogin();
    }

    //4
    public void performLogin() {
        Intent intent = new Intent(this, LoginService.class);
        intent.putExtra(LoginService.EXTRA_PROFILE, mProfile);
        startService(intent);
    }
}
