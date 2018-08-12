package devmob.processoseletivo.temperodochefe.login.presenter;

import devmob.processoseletivo.temperodochefe.login.model.LoginModel;
import  devmob.processoseletivo.temperodochefe.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView view){
        loginView = view;

        loginModel = new LoginModel();
    }

    @Override
    public void validateAndLogin(String email, String password){
        boolean valid = true;

        if (email.equals("")) {
            loginView.setFieldError("email");
            valid = false;
        }

        if (password.equals("")) {
            loginView.setFieldError("password");
            valid = false;
        }

        if(!valid){
            return;
        }

        validatedLogin(email, password);
    }

    @Override
    public void validatedLogin(String email, String password) {

        loginModel.logIn(email, password, new LoginCallback() {

            @Override
            public void loginSuccess(String loggedUser) {
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
