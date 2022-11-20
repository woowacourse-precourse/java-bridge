package bridge.model;

import bridge.InputView;
import bridge.Move;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Map {
    static final int SIZE_OF_TILES = 2;
    private ArrayList<LinkedList<String>> map;
    private Iterator<String> answer;

    public Map(List<String> generatedMap) {
        InputView inputView = new InputView();
        ArrayList<LinkedList<String>> initializedMap = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_TILES; i++) {
            initializedMap.add(new LinkedList<String>());
        }
        this.answer = generatedMap.iterator();
        this.map = initializedMap;
    }

    public void insertMove(Move move) {


        for (LinkedList<String> target : map) {
            target.add(" ");
        }
        LinkedList<String> target = map.get(move.getOrder());
        target.set(target.size() - 1, compareWithCurrentAnswer(move.getLocation()));

        if (answer.hasNext() == false) {
        }
    }

    private String compareWithCurrentAnswer(String move) {
        if (move.equals(answer.next())) {
            return "O";
        }
        return "X";
    }

    //길이 줄여야함
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<String> target : map) {
            sb.append("[ ");
            for (String temp1 : target) {
                sb.append(temp1 + " | ");
            }
            sb.delete(sb.length() - 3, sb.length());
            sb.append(" ]\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
