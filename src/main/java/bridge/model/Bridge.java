package bridge.model;

public enum Bridge {

    START("[ "),
    END(" ]"),
    MID(" | ");

    private final String view;

    Bridge(String view){
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
