package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpHandler {

    private CloseableHttpClient httpclient;
    private CloseableHttpResponse response;

    private String requestMethod;
    private HttpGet httpGet;
    private HttpPost httpPost;
    private List<NameValuePair> headers;
    private String uri;
    private List<NameValuePair> parameters;
    private String bodyData;
    private StopWatch watch;

    public HttpHandler(String method) {
        httpclient = HttpClients.createDefault();
        requestMethod = method;  
        parameters = null;
        bodyData = null;
    }
    
    public void setHeaders(String[][] headers) {
        List<NameValuePair> header = new ArrayList<NameValuePair>();
        for (int i=0;i<headers.length;i++) {
            header.add(new BasicNameValuePair(headers[i][0], headers[i][1]));
        }

        this.headers = header;
    }
    
    public void setParameters(String[][] parameters) {
        List<NameValuePair> parameter = new ArrayList<NameValuePair>();
        for (int i=0;i<parameters.length;i++) {
            parameter.add(new BasicNameValuePair(parameters[i][0], parameters[i][1]));
        }
        
        this.parameters = parameter;
    }
    
    public void setBodyData(String bodyData) {
        this.bodyData = bodyData;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    
    private void headerManager() {
        if (headers!=null) {
            if (!headers.isEmpty() && headers.size() > 0) {
                if (requestMethod.equalsIgnoreCase("get")) {
                    for (int i=0;i<headers.size();i++) {
                        httpGet.setHeader(headers.get(i).getName(), headers.get(i).getValue());
                    }
                }
                else if (requestMethod.equalsIgnoreCase("post")) {
                    for (int i=0;i<headers.size();i++) {
                        httpPost.setHeader(headers.get(i).getName(), headers.get(i).getValue());
                    }
                }
            }
        }
    }
    
    private void entityManager() {
        if (parameters != null) {
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(parameters));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (bodyData != null) {
            try {
                httpPost.setEntity(new StringEntity(bodyData));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    
    public void sendRequest() {
        watch = new StopWatch();
        if (requestMethod.equalsIgnoreCase("get")) {
            httpGet = new HttpGet(uri);
            headerManager();
            try {
                watch.start();
                response = httpclient.execute(httpGet);
                watch.stop();
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }else if (requestMethod.equalsIgnoreCase("post")) {
            httpPost = new HttpPost(uri);
            headerManager();
            entityManager();
            try {
                watch.start();
                response = httpclient.execute(httpPost);
                watch.stop();
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    
    public int getStatusCode() {    
        return response.getStatusLine().getStatusCode();
    }
    
    public String getReasonPhrase() {
        return response.getStatusLine().getReasonPhrase();
    }
    
    public String getResponseBody() {
        String body = null;
        try {
             body = EntityUtils.toString(response.getEntity());
        } catch (ParseException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return body;
    }
    
    public String getContentType() {
        return response.getEntity().getContentType().toString();
    }
    
    public long getContentLength() {
        return response.getEntity().getContentLength();
    }
    
    public String getProtocol() {
        return response.getProtocolVersion().getProtocol();
    }
    
    public int getProtocolMajor() {
        return response.getProtocolVersion().getMajor();
    }
    
    public int getProtocolMinor() {
        return response.getProtocolVersion().getMinor();
    }
    
    public List<String> getHeaders(String name) {
        Header[] header = response.getHeaders(name);
        List<String> list = new ArrayList<String>();
        for (int i=0;i<header.length;i++) {
            list.add(header[i].getValue());
            
        }
        return list;
    }
    
    public boolean containsHeader(String name) {
        return response.containsHeader(name);
    }
    
    public int getResponseTime() {
        String[] time = watch.toString().split(":");
        int hour = Integer.parseInt(time[0])*3600;
        int minute = Integer.parseInt(time[1])*60;
        int second = (int)(Double.valueOf(time[2])*1000);
        int millis = hour+minute+second;
        return millis;
    }
    
    
}
