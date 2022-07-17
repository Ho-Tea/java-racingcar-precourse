package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class UserOutput {
    UserOutput(){}
    static final String nameError = "[ERROR] 자동차 이름이 맞지 않습니다.";
    static final String numError = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public static String getNameError(){
        return nameError;
    }
    public static String getNumError(){
        return numError;
    }
    public static void printFirst(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }
    public static void printSecond(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void printResult(){
        System.out.println("실행 결과");
    }
    public void printProcess(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName()+" : "+ getProcessline(car));
        }
        System.out.println();
    }

    private String getProcessline(Car car) {
        String line = "";
        for(int i = car.getPosition();i > 0;i--)
            line = line.concat("-");
        return line;
    }

    public void getWinner(List<Car> cars){  //코드 분석해보기!!!
        Map<String, Integer> candidate = new HashMap<>();
        for(Car car : cars){
            candidate.put(car.getName(),car.getPosition());
        }
        List listofMax = candidate.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == Collections.max(candidate.values()))
                .map(Map.Entry::getKey) // map함수를 통해 각원소의 키값을 빼온다
                .collect(Collectors.toList()); //list로 만든다
        String winner = String.join(", ",listofMax);
        System.out.println("최종 우승자 : "+ winner);
    }
}

