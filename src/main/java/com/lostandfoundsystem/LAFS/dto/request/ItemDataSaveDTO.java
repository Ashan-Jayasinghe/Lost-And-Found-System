package com.lostandfoundsystem.LAFS.dto.request;

import com.lostandfoundsystem.LAFS.entity.*;
import com.lostandfoundsystem.LAFS.entity.enums.Category;
import com.lostandfoundsystem.LAFS.entity.enums.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDataSaveDTO {
    private String itemName;
    private String itemDescription;
    private Category category;
    private ItemStatus itemStatus;
    private Date reportedDate;
    private LocationDataSaveDTO locationData;
    private long user;
}
