package pro.zackpollard.telegrambot.api.telegraph;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import pro.zackpollard.telegrambot.api.telegraph.helper.RequestHelper;
import pro.zackpollard.telegrambot.api.telegraph.models.Account;
import pro.zackpollard.telegrambot.api.telegraph.models.Exceptions.MissingRequiredInformationException;
import pro.zackpollard.telegrambot.api.telegraph.models.Page;
import pro.zackpollard.telegrambot.api.telegraph.models.PageList;

import java.util.Arrays;

public class Telegraph {

    public static final String API_URL = "https://api.telegra.ph/";
    private static Gson gson = new Gson();

    public static Account login(String access_token) throws UnirestException {
        return gson
                .fromJson(
                        Unirest.get(Telegraph.API_URL + "getAccountInfo")
                                .queryString("access_token", access_token)
                                .queryString("fields", Arrays.asList("short_name", "author_name",
                                        "author_url", "auth_url", "page_count"))
                                .asString().getBody(),
                        Account.class);
    }

    public static Account createAccount(String short_name, String author_name, String author_url)
            throws MissingRequiredInformationException {
        if (short_name.isEmpty() || short_name == null) {
            throw new MissingRequiredInformationException("\"short_name\" must be set");
        }
        GetRequest request = Unirest.get(API_URL + "createAccount");
        request = RequestHelper.addStringToGetRequestIfNotEmpty("author_name", author_name, request);
        request = RequestHelper.addStringToGetRequestIfNotEmpty("author_url", author_url, request);
        String result = "";
        try {
            result = request.asString().getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Account account = gson.fromJson(result, Account.class);
        return account;
    }

    public static Page getPage(String path, boolean return_content) throws UnirestException {
        return gson.fromJson(Unirest.get(API_URL + "getPage/" + path)
                .queryString("return_content", return_content).asString().getBody(), Page.class);
    }

    public static PageList getPageList(String access_token, int offset, int limit) throws UnirestException {
        return gson.fromJson(
                Unirest.get(API_URL + "getPageList").queryString("access_token", access_token)
                        .queryString("offset", offset).queryString("limit", limit).asString().getBody(),
                PageList.class);
    }
}
