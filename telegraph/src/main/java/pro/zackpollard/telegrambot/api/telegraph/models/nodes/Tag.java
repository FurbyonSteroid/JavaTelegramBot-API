package pro.zackpollard.telegrambot.api.telegraph.models.nodes;

public enum Tag {
    A, ASIDE, B, BLOCKQUOTE, BR, CODE, EM, FIGCAPTION, FIGURE, H3, H4, HR, I, IFRAME, IMG, LI, OL, P, PRE, S, STRONG, U, UL, VIDEO;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
