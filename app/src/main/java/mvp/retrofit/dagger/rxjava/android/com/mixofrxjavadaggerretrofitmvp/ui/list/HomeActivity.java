package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.App;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.R;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.Product;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity  implements HomeContract.View {

    private RecyclerView rvProduct;
    @Inject
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvProduct=findViewById(R.id.rvProduct);
        homePresenter.getProductList();
    }

    @Override
    protected void initializeDagger() {
        App app = (App) getApplicationContext();
        app.getListComponent().inject(HomeActivity.this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = homePresenter;
        homePresenter.setView(this);
    }

    @Override
    public void initializeProductList(List<Product> news) {
        ProductListAdapter newsAdapter = new ProductListAdapter(news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setHasFixedSize(true);
        rvProduct.setAdapter(newsAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.unSubscribe();
    }
}
