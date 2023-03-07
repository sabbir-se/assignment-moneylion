package com.moneylion.assignment.repository;

import com.moneylion.assignment.model.UserFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserFeatureRepository extends JpaRepository<UserFeature, Long> {

    @Query(value = "SELECT * FROM user_feature WHERE feature_name=?1 AND email=?2", nativeQuery = true)
    UserFeature findUserFeatureByNameAndEmail(String name, String email);
}
