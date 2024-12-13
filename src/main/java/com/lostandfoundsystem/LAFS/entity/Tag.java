package com.lostandfoundsystem.LAFS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tag {
    @Id
    @Column(name = "tag_id", length = 50, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tagId;

    @Column(name = "tag_name",nullable = false)
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private Set<ItemTag> itemTags;

}
