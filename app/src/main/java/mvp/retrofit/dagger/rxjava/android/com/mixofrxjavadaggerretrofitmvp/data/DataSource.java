package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data;


import io.reactivex.Single;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.ProductListModel;

/**
 * Created by akshay trivedi on 23/06/18.
 */

interface DataSource {
    Single<ProductListModel> requestProducts();
}
