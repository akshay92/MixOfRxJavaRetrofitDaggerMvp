package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by akshay trivedi on 24/06/18.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Presenter presenter;

    protected abstract void initializeDagger();

    protected abstract void initializePresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        initializePresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.finalizeView();
        }
    }
}
