package pro.zackpollard.telegrambot.api.telegraph.models.nodes;

public enum Attribute {
    HREF, SRC;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
