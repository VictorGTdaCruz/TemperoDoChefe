package devmob.processoseletivo.temperodochefe.login.presenter;

import devmob.processoseletivo.temperodochefe.login.model.LoginModel;
import  devmob.processoseletivo.temperodochefe.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    private LoginModel loginModel;

    String emailString, passwordString, loggedUser;

    public LoginPresenterImpl(LoginView view){
        loginView = view;

        loginModel = new LoginModel();
    }

    @Override
    public void validatedLogIn(String email, String password) {
        emailString = email;
        passwordString = password;

        loginModel.logIn(emailString, passwordString, new LoginCallback() {
            @Override
            public void setCurrentUser(String currentUser){
                loggedUser = currentUser;
            }

            @Override
            public void loginSuccess() {
                loginView.navigateToTables(loggedUser);
            }

            @Override
            public void loginError() {
                loginView.toastError();
            }
        });
    }

    @Override
    public void logOut() {
        loginModel.logOut();
    }
}
