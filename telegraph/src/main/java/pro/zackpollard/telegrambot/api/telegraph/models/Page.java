package pro.zackpollard.telegrambot.api.telegraph.models;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import pro.zackpollard.telegrambot.api.telegraph.Telegraph;
import pro.zackpollard.telegrambot.api.telegraph.helper.RequestHelper;
import pro.zackpollard.telegrambot.api.telegraph.models.nodes.Node;

import java.util.List;

public class Page {
    private String access_token;
    private String path;
    private String url;
    private String title;
    private String description;
    private String author_name;
    private String author_url;
    private String image_url;
    private List<Node> content;
    private boolean return_content;
    private int views;
    private boolean can_edit;

    private Page() {
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public List<Node> getContent() {
        return content;
    }

    public int getViews() {
        return views;
    }

    public boolean can_edit() {
        return can_edit;
    }

    public static class PageBuilder {

        private String access_token;
        private String title;
        private String author_name;
        private String author_url;
        private List<Node> content;
        private boolean return_content;

        public PageBuilder(String access_token, String title, List<Node> content) {
            this.access_token = access_token;
            this.title = title;
            this.content = content;
        }

        public static PageBuilder requiredFields(String access_token, String title, List<Node> content) {
            return new PageBuilder(access_token, title, content);
        }

        public PageBuilder setAuthorName(String author_name) {
            this.author_name = author_name;
            return this;
        }

        public PageBuilder setAuthorUrl(String author_url) {
            this.author_url = author_url;
            return this;
        }

        public PageBuilder returnContent(boolean return_content) {
            this.return_content = return_content;
            return this;
        }

        public Page create() throws UnirestException {
            Gson gson = new Gson();
            GetRequest request = Unirest.get(Telegraph.API_URL + "createPage");
            request.queryString("access_token", access_token);
            request.queryString("title", title);
            request.queryString("content", content);
            request.queryString("return_content", return_content);
            RequestHelper.addToGetRequestIfNotEmpty("author_name", author_name, request);
            RequestHelper.addToGetRequestIfNotEmpty("author_url", author_url, request);
            return gson.fromJson(request.asString().getBody(), Page.class);
        }
    }
}
