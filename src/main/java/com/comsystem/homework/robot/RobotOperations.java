package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service //Because Here we will have business logic
public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        // TODO

        //Can be replaced by exception or validation for example
        if(!validateInput(days)){
            return createRobotPlan(0,0,new ArrayList<>());
        }
        ArrayList<RobotAction> robotActions=new ArrayList<>();
        int numberOfStones = 0;
        int stonesToExcavate = 1;

       for(int i=0;i<days-1;i++){
           stonesToExcavate=addRobotActionClone(robotActions,stonesToExcavate);
       }
       numberOfStones = addRobotActionDig(robotActions,stonesToExcavate,numberOfStones);

       return createRobotPlan(days,numberOfStones,robotActions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     *         provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     *         {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     *         {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        if(!validateInput(numberOfStones)){
            return createRobotPlan(0,0,new ArrayList<>());
        }
        int numberOfDays = 1;
        int stonesToExcavate=1;
        ArrayList<RobotAction> robotActions = new ArrayList<>();
        while(stonesToExcavate<numberOfStones){
            stonesToExcavate=addRobotActionClone(robotActions,stonesToExcavate);
            numberOfDays++;
        }
        robotActions.add(RobotAction.DIG);

        return createRobotPlan(numberOfDays,numberOfStones,robotActions);

    }
    private RobotPlan createRobotPlan(int numberOfDays,int numberOfStones,ArrayList<RobotAction> robotActions){
        return new RobotPlan( numberOfDays,numberOfStones,robotActions);
    }
    private int addRobotActionClone(ArrayList<RobotAction> robotActions,int stonesToExcavate){
        robotActions.add(RobotAction.CLONE);
        return stonesToExcavate*2;
    }
    private int addRobotActionDig(ArrayList<RobotAction> robotActions,int stonesToExcavate,int numberOfStones){
        robotActions.add(RobotAction.DIG);
        return numberOfStones+stonesToExcavate;
    }
    private boolean validateInput(int input){
        return input > 0;
    }
}
