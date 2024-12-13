package com.lostandfoundsystem.LAFS.entity;

import com.lostandfoundsystem.LAFS.entity.enums.Category;
import com.lostandfoundsystem.LAFS.entity.enums.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "item_id", length = 50 ,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;

    @Column(name = "item_name", length = 255, nullable = false)
    private String itemName;

    @Column(name = "item_description", length = 300, nullable = false)
    private String itemDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "category" , nullable = false, length =100)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_status" , nullable = false, length =100)
    private ItemStatus itemStatus;

    @Column(name = "reported_date", columnDefinition = "DATETIME")
    private Date reportedDate;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id",nullable = false)
    private LocationDetails locationDetails;

    @OneToMany(mappedBy = "lostItem")
    private Set<Match> lostMatches;

    @OneToMany(mappedBy = "foundItem")
    private Set<Match> foundMatches;

    @OneToMany(mappedBy = "item")
    private Set<ItemHistory> itemHistory;

    // One-to-many relationship with ItemImage: An item can have multiple images
    @OneToMany(mappedBy = "item")
    private Set<ItemImage> itemImages;

    @OneToMany(mappedBy = "item")
    private Set<ItemTag> itemTags;

    public Item(String itemName, String itemDescription, Category category, ItemStatus itemStatus, Date reportedDate, User user, LocationDetails locationDetails) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.category = category;
        this.itemStatus = itemStatus;
        this.reportedDate = reportedDate;
        this.user = user;
        this.locationDetails = locationDetails;
    }



}
