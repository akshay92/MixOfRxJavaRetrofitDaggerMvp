package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp;

import android.app.Application;
import android.content.Context;

import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.di.DaggerListComponent;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.di.ListComponent;

/**
 * Created by akshay trivedi on 23/06/18.
 */
public class App extends Application {
    private ListComponent listComponent;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        listComponent = DaggerListComponent.create();
        context = getApplicationContext();
    }

    public ListComponent getListComponent() {
        return listComponent;
    }

    public static Context getContext() {
        return context;
    }

}
