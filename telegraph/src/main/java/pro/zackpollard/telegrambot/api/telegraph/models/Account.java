package pro.zackpollard.telegrambot.api.telegraph.models;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

import pro.zackpollard.telegrambot.api.telegraph.Telegraph;
import pro.zackpollard.telegrambot.api.telegraph.helper.RequestHelper;

public class Account {
    Gson gson = new Gson();
    private String short_name;
    private String author_name;
    private String author_url;
    private String access_token;
    private String auth_url;
    private String page_count;

    public Account editAccountInfo(String short_name, String author_name, String auth_url)
            throws UnirestException {
        GetRequest request = Unirest.get(Telegraph.API_URL + "editAccountInfo");
        request.queryString("access_token", access_token);
        request = RequestHelper.addStringToGetRequestIfNotEmpty("short_name", short_name, request);
        request = RequestHelper.addStringToGetRequestIfNotEmpty("author_name", author_name, request);
        request = RequestHelper.addStringToGetRequestIfNotEmpty("auth_url", auth_url, request);
        Account account = gson.fromJson(request.asString().getBody(), Account.class);
        this.short_name = account.getShort_name();
        this.author_name = account.getAuthor_name();
        this.author_url = account.getAuthor_url();
        return this;
    }

    public Account revokeAccessToken() throws UnirestException {
        Account account = gson.fromJson(
                Unirest.get(Telegraph.API_URL + "revokeAccessToken")
                        .queryString("access_token", this.access_token).asString().getBody(),
                Account.class);
        this.access_token = account.getAccess_token();
        this.auth_url = account.getAuth_url();
        return this;
    }

    public String getShort_name() {
        return short_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getAuth_url() {
        return auth_url;
    }

    public String getPage_count() {
        return page_count;
    }
}
