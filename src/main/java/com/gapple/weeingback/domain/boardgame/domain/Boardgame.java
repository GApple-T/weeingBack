package com.gapple.weeingback.domain.boardgame.domain;

import com.gapple.weeingback.domain.member.entity.Member;
import com.gapple.weeingback.domain.member.entity.NumberNameWithId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table
@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boardgame {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    private Member creator;

    @Column(nullable = false)
    private Long maxOf;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Member> members;

    public ToBoardgameDto toDto(Boardgame boardgame){
        List<NumberNameWithId> players = new ArrayList<>();
        boardgame.getMembers().forEach(member ->
            players.add(new NumberNameWithId(
                    member.getGrade(),
                    member.getClassroom(),
                    member.getNumber(),
                    member.getName(),
                    member.getId().toString()
            ))
        );

        return new ToBoardgameDto(
                boardgame.getId().toString(),
                boardgame.getMaxOf(),
                new NumberNameWithId(
                        creator.getGrade(),
                        creator.getClassroom(),
                        creator.getNumber(),
                        creator.getName(),
                        creator.getId().toString()
                ),
                players);
    }

    public void addMember(Member member){
        members.add(member);
    }
}
