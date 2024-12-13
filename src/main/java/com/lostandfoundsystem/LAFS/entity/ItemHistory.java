package com.lostandfoundsystem.LAFS.entity;

import com.lostandfoundsystem.LAFS.entity.enums.ItemHistoryStatus;
import com.lostandfoundsystem.LAFS.entity.enums.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "itemHistory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemHistory {
    @Id
    @Column(name = "item_history_id", nullable = false, length = 50)
    private long itemHistoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_history_status" , nullable = false, length =100)
    private ItemHistoryStatus itemHistoryStatus;

    @Column(name = "change_date", columnDefinition = "DATETIME",nullable = false)
    private Date changeDate;

    @Column(name = "notes")
    private String notes ;

    @ManyToOne
    @JoinColumn(name = "item_id" , referencedColumnName = "item_id")
    private Item item;



}
