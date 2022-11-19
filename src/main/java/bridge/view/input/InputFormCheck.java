package bridge.view.input;

@FunctionalInterface
interface InputFormCheck {
    boolean isCorrect(String input);
}
