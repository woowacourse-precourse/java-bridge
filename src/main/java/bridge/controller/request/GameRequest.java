package bridge.controller.request;

public class GameRequest {

    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private final String gameRequest;

    public GameRequest(String request) {
        validate(request);
        this.gameRequest = request;
    }

    private void validate(String request) {
        if (!isValid(request)) {
            throw new IllegalArgumentException("입력값은 R, Q 만 가능합니다.");
        }
    }

    private boolean isValid(String request) {
        return request.equals(RETRY) || request.equals(QUIT);
    }

    public boolean wantRetry() {
        if (gameRequest.equals(RETRY)) {
            return true;
        }
        return false;
    }


}
