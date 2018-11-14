package DFA;

import java.util.HashMap;
import java.util.Map;

public class TransitionFunction {

    private final Map<Integer, Map<Character, Integer>> function =
            new HashMap<>();

    public void setTransition(Integer startState,
                              Integer goalState,
                              char character) {
        function.putIfAbsent(startState, new HashMap<>());
        function.get(startState).put(character, goalState);
        System.out.println(function);
    }

    public Integer process(Integer startState, char character) {
        if (!function.containsKey(startState)) {
            return null;
        }

        return function.get(startState).get(character);
    }
}