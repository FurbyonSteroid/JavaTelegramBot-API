package pro.zackpollard.telegrambot.api.telegraph;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import pro.zackpollard.telegrambot.api.telegraph.helper.RequestHelper;
import pro.zackpollard.telegrambot.api.telegraph.models.Account;
import pro.zackpollard.telegrambot.api.telegraph.models.Exceptions.MissingRequiredInformationException;

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
        request = RequestHelper.addToGetRequestIfNotEmpty("author_name", author_name, request);
        request = RequestHelper.addToGetRequestIfNotEmpty("author_url", author_url, request);
        String result = "";
        try {
            result = request.asString().getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Account account = gson.fromJson(result, Account.class);
        return account;
    }
}
