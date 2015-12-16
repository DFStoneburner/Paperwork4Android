package stone.paperwork;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.Proxy;

/**
 * Created by pirate_steve on 3/29/2015.
 */
public class PaperworkAuthenticator implements Authenticator {
    @Override
    public Request authenticate(Proxy proxy, Response response) throws IOException {
        String credential = Credentials.basic("", "");
        return response.request().newBuilder()
                .header("Authorization", credential)
                .build();
    }

    @Override
    public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
        return null;
    }
}
