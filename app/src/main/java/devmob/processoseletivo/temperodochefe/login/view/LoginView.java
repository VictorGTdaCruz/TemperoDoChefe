package devmob.processoseletivo.temperodochefe.login.view;

import com.google.firebase.auth.FirebaseUser;

public interface LoginView {

    void updateUI(FirebaseUser user);
    void toastError();
}
