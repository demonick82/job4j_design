package ru.job4j.ood.ocp;

public class SmtpMailer {
    private Logger logger;

    public SmtpMailer() {
        logger = new Logger();
    }

    public void sendMessage(String message) {
        logger.log(String.format("Отправлено %s ", message));
    }
}
