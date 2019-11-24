package ch05.ex14;

import java.util.List;
import java.util.logging.*;

public class BadWordFilter implements Filter {
    private final List<String> badWords;

    public BadWordFilter(List<String> badWords) {
        this.badWords = badWords;
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("ch05.ex14");
        logger.setLevel(Level.ALL);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(logger.getLevel());

        logger.addHandler(handler);
        logger.setUseParentHandlers(false);

        List<String> badWords = List.of("sex", "drugs", "c++");

        // Using an instance of a class that implements Filter
        logger.setFilter(new BadWordFilter(badWords));

        logger.severe("Not logged: sex!");
        logger.warning("Logged: no bad words here!");
        logger.info("Not logged: drugs!");
        logger.config("Logged: this is also fine!");

        // Using a lambda expression
        logger.setFilter((record) -> {
            String message = record.getMessage().toLowerCase();
            return badWords.stream().noneMatch(message::contains);
        });

        logger.fine("Not logged: c++!");
        logger.finer("Logged: this last one is logged!");
        logger.finest("Bye!");
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        String message = record.getMessage().toLowerCase();
        return badWords.stream().noneMatch(message::contains);
    }
}
