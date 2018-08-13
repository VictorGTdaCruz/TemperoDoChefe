package devmob.processoseletivo.temperodochefe.login.presenter;

public interface LoginCallback {

    void loginSuccess(String currentUser);
    void loginError();
}
