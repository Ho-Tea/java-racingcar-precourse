package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행


        UserInput input = new UserInput();
        UserOutput output = new UserOutput();
        List<Car> cars = new ArrayList<>();

        for(String carname : input.getCarName())
            cars.add(new Car(carname));

        output.printResult();
        for(int i = input.getTrialNum();i > 0;i--){
            for(Car car:cars)
                car.move();
            output.printProcess(cars);
        }

        output.getWinner(cars);
    }
}
