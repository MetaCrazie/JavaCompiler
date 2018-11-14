package DFA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class DFA {

    private final TransitionFunction transitionFunction;
    private final int startState;
    private final Set<Integer> acceptingStates;

    public DFA(TransitionFunction transitionFunction,
               int startState,
               Set<Integer> acceptingStates) {
        this.transitionFunction =
                Objects.requireNonNull(transitionFunction,
                        "Transition function is null.");
        this.startState = startState;
        this.acceptingStates =
                Objects.requireNonNull(acceptingStates,
                        "Accepting state set is null.");
    }

    public boolean matches(String text) {
        Integer currentState = startState;

        for (char c : text.toCharArray()) {
            currentState = transitionFunction.process(currentState, c);

            if (currentState == null) {
                return false;
            }
        }

        return acceptingStates.contains(currentState);
    }

    public static void main(String[] args) {
        // A regular language over binary strings with even number of 1's.
        TransitionFunction transitionFunction = new TransitionFunction();
        System.out.println("Transitions {start_state = {input = next_state}}:");

        transitionFunction.setTransition(0, 0, '0');
        transitionFunction.setTransition(1, 1, '0');
        transitionFunction.setTransition(0, 1, '1');
        transitionFunction.setTransition(1, 0, '1');

        Set<Integer> acceptingStates = new HashSet<>(Arrays.asList(0));
        DFA dfa = new DFA(transitionFunction, 0, acceptingStates);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.trim().equals("end")) {
                break;
            }

            System.out.println(dfa.matches(line));
        }
    }
}