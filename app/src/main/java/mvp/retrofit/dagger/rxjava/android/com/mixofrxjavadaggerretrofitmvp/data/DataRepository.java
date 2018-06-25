package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data;


import javax.inject.Inject;

import io.reactivex.Single;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo.ListRepository;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.ProductListModel;


/**
 * Created by akshay trivedi on 23/06/18.
 */
public class DataRepository implements DataSource {
    private ListRepository listRepository;

    @Inject
    public DataRepository(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public Single<ProductListModel> requestProducts() {
        return listRepository.getProductList();
    }
}
