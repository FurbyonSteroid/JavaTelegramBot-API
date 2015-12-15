package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
public class SendableVoiceMessage implements SendableMessage, ReplyingOptions {

	@NonNull
	@Getter
	private final InputFile voice;
	@Getter
	private final int duration;
	@Getter
	private final int replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

    SendableVoiceMessage(InputFile voice, int duration, int replyTo, ReplyMarkup replyMarkup) {

        this.voice = voice;
        this.duration = duration;
        this.replyTo = replyTo;
        this.replyMarkup = replyMarkup;
    }

    SendableVoiceMessage(InputFile voice, int duration, Message replyTo, ReplyMarkup replyMarkup) {

        this(voice, duration, replyTo != null ? replyTo.getMessageId() : 0, replyMarkup);
    }

    public static SendableVoiceMessageBuilder builder() {
        return new SendableVoiceMessageBuilder();
    }

    @Override
	public MessageType getType() {

		return MessageType.VOICE;
	}

    public static class SendableVoiceMessageBuilder {

        private InputFile voice;
        private int duration;
        private int replyTo;
        private ReplyMarkup replyMarkup;

        SendableVoiceMessageBuilder() {
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder voice(InputFile voice) {
            this.voice = voice;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder replyTo(int replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableVoiceMessage build() {
            return new SendableVoiceMessage(voice, duration, replyTo, replyMarkup);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableVoiceMessage.SendableVoiceMessageBuilder(voice=" + this.voice + ", duration=" + this.duration + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}
