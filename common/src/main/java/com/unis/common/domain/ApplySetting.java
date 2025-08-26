package com.unis.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "apply_setting")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplySetting {

    @Id
    @Column(name = "apply_id")
    private Integer applyId = 1;  // 항상 1

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = false;

    @Column(name = "apply_url", nullable = true)
    private String applyUrl;
}
