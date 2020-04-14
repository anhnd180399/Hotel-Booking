/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import duyanh.users.UserDTO;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author anhndSE130595
 */
public class APIWrapper {
    public static String FACEBOOK_APP_ID = "2923719714345522";
    public static String FACEBOOK_APP_SECRET = "bacc062acd86717147238a8182464a36";
    public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/ProjectPRJ321/FacebookServlet";
    public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
    private String accessToken;
    private Gson gson;

    public APIWrapper() {
        gson = new Gson();
    }

    public static String getDialogLink() {
        String dialogLink = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s";
        return String.format(dialogLink, FACEBOOK_APP_ID, FACEBOOK_REDIRECT_URL);
    }
//    public String getAccessToken(String code){
//        String accessTokenLink = "https://graph.facebook.com/oauth/access_token?"
//                + "client_id=%s"
//                + "&client_secret=%s"
//                + "&redirect_url=%s"
//                + "&code=%s";
//        accessTokenLink = String.format(accessTokenLink, appID,appSerect,redirectUrl,code);
//        String result = NetUtils.GetResult(accessTokenLink);
//        String token = result.substring(result.indexOf("=") + 1, result.indexOf("&"));
//        return token;
//    }

    public String getAccessToken(String code) throws IOException {
        String link = String.format(FACEBOOK_LINK_GET_TOKEN, FACEBOOK_APP_ID, FACEBOOK_APP_SECRET, FACEBOOK_REDIRECT_URL, code);
        String response = Request.Get(link).execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        this.accessToken = accessToken;
        return accessToken;
    }

    public UserDTO getUserInfo() {
        String infoUrl = "https://graph.facebook.com/me?access_token=%s";
        infoUrl = String.format(infoUrl, this.accessToken);
        String result = NetUtils.GetResult(infoUrl);
        UserDTO userInfo = gson.fromJson(result, UserDTO.class);
        return userInfo;
    }

}
