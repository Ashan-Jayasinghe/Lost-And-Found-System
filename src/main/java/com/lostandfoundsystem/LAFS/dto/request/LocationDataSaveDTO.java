package com.lostandfoundsystem.LAFS.dto.request;

import com.lostandfoundsystem.LAFS.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDataSaveDTO {

    private String place;
    private String city;
    private String district;
    private String province;
    private String country;

}
