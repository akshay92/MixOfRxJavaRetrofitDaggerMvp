package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.Product;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils.ObjectUtil;

/**
 * Created by akshay trivedi on 24/06/18.
 */
@Singleton
public class DataBaseDoor extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "product";
    public static final String PRODUCT_TABLE = "product";
    public static final String LANDMARK = "landmark";
    public static final String PRICE = "price";
    public static final String PRODUCT_NAME = "name";
    public static final String CITY = "city";
    public static final String REVIEW = "review";
    public static final String RATING_COUNT = "rating_count";


    private static final String ENCODING_SETTING = "PRAGMA encoding = 'UTF-8';";
    private static final int VER_LAUNCH = 1;
    Context context = null;
    @Inject
    public DataBaseDoor(Context context) {
        super(context, getDatabaseName(context), null, VER_LAUNCH);
        this.context = context;
    }

    private static String getDatabaseName(Context con) {
        return ObjectUtil.getPrivateSqlLiteCommonDatabaseFolderPath(con) + File.separator + DATABASE_NAME;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(ENCODING_SETTING);
            db.execSQL("CREATE TABLE "+PRODUCT_TABLE+" ( "+PRODUCT_NAME+" string , "+LANDMARK+" string,"+CITY+" string, "+REVIEW+" string,"+ RATING_COUNT +" int , "+PRICE+" int );");
        } catch (Exception e) {
            //
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertProduct(List<Product> productList) {
        SQLiteDatabase db = null;
        try {
            for(Product product : productList){
                ContentValues cv = new ContentValues();
                cv.put(PRODUCT_NAME, product.getName());
                cv.put(LANDMARK, product.getLandmark());
                cv.put(CITY, product.getCity());
                cv.put(REVIEW, product.getRatedText());
                cv.put(RATING_COUNT, product.getReviewCount());
                cv.put(PRICE, product.getPrice());
                db = getWritableDatabase();
                db.insert(PRODUCT_TABLE, "save", cv);
            }

        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    public List<Product> getAllProduct() {
        SQLiteDatabase db = null;
        List<Product> productList = null;
        try {
            db = getReadableDatabase();
            Cursor c = db.rawQuery("SELECT "+PRODUCT_NAME+","+LANDMARK+","+CITY+","+REVIEW+","+ RATING_COUNT +", "+PRICE+" FROM "+PRODUCT_TABLE+" ", null);
            if (c != null && c.getCount() > 0) {
                productList = new ArrayList<>();
                c.moveToFirst();
                do {
                    Product bookMarkNews = new Product();
                    bookMarkNews.setName(c.getString(0));
                    bookMarkNews.setLandmark(c.getString(1));
                    bookMarkNews.setCity(c.getString(2));
                    bookMarkNews.setRatedText(c.getString(3));
                    bookMarkNews.setPrice(c.getInt(5));
                    bookMarkNews.setReviewCount(c.getInt(4));
                    productList.add(bookMarkNews);
                    c.moveToNext();
                }
                while (!c.isAfterLast());
                c.close();
            }

        } catch (Exception e) {
          e.printStackTrace();
        }
        return productList;
    }
}
