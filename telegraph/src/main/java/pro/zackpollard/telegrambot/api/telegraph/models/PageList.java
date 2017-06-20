package pro.zackpollard.telegrambot.api.telegraph.models;

import java.util.List;

public class PageList {
    private int total_count;
    private List<Page> pages;

    public int getTotal_count() {
        return total_count;
    }

    public List<Page> getPages() {
        return pages;
    }
}
