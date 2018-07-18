package devmob.processoseletivo.temperodochefe.login.presenter;

import android.text.TextUtils;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

import devmob.processoseletivo.temperodochefe.login.model.LoginModel;
import  devmob.processoseletivo.temperodochefe.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    private LoginModel loginModel;
    private Callback callback;

    String emailString, passwordString;

    public LoginPresenterImpl(LoginView view){
        loginView = view;

        loginModel = new LoginModel();

        callback = new Callback() {
            @Override
            public void loginSuccess() {
                loginView.updateUI(loginModel.currentUser());
            }

            @Override
            public void loginError() {
                loginView.updateUI(loginModel.currentUser());
                loginView.toastError();
            }
        };
    }

    @Override
    public FirebaseUser currentUser() {
        return loginModel.currentUser();
    }

    @Override
    public void validateAndLogIn(TextView email, TextView password) {
        emailString = email.getText().toString();
        passwordString = password.getText().toString();
        boolean valid = true;

        if (TextUtils.isEmpty(emailString)) {
            email.setError("Required.");
            valid = false;
        } else {
            email.setError(null);
        }

        if (TextUtils.isEmpty(passwordString)) {
            password.setError("Required.");
            valid = false;
        } else {
            password.setError(null);
        }

        if(!valid){
            return;
        }

        loginModel.logIn(emailString, passwordString, callback);
    }

    @Override
    public void logOut() {
        loginModel.logOut();
        loginView.updateUI(currentUser());
    }
}
