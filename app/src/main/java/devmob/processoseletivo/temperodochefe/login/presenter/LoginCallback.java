package devmob.processoseletivo.temperodochefe.login.presenter;

public interface LoginCallback {

    void loginSuccess();
    void loginError();
    void setCurrentUser(String currentUser);
}
