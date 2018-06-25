package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by akshay trivedi on 24/06/18.
 */
public class ProductListModel {
    @SerializedName("propertyListing")
    @Expose
    private List<Product> propertyListing = null;

    public List<Product> getPropertyListing() {
        return propertyListing;
    }

    public void setPropertyListing(List<Product> propertyListing) {
        this.propertyListing = propertyListing;
    }
}
