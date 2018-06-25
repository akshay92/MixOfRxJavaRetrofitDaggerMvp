package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.di;

import javax.inject.Singleton;

import dagger.Component;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.list.HomeActivity;

/**
 * Created by akshay trivedi on 22/06/18.
 */
@Singleton
@Component(modules = ListModule.class)
public interface ListComponent {
    void inject(HomeActivity activity);
}

