package devmob.processoseletivo.temperodochefe.login.presenter;

import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public interface LoginPresenter {

    void validateAndLogIn(TextView email, TextView password);
    void logOut();
    FirebaseUser currentUser();
}
