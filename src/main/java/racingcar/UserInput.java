package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;


public class UserInput {
    private List<String> carname;
    private String inputname;
    private String inputnum;

    UserInput()
    {
        carname = new ArrayList<>();
        inputCarName();
        inputTrialNum();
    }


    private void inputCarName() {
            UserOutput.printFirst();
            inputname = Console.readLine();
            splitCarName();
            for(String carnamed : carname) {
                if (errorDetectionName(carnamed)){
                    carname.clear();
                    inputCarName();
                }
            }
    }



    private void inputTrialNum(){
        while(true) {
            UserOutput.printSecond();
            inputnum = Console.readLine();
            if (errorDetectionNum(inputnum))
                break;
            continue;
        }
    }
    
    private void splitCarName(){
        carname = Arrays.asList(inputname.split(","));
    }

    public List<String> getCarName(){
        return carname;
    }
    public int getTrialNum(){
        return Integer.parseInt(inputnum);
    }

    private boolean errorDetectionName(String read) {
        try{
            if(read.length() > 5 || read.length() == 0)
                throw new IllegalArgumentException(UserOutput.getNameError());
            return false;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    private boolean errorDetectionNum(String read){
        try{
            if(!(read.chars().allMatch(Character::isDigit)))
                throw new IllegalArgumentException(UserOutput.getNumError());
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
