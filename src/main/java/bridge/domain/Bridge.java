package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

import bridge.constant.Direction;

public class Bridge {

    private List<Deck> decks;

    public Bridge(List<String> capitalLetters) {
        this.decks = capitalLetters.stream()
                .map(Deck::new)
                .collect(Collectors.toList());
    }

    public boolean isMovable(int position, Direction direction) {
        return decks.get(position).isMovable(direction);
    }
}
