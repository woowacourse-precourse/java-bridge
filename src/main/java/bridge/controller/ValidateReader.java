package bridge.controller;

import java.util.function.Function;

public interface ValidateReader {

    <T> T readUntilValidate(Function<Void, T> expression);
}
