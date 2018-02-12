package task.idealo.tyr.library.core.exception;

import java.text.MessageFormat;

public class TYRException extends RuntimeException {

    private String message;

    private TYRException(String message) {
        super(message);
    }

    public static TYRException createTYRException(TYRError error, String... parameters) {
        final String message = MessageFormat.format(error.getPattern(), (Object[]) parameters);
        return new TYRException(message);
    }

}
