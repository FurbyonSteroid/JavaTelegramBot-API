package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.StickerContent;

/**
 * @author Zack Pollard
 */
public class StickerMessageReceivedEvent extends MessageReceivedEvent {

    public StickerMessageReceivedEvent(Message message) {

        super(message);
    }

    @Override
    public StickerContent getContent() {

        return (StickerContent) getMessage().getContent();
    }
}