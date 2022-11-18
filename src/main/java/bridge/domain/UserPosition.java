package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserPosition {
    private List<String> position;

    private UserPosition() {
        position = new ArrayList<>();
    }
    public static UserPosition newInstance() {
        return new UserPosition();
    }

    public void move(String command) {
        position.add(command);
    }

    public String getLastPosition() throws IllegalStateException {
        if (position.isEmpty())  {
            //TODO : 에러메세지 작성
            throw new IllegalStateException();
        }
        return position.get(position.size() -1 );
    }
}
