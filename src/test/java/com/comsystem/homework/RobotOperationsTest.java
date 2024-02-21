    package com.comsystem.homework;

    import com.comsystem.homework.model.RobotAction;
    import com.comsystem.homework.model.RobotPlan;
    import com.comsystem.homework.robot.RobotOperations;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.ContextConfiguration;
    import org.springframework.web.ErrorResponseException;

    import java.lang.reflect.Array;
    import java.util.ArrayList;
    import java.util.Arrays;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertThrows;

    @SpringBootTest
    @ContextConfiguration(classes = HomeworkApplication.class)
    public class RobotOperationsTest {

        @Autowired
        private  RobotOperations robotOperations;

        @Test
        public void testExcavateStonesForDaysWithCorrectData(){
            ArrayList<RobotAction> robotActions = new ArrayList<>(Arrays.asList(
                    RobotAction.CLONE,
                    RobotAction.CLONE,
                    RobotAction.CLONE,
                    RobotAction.CLONE,
                    RobotAction.DIG));

            RobotPlan robotPlan = new RobotPlan(5,16,robotActions);
            assertEquals(robotPlan,robotOperations.excavateStonesForDays(5),"Must Be 5 Because the best case is:COPY,COPY,COPY,COPY,DIG-2-4-8-16-16");
        }
        @Test
        public void testDaysRequiredToCollectStonesWithCorrectData(){
            ArrayList<RobotAction> robotActions = new ArrayList<>(Arrays.asList(
                    RobotAction.CLONE,
                    RobotAction.CLONE,
                    RobotAction.CLONE,
                    RobotAction.DIG));
            RobotPlan robotPlan = new RobotPlan(4,7,robotActions);
            assertEquals(robotPlan,robotOperations.daysRequiredToCollectStones(7));
        }
    }
