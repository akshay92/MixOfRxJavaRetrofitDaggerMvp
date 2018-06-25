package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo;

import io.reactivex.Single;

/**
 * Created by akshay trivedi on 23/06/18.
 */

interface ListSource {
    Single getProductList();
}
