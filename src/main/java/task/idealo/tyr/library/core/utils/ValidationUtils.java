package task.idealo.tyr.library.core.utils;

import task.idealo.tyr.library.exception.TYRError;
import task.idealo.tyr.library.exception.TYRException;

public class ValidationUtils {

    public static void validateNotNull(Object value, TYRError error, String... parameters) {
        if (value == null) {
            throw TYRException.createTYRException(error, parameters);
        }
    }

    public static void assertFalse(Boolean value, TYRError error, String... parameters) {
        if (Boolean.TRUE.equals(value)) {
            throw TYRException.createTYRException(error, parameters);
        }
    }

    public static void assertTrue(Boolean value, TYRError error, String... parameters) {
        if (!Boolean.TRUE.equals(value)) {
            throw TYRException.createTYRException(error, parameters);
        }
    }
}
