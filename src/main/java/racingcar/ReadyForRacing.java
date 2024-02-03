package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ReadyForRacing {

    protected String getInput() {
        return readLine();
    }

    protected List<Car> getRacerList() {
        System.out.println(Info.CAR_NAME_INPUT);
        String racerLine = getInput();
        List<Car> list;

        try {
            String[] racers = racerLine.split(",");
            list = new ArrayList<>();
            for (String racer : racers) {
                if (!isInputEmpty(racer)) {
                    list.add(new Car(racer));
                }
            }
            if(list.size() != racers.length) {
                System.out.println(Info.ERROR_MSG);
                list = getRacerList();
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(Info.ERROR_MSG);
            list = getRacerList();
        }
        return list;
    }

    protected int getNumberOfAttempts() {
        System.out.println(Info.NUMBER_OF_ATTEMPTS);
        String input = getInput();
        int number = 0;
        try {
            if (Integer.parseInt(input) % 1 == 0) {
                number = Integer.parseInt(input);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(Info.ERROR_MSG_FOR_NUMBER);
            number = getNumberOfAttempts();
        }
        return number;
    }

    protected int getNumber() {
        return pickNumberInRange(0, 9);
    }

    protected boolean isInputEmpty(String input) {
        if ("".equals(input)) {
            return true;
        }
        if (input.replaceAll(" ", "").length() == 0) {
            return true;
        }

        return false;
    }

    protected String arrange(List<Winner> winners) {
        String wLine = "";
        for (int i = 0; i < winners.size(); i++) {
            wLine += winners.get(i).getWinner();

            if (i + 1 != winners.size()) {
                wLine += ", ";
            }
        }

        return wLine;
    }
}
