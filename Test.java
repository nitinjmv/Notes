import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ssl.TrustStrategy;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

import javax.net.ssl.SSLContext;

@Bean
public RestTemplate restTemplate() throws Exception {
    TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;

    SSLContext sslContext = SSLContexts.custom()
            .loadTrustMaterial(null, acceptingTrustStrategy)
            .build();

    CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLContext(sslContext)
            .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
            .build();

    return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
}
