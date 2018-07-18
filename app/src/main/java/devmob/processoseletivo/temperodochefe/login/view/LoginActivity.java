package devmob.processoseletivo.temperodochefe.login.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.login.presenter.LoginPresenter;
import devmob.processoseletivo.temperodochefe.login.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter loginPresenter;

    EditText emailField;
    EditText passwordField;
    TextView loginStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        loginStatus = findViewById(R.id.login_status);

        findViewById(R.id.login_button).setOnClickListener(viewListener());
        findViewById(R.id.logout_button).setOnClickListener(viewListener());

        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateUI(loginPresenter.currentUser());
    }

    public void updateUI(FirebaseUser user){
        if (user != null) {
            loginStatus.setText(getString(R.string.emailpassword_status_fmt,
                    user.getEmail()));

        } else {
            loginStatus.setText(R.string.signed_out);
        }
    }

    public void toastError(){
        Toast.makeText(this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
        loginStatus.setText(R.string.auth_failed);
    }

    private View.OnClickListener viewListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.login_button:
                        loginPresenter.validateAndLogIn(emailField, passwordField);
                        break;
                    case R.id.logout_button:
                        loginPresenter.logOut();
                        break;
                }
            }
        };
    }
}
