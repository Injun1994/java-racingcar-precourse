package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Ready4Racing {

    protected String getInput() {
        return readLine();
    }

    protected List<Car> getRacerList() {
        System.out.println(Info.carNameInput);
        String racerLine = getInput();
        String[] racers = racerLine.split(",");

        List<Car> list = new ArrayList<>();
        for (String racer : racers) {
            try {
                if (!racer.equals("") && racer.replaceAll(" ", "").length() > 0) {
                    list.add(new Car(racer));
                } else {
                    throw new IllegalArgumentException(Info.error);
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(Info.error);
                list = getRacerList();
            }
        }
        return list;
    }

    protected int getNumberOfAttempts() {
        System.out.println(Info.numberOfAttemps);
        String input = getInput();
        int number = 0;
        try {
            if (Integer.parseInt(input) % 1 == 0) {
                number = Integer.parseInt(input);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(Info.errorMsg);
            number = getNumberOfAttempts();
        }
        return number;
    }

    protected int getNumber() {
        return pickNumberInRange(0, 9);
    }
}
