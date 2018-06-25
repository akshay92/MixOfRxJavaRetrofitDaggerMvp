package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.listrepo;

/**
 * Created by akshay trivedi on 23/06/18.
 */

public class ServiceResponse {
    private int code;
    private Object data;
    private ServiceError serviceError;

    public ServiceResponse(int code, Object response) {
        this.code = code;
        this.data = response;
    }

    public ServiceResponse(ServiceError serviceError) {
        this.serviceError = serviceError;
    }

    public ServiceResponse(Object response) {
        this.data = response;
    }

    public int getCode() {
        return code;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }

    public Object getData() {

        return data;
    }
}
