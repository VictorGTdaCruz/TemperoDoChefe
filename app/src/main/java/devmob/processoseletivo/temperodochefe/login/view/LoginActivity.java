package devmob.processoseletivo.temperodochefe.login.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.login.presenter.LoginPresenter;
import devmob.processoseletivo.temperodochefe.login.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter loginPresenter;

    EditText emailField;
    EditText passwordField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);

        passwordField.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    validateAndLogin();
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.login_button).setOnClickListener(viewListener());

        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void toastError(){
        Toast.makeText(this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
    }

    private void validateAndLogin(){
        boolean valid = true;

        if (emailField.getText().toString().equals("")) {
            emailField.setError("Required.");
            valid = false;
        } else {
            emailField.setError(null);
        }

        if (passwordField.getText().toString().equals("")) {
            passwordField.setError("Required.");
            valid = false;
        } else {
            passwordField.setError(null);
        }

        if(!valid){
            return;
        }

        loginPresenter.validatedLogIn(emailField.getText().toString(), passwordField.getText().toString());
    }

    public void navigateToTables(String user){
        // TODO Make transition to next screen
        // intent.putExtra("LOGGED_USER", user);
    }

    private View.OnClickListener viewListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.login_button:
                        validateAndLogin();
                        break;
                }
            }
        };
    }
}
