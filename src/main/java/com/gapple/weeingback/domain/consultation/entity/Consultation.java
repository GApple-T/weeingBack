package com.gapple.weeingback.domain.consultation.entity;

import com.gapple.weeingback.domain.member.entity.Member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
public class Consultation {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long issuedAt; // 상담 신청 일자

  @Column(nullable = false)
  private Long startAt; // 언제 가야하는지

  @Column(nullable = false)
  private boolean isAccess; // 선생님이 승인했는지

  public Consultation(Long issuedAt, Long startAt){
    this.issuedAt = issuedAt;
    this.startAt = startAt;
  }

  public Consultation(){}
}
