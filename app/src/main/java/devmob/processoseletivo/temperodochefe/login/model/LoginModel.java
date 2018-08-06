package devmob.processoseletivo.temperodochefe.login.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import devmob.processoseletivo.temperodochefe.login.presenter.LoginCallback;

public class LoginModel {

    private FirebaseAuth auth;

    public LoginModel() {
        auth = FirebaseAuth.getInstance();
    }

    public void logIn(String email, String password, final LoginCallback loginCallback){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            loginCallback.setCurrentUser(auth.getCurrentUser().getEmail());
                            loginCallback.loginSuccess();
                        } else {
                            loginCallback.loginError();
                        }
                    }
                });
    }

    public void logOut(){
        auth.signOut();
    }
}
