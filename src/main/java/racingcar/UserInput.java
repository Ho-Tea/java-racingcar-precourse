package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;


public class UserInput {
    private List<String> carname;
    private String inputname;
    private String inputnum;
    private ErrorDetection errordetect;

    UserInput()
    {
        carname = new ArrayList<>();
        putCarName();
        putTrialNum();
    }


    private void putCarName() {
        while(true){
            UserOutput.printFirst();
            inputname = Console.readLine();
            splitCarName();
            errordetect = new ErrorDetectionName(carname);
            if(errordetect.errorDetection() == 1)
                continue;
            break;
            }
    }



    private void putTrialNum(){
        while(true) {
            UserOutput.printSecond();
            inputnum = Console.readLine();
            errordetect = new ErrorDetectionNum(inputnum);
            if (errordetect.errorDetection() == 1)
                continue;
            break;
        }
    }
    
    private void splitCarName(){
        this.carname = Arrays.asList(inputname.split(","));
    }

    public List<String> getCarName(){
        return carname;
    }
    public int getTrialNum(){
        return Integer.parseInt(inputnum);
    }

}
