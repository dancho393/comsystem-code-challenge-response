package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.comsystem.homework.robot.RobotOperations;


@RestController()
@RequestMapping("/api/v1/robot/operation")
@RequiredArgsConstructor
public final class RobotRestController {
    private final RobotOperations robotOperations;

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")
    public ResponseEntity<RobotPlan> excavateStones(@RequestParam Integer numberOfDays) {
        // TODO
        try {
            return ResponseEntity.ok(robotOperations.excavateStonesForDays(numberOfDays));
        }
        catch (ErrorResponseException e) {
            throw new ErrorResponseException(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    public ResponseEntity<RobotPlan> approximateDays(@RequestParam Integer numberOfStones) {
        // TODO
        try {
            return ResponseEntity.ok(robotOperations.daysRequiredToCollectStones(numberOfStones));
        }
        catch (ErrorResponseException e) {
            throw new ErrorResponseException(HttpStatus.I_AM_A_TEAPOT);
        }
    }

}
