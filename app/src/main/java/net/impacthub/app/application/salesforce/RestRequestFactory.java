package net.impacthub.app.application.salesforce;

import com.salesforce.androidsdk.rest.RestRequest;

import java.io.UnsupportedEncodingException;

public interface RestRequestFactory {

    RestRequest getForQuery(String sql) throws UnsupportedEncodingException;
}
