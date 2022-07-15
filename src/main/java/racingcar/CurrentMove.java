package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CurrentMove implements MoveCondition{
    @Override
    public int forword() {
        if(Randoms.pickNumberInRange(0,9)>3)
            return 1;
        return 0;
    }
}
