package com.example.hiddeneye.Models;

/**
 * Model class representing the messages in the Chat Fragment.
 */
public class Message {

    /**
     * Constant indicating that the message was sent by the user.
     */
    public static String SENT_BY_USER = "me";
    /**
     * Constant indicating that the message was sent by the bot.
     */
    public static String SENT_BY_BOT = "bot";

    private String message;
    private String sentBy;

    /**
     * Constructs a new Message object.
     *
     * @param message The content of the message.
     * @param sentBy  The sender of the message ("me" for user, "bot" for bot).
     */
    public Message(String message, String sentBy) {
        this.message = message;
        this.sentBy = sentBy;
    }

    /**
     * Returns the content of the message.
     *
     * @return The message content.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the content of the message.
     *
     * @param message The message content.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the sender of the message.
     *
     * @return The sender of the message ("me" for user, "bot" for bot).
     */
    public String getSentBy() {
        return sentBy;
    }

    /**
     * Sets the sender of the message.
     *
     * @param sentBy The sender of the message ("me" for user, "bot" for bot).
     */
    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }
}
