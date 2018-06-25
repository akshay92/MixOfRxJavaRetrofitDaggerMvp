package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.utils;

import android.content.Context;

import java.io.File;
import java.util.List;

/**
 * Created by akshay trivedi on 23/06/18.
 */

public class ObjectUtil {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isEmptyList(List list) {
        return list == null || list.isEmpty();
    }

    public static String getPrivateSqlLiteCommonDatabaseFolderPath(Context context)
    {
        String sqllitedbpath= getPrivateDataStorageLocation(context);
        checkOrCreatePath(sqllitedbpath);
        return sqllitedbpath;
    }
    public static String getPrivateDataStorageLocation(Context context)
    {
        return context.getFilesDir().getAbsolutePath()+ File.separator+"/private/databases";
    }

    public static void checkOrCreatePath(String dirPath) {

        File f=new File(dirPath);
        if(!f.exists())
        {
            f.mkdirs();
        }
    }
}
