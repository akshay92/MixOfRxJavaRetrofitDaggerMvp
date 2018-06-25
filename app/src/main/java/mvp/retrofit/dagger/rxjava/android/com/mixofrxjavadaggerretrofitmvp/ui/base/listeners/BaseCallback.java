package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base.listeners;


import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.ProductListModel;

/**
 * Created by akshay trivedi on 23/06/18.
 */

public interface BaseCallback {
    void onSuccess(ProductListModel newsModel);

    void onFail();
}
