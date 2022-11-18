package bridge.domain;

public class Bridge {
    private String route;
    private boolean crossed = false;

    private Bridge() {
    }

    private Bridge(String route) {
        this.route = route;
    }

    public static Bridge create(String route) {
        return new Bridge(route);
    }
}
