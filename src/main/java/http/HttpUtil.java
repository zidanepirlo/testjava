package http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pzhealth.erppre.facade.dto.BaseRes;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private HttpUtil(){

    }

    public static <T> T postJson(final String url,final Map<String,String> keyVal,Class<T> classOfT) throws IOException {

        List<NameValuePair> formParams = new ArrayList<NameValuePair>();


        if(keyVal != null && keyVal.size()>0){
            Iterator iter = keyVal.entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                String val = (String) entry.getValue();
                formParams.add(new BasicNameValuePair(key, val));
            }
        }

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(50000)
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000)
                .build();

        CloseableHttpClient httpClient =  HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();

        HttpPost httpPost = new HttpPost(url);
        HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();

        if(null == httpEntity) return null;

        Gson gson = new GsonBuilder().create();
        String temp = gson.toString();
        ContentType contentType = ContentType.getOrDefault(httpEntity);
        Charset charset = contentType.getCharset();
        Reader reader = new InputStreamReader(httpEntity.getContent(), charset);

        return (T)gson.fromJson(reader, classOfT);
    }


}
