package com.lostandfoundsystem.LAFS.entity;

import com.lostandfoundsystem.LAFS.entity.enums.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matches")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {
    @Id
    @Column(name = "match_id", nullable = false, length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long matchId;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_status" , nullable = false, length =100)
    private MatchStatus matchStaus;

    @Column(name = "match_date", columnDefinition = "DATETIME")
    private Date matchDate;

    @ManyToOne
    @JoinColumn(name = "lost_item_id", referencedColumnName = "item_id")
    private Item lostItem;

    @ManyToOne
    @JoinColumn(name = "found_item_id", referencedColumnName = "item_id")
    private Item foundItem;
}
