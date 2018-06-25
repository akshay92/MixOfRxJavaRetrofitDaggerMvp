package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo.service;

import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.ProductListModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by akshay trivedi on 23/06/18.
 */

public interface ProductListService {
    @GET("bins/bs67u")
    Call<ProductListModel> fetchProductList();
}
