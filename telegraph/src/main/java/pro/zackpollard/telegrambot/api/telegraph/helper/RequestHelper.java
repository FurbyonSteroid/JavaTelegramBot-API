package pro.zackpollard.telegrambot.api.telegraph.helper;

import com.mashape.unirest.request.GetRequest;

public class RequestHelper {

    public static GetRequest addToGetRequestIfNotEmpty(String name, String value, GetRequest request) {
        if (!value.isEmpty() && value != null) {
            request.queryString(name, value);
        }
        return request;
    }
}
