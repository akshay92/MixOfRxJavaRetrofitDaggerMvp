package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.list;

import java.util.List;

import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.Product;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base.listeners.BaseView;

/**
 * Created by akshay trivedi on 24/06/18.
 */
public interface HomeContract {
    interface View extends BaseView {
        void initializeProductList(List<Product> news);

    }


    interface Presenter {
        void getProductList();
        void unSubscribe();
    }
}
