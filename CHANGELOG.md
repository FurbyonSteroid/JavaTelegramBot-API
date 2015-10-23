# Changelog
#### Version 0.2.3
* Added error handling to message sending, the API will no longer throw JSON errors and will print out a nice description of the error.
* Added error printing to the Update Manager so that it doesn't just fail silently if the telegram API is erroring.
* Fixed error when TelegramBot.getChat(String chatID) was provided with a null or zero-length chatID.

#### Version 0.2.2
* Fixed ChannelChat#sendMessage() always returning null and not sending the message.

#### Version 0.2.1
* Made the from field in the Message type optional due to channels not providing that field.
  * Thanks for mentioning you were changing that in your changelog Telegram.

#### Version 0.2
* Implemented Channels (Telegram HTTP API Updated on 8/10/2015)
  * This required changing the Chat#getID() method to return a String rather than an int, this will break some bots if this method was used.

#### Version 0.1
* First Alpha Release
  * Includes all features excluding the webhook message request method