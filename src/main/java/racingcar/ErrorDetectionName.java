package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ErrorDetectionName implements ErrorDetection{
    List<String> carname;
    int errorstatus;
    ErrorDetectionName(List<String> carname){
        this.carname = carname;
        errorstatus = 0;
    }
    @Override
    public int errorDetection() {
        for(String carname:carname) {
            try {
                if (carname.length() > 5 || carname.length() == 0)
                    throw new IllegalArgumentException(UserOutput.getNameError());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                errorstatus = 1;
                break;
            }
        }
        return errorstatus;
    }
}
