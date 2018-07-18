package devmob.processoseletivo.temperodochefe.login.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import devmob.processoseletivo.temperodochefe.login.presenter.Callback;

public class LoginModel {

    private FirebaseAuth auth;

    public LoginModel() {
        auth = FirebaseAuth.getInstance();
    }

    public void logIn(String email, String password, final Callback callback){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            callback.loginSuccess();
                        } else {
                            callback.loginError();
                        }
                    }
                });
    }

    public void logOut(){
        auth.signOut();
    }

    public FirebaseUser currentUser(){
        return auth.getCurrentUser();
    }
}
