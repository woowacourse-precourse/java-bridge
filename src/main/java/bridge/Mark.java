package bridge;

/**
 * 지나온 경로를 지도에 표시할 표식
 */
public enum Mark {
    PATH("O"),
    BLOCK("X"),
    UNKNOWN(" ");

    private String mark;

    Mark(String mark) {
        this.mark = mark;
    }

    public String toString() {
        return mark;
    }
}
