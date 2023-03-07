package com.moneylion.assignment.service;

import com.moneylion.assignment.exception.CustomException;
import com.moneylion.assignment.model.UserFeature;
import com.moneylion.assignment.repository.UserFeatureRepository;
import com.moneylion.assignment.util.Constant;
import com.moneylion.assignment.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFeatureService {

    private static final Logger logger = LoggerFactory.getLogger(UserFeatureService.class.getName());

    @Autowired
    private UserFeatureRepository featureRepository;

    public Map saveOrUpdateUserFeature(UserFeature userFeature) throws CustomException {
        logger.info("## Create/Update user feature ##");
        validate(userFeature);
        UserFeature existUserFeature = featureRepository.findUserFeatureByNameAndEmail(userFeature.getFeatureName(), userFeature.getEmail());
        if (existUserFeature != null) {
            existUserFeature.setEnable(userFeature.isEnable());
            featureRepository.save(existUserFeature);
            logger.info("# Update user feature successfully #");
        } else {
            featureRepository.save(userFeature);
            logger.info("# Create user feature successfully #");
        }
        return new HashMap<>();
    }

    private void validate(UserFeature userFeature) throws CustomException {
        if (Utils.isNullOrEmpty(userFeature.getFeatureName())) {
            logger.info("# Feature name must not be null #");
            throw new CustomException(HttpStatus.NOT_MODIFIED.value(), Constant.FEATURE_NAME_NOT_NULL);
        }
        if (Utils.isNullOrEmpty(userFeature.getEmail())) {
            logger.info("# Email must not be null #");
            throw new CustomException(HttpStatus.NOT_MODIFIED.value(), Constant.EMAIL_NOT_NULL);
        }
    }

    public Map hasUserFeatureAccess(String email, String featureName) throws CustomException {
        logger.info("## Check user feature access ##");
        boolean hasAccess = false;
        Map responseMap = new HashMap<>();
        UserFeature userFeature = featureRepository.findUserFeatureByNameAndEmail(featureName, email);
        if (userFeature != null) {
            hasAccess = userFeature.isEnable();
        }
        responseMap.put("canAccess", hasAccess);
        return responseMap;
    }
}
