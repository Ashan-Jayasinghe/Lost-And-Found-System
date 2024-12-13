package com.lostandfoundsystem.LAFS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item_image")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemImage {
    @Id
    @Column(name="image_id", nullable = false, length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long imageId;

    @Column(name = "image_url", nullable = false,length = 300)
    private String imageUrl;

    @Column(name="upload_date", columnDefinition = "DATETIME")
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;


}
