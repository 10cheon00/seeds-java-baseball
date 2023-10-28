package baseball;

import java.util.Collections;
import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class Answer {
    private final Vector<Integer> answer = new Vector<>();

    public Answer(int size) {
        while (answer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        Collections.reverse(answer);
    }

    public int getStrikeCountFromInput(int input) {
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.elementAt(i) == input % 10) {
                count++;
            }
            input /= 10;
        }
        return count;
    }

    public int getBallCountFromInput(int input) {
        int count = -getStrikeCountFromInput(input);

        int[] counts = new int[10];
        for (int j : answer) {
            counts[j]++;
        }
        while (input > 0) {
            count += counts[input % 10];
            input /= 10;
        }

        return count;
    }
}
