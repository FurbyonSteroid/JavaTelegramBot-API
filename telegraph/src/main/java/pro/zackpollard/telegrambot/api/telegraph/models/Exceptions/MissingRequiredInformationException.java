package pro.zackpollard.telegrambot.api.telegraph.models.Exceptions;

public class MissingRequiredInformationException extends Exception {

    public MissingRequiredInformationException(String message) {
        super(message);
    }
}
