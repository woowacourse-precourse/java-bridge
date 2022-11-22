package bridge.status;

public enum Retry {
    RUN("R"),
    QUIT("Q");

    private final String text;


    private Retry(String text) {
        this.text = text;
    }

    private String getText() {
        return this.text;
    }

    public static boolean contains(String text) {
        for (Retry i : Retry.values()) {
            if (i.getText().equals(text)) {
                return true;
            }
        }

        return false;
    }

    public static Retry convert(String text) {
        for (Retry i : Retry.values()) {
            if (i.getText().equals(text)) {
                return i;
            }
        }

        throw new IllegalArgumentException("해당되는 재시도 명령을 찾을 수 없습니다");
    }
}
