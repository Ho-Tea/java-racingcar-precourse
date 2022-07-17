package racingcar;

public class ErrorDetectionNum implements ErrorDetection{
    String trial;
    int errorstatus;
    ErrorDetectionNum(String num) {
        this.trial = num;
        errorstatus = 0;
    }
    @Override
    public int errorDetection() {
        try{
            if(!(trial.chars().allMatch(Character::isDigit)))
                throw new IllegalArgumentException(UserOutput.getNumError());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            errorstatus = 1;
        }
        return errorstatus;
    }
}
