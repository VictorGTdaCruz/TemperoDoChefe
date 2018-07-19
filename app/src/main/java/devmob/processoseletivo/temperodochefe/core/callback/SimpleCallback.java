package devmob.processoseletivo.temperodochefe.core.callback;

public interface SimpleCallback<T> {

    void onSuccess(T response);

    void onError();

}
