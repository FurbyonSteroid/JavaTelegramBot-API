package pro.zackpollard.telegrambot.api.telegraph.helper;

import com.mashape.unirest.request.GetRequest;

public class RequestHelper {

    public static GetRequest addStringToGetRequestIfNotEmpty(String name, String value,
            GetRequest request) {
        if (!value.isEmpty() && value != null) {
            request.queryString(name, value);
        }
        return request;
    }

    public static GetRequest addIntegerToGetRequestIfNotNull(String name, Integer value,
            GetRequest request) {
        if (value != null) {
            request.queryString(name, value);
        }
        return request;
    }
}
