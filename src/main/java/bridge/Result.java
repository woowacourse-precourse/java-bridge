package bridge;

public enum Result {
    SUCCESS("O"), FAIL("X"),;

    private String view;

    Result(String view) {
        this.view = view;
    }

    //메서드 이름 리팩토링.
    public String getView() {
        return view;
    }
}
