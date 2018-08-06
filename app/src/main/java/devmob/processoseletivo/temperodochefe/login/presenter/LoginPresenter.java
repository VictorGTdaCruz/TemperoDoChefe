package devmob.processoseletivo.temperodochefe.login.presenter;

public interface LoginPresenter {

    void validatedLogIn(String email, String password);
    void logOut();
}
