package com.unis.common.repository;

import com.unis.common.domain.ApplySetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplySettingRepository extends JpaRepository<ApplySetting, Integer> {
}
