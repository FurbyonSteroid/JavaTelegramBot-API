package pro.zackpollard.telegrambot.api.telegraph.models.nodes;

import java.util.List;

public class NodeElement {
    private String tag;
    private String attributes;
    private List<Node> children;

    public String getTag() {
        return tag;
    }

    public String getAttributes() {
        return attributes;
    }

    public List<Node> getChildren() {
        return children;
    }
}
