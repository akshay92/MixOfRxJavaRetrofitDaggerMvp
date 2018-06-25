package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.usecase;

import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base.listeners.BaseCallback;
/**
 * Created by akshay trivedi on 23/06/18.
 */

public interface UseCase {
    void getProductList(final BaseCallback callback);

}
