package com.lostandfoundsystem.LAFS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item_tag")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemTag {
    @Id
    @Column(name = "item_tag_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemTagId;

    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false,referencedColumnName = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id", nullable = false)
    private Tag tag;

    @Column(name = "date_assigned",columnDefinition = "DATETIME")
    private Date dateAssigned;
}
