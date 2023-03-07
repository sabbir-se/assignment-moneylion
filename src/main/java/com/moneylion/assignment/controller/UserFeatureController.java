package com.moneylion.assignment.controller;

import com.moneylion.assignment.exception.CustomException;
import com.moneylion.assignment.model.UserFeature;
import com.moneylion.assignment.service.UserFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/feature")
public class UserFeatureController {

    @Autowired
    private UserFeatureService featureService;

    @PostMapping()
    public ResponseEntity<?> saveOrUpdateUserFeature(@RequestBody UserFeature userFeature) throws CustomException {
        return new ResponseEntity<>(featureService.saveOrUpdateUserFeature(userFeature), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> hasUserFeatureAccess(@RequestParam("email") String email,
                                                  @RequestParam("featureName") String featureName) throws CustomException {
        return new ResponseEntity<>(featureService.hasUserFeatureAccess(email, featureName), HttpStatus.OK);
    }
}
