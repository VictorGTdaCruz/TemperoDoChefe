package devmob.processoseletivo.temperodochefe.login.presenter;

public interface LoginPresenter {

    void validateAndLogin(String email, String password);
    void validatedLogin(String email, String password);
    void logOut();
}
