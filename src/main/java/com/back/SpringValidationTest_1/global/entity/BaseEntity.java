package com.back.SpringValidationTest_1.global.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreatedDate
    @Getter(AccessLevel.PRIVATE)
    private LocalDateTime createDate;
    @LastModifiedDate
    @Getter(AccessLevel.PROTECTED)
    private LocalDateTime modifyDate;
}
