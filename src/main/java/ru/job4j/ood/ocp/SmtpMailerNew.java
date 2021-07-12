package ru.job4j.ood.ocp;

public class SmtpMailerNew {
    private DatabaseLogger logger;

    public SmtpMailerNew() {
        logger = new DatabaseLogger();
    }

    public void sendMesage(String message) {
        logger.log(String.format("Отправлено %s ", message));
    }
}
