package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.di;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.App;

/**
 * Created by akshay trivedi on 23/06/18.
 */
@Module
public class ListModule {

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return App.getContext();
    }

    @Provides
    public CompositeDisposable provideCompositeSubscription() {
        return new CompositeDisposable();
    }
}
