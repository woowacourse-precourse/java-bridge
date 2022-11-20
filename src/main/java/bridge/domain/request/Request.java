package bridge.domain.request;

import java.util.Objects;

public class Request {

    private final String request;

    public Request(String input) {
        validateForm(input);
        this.request = input;
    }

    private void validateForm(String request) {
        if(!request.matches("[RQ]")) {
            throw new IllegalArgumentException("[ERROR] R 혹은 Q만 입력할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Request request1 = (Request) o;
        return request.equals(request1.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request);
    }

    @Override
    public String toString() {
        return "Request{" +
                "request='" + request + '\'' +
                '}';
    }
}
