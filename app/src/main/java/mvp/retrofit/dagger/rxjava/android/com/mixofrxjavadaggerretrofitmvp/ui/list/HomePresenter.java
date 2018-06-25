package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.list;

import android.os.Bundle;
import java.util.List;
import javax.inject.Inject;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.Product;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.ProductListModel;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base.Presenter;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base.listeners.BaseCallback;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.usecase.ProductListUseCase;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils.ObjectUtil;

/**
 * Created by akshay trivedi on 23/06/18.
 */

public class HomePresenter extends Presenter<HomeContract.View> implements HomeContract.Presenter {

    private final ProductListUseCase productListUseCase;

    @Inject
    public HomePresenter(ProductListUseCase productListUseCase) {
        this.productListUseCase = productListUseCase;
    }

    @Override
    public void initialize(Bundle extras) {
        super.initialize(extras);
        getProductList();
    }

    @Override
    public void getProductList() {
        productListUseCase.getProductList(callback);
    }

    @Override
    public void unSubscribe() {
        productListUseCase.unSubscribe();
    }


    private final BaseCallback callback = new BaseCallback() {
        @Override
        public void onSuccess(ProductListModel propertyListing) {
            List<Product> items = null;
            if (!ObjectUtil.isNull(propertyListing)) {
                items = propertyListing.getPropertyListing();
            }
            if (!ObjectUtil.isEmptyList(items) ) {
                getView().initializeProductList(propertyListing.getPropertyListing());
            }
        }

        @Override
        public void onFail() {
           }
    };
}
