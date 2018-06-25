package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import io.reactivex.Single;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo.service.ProductListService;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.Product;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.ProductListModel;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.database.DataBaseDoor;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils.Constants;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils.ObjectUtil;
import retrofit2.Call;
import static mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils.NetworkUtils.isConnected;
import static mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo.ServiceError.NETWORK_ERROR;
import static mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo.ServiceError.SUCCESS_CODE;
import static mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils.ObjectUtil.isNull;
import static mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils.Constants.ERROR_UNDEFINED;

/**
 * Created by akshay trivedi on 24/06/18.
 */

public class ListRepository implements ListSource{

    private ServiceGenerator serviceGenerator;
    private DataBaseDoor db;
    private Context context;

    @Inject
    public ListRepository(ServiceGenerator serviceGenerator, DataBaseDoor db,Context context) {
        this.serviceGenerator = serviceGenerator;
        this.db=db;
        this.context=context;
    }

    @Override
    public Single getProductList() {
        return Single.create(singleOnSubscribe -> {
                        try {
                            ProductListModel productListModelModel;
                            List<Product> productList=db.getAllProduct();
                            if(!ObjectUtil.isEmptyList(productList)){
                                productListModelModel = new ProductListModel();
                                productListModelModel.setPropertyListing(productList);
                                singleOnSubscribe.onSuccess(productListModelModel);
                                return;
                            }

                            if (!isConnected(context)) {
                                Exception exception = new NetworkErrorException();
                                singleOnSubscribe.onError(exception);
                            }
                            else {
                            ProductListService productService = serviceGenerator.createService(ProductListService.class, Constants.BASE_URL);
                            ServiceResponse serviceResponse = processCall(productService.fetchProductList(), false);
                            if (serviceResponse.getCode() == SUCCESS_CODE) {
                                productListModelModel = (ProductListModel) serviceResponse.getData();
                                db.insertProduct(productListModelModel.getPropertyListing());
                                singleOnSubscribe.onSuccess(productListModelModel);
                            } else {
                                Throwable throwable = new NetworkErrorException();
                                singleOnSubscribe.onError(throwable);
                            }
                            }
                        } catch (Exception e) {
                            singleOnSubscribe.onError(e);
                        }

                }
        );
    }

    @NonNull
    private ServiceResponse processCall(Call call, boolean isVoid) {
        if (!isConnected(context)) {
            return new ServiceResponse(new ServiceError());
        }
        try {
            retrofit2.Response response = call.execute();
            if (isNull(response)) {
                return new ServiceResponse(new ServiceError(NETWORK_ERROR, ERROR_UNDEFINED));
            }
            int responseCode = response.code();
            if (response.isSuccessful()) {
                return new ServiceResponse(responseCode, isVoid ? null : response.body());
            } else {
                ServiceError serviceError;
                serviceError = new ServiceError(response.message(), responseCode);
                return new ServiceResponse(serviceError);
            }
        } catch (IOException e) {
            return new ServiceResponse(new ServiceError(NETWORK_ERROR, ERROR_UNDEFINED));
        }
    }
}
