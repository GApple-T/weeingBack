package com.gapple.weeingback.domain.okay.entity;

import com.gapple.weeingback.domain.member.entity.Member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Builder
@Getter @Setter
public class Okay {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long issuedAt; // 상담 신청 일자

  @Column(nullable = false)
  private Long startAt; // 언제 가야하는지

  @Column(nullable = false)
  private boolean isAccess; // 선생님이 승인했는지

  @Column(nullable = false)
  private boolean isTrue; // 활성화된 Check 인지

  @OneToOne(mappedBy = "okay")
  private Member member;

  public Okay(Long issuedAt, Long startAt){
    this.issuedAt = issuedAt;
    this.startAt = startAt;
  }

  public Okay(){}

  public Okay(Long id, Long issuedAt, Long startAt, boolean isAccess, boolean isTrue, Member member) {
    this.id = id;
    this.issuedAt = issuedAt;
    this.startAt = startAt;
    this.isAccess = isAccess;
    this.isTrue = isTrue;
    this.member = member;
  }
}
