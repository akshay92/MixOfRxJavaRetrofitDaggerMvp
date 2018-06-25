package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshay trivedi on 24/06/18.
 */
public class Product {
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("reviewCount")
    @Expose
    private Integer reviewCount;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("ratedText")
    @Expose
    private String ratedText="";

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRatedText() {
        return ratedText;
    }

    public void setRatedText(String ratedText) {
        this.ratedText = ratedText;
    }
}
