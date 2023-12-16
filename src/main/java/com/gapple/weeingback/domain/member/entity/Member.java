package com.gapple.weeingback.domain.member.entity;

import com.gapple.weeingback.domain.consulting.entity.Consulting;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table
@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member implements GrantedAuthority {
  @Id
  @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
  @GenericGenerator(name="uuid2", strategy = "uuid2")
  private UUID id;

  @Column(columnDefinition = "VARCHAR(50)", nullable = false)
  private String email;

  @Column(columnDefinition = "VARCHAR(15)")
  private String name;

  @Column(columnDefinition = "INTEGER")
  private Long number;

  @Column(columnDefinition = "VARCHAR(80)", nullable = false)
  private String password;

  @Column(columnDefinition = "VARCHAR(80)", nullable = false)
  private String role;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "consulting_id")
  private List<Consulting> consulting;

  public void addConsulting(Consulting consulting){
    this.consulting.add(consulting);
  }

  @Override
  public String getAuthority() {
    return role;
  }
}
