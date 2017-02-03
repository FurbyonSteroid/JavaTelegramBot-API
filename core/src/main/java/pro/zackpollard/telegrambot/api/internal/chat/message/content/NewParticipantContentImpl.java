package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.NewChatParticipantContent;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class NewParticipantContentImpl implements NewChatParticipantContent {

    private final User content;

    private NewParticipantContentImpl(JSONObject jsonObject) {

        this.content = UserImpl.createUser(jsonObject);
    }

    public static NewChatParticipantContent createNewParticipantContent(JSONObject jsonObject) {

        return jsonObject != null ? new NewParticipantContentImpl(jsonObject) : null;
    }

    /**
     * Gets the new participant in the chat
     *
     * @return The new participant, or null if there was no new participant
     */
    @Override
    public User getContent() {
        return content;
    }
}
