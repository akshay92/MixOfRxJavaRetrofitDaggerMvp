package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.usecase;

import javax.inject.Inject;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.DataRepository;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.ProductListModel;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base.listeners.BaseCallback;


/**
 * Created by akshay trivedi on 23/06/18.
 */
public class ProductListUseCase implements UseCase {
    private DataRepository dataRepository;
    private CompositeDisposable compositeDisposable;
    private Disposable newsDisposable;
    Single<ProductListModel> newsModelSingle;
    private DisposableSingleObserver<ProductListModel> disposableSingleObserver;

    @Inject
    public ProductListUseCase(DataRepository dataRepository, CompositeDisposable compositeDisposable) {
        this.dataRepository = dataRepository;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void getProductList(final BaseCallback callback) {
        disposableSingleObserver = new DisposableSingleObserver<ProductListModel>() {
            @Override
            public void onSuccess(ProductListModel newsModel) {
                callback.onSuccess(newsModel);
            }

            @Override
            public void onError(Throwable e) {
                callback.onFail();
            }
        };
        if (!compositeDisposable.isDisposed()) {
            newsModelSingle = dataRepository.requestProducts();
            newsDisposable = newsModelSingle.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribeWith(disposableSingleObserver);
            compositeDisposable.add(newsDisposable);
        }
    }

    public void unSubscribe() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.remove(newsDisposable);
        }
    }
}
