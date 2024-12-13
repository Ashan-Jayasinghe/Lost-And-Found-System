package com.lostandfoundsystem.LAFS.service.implementations;

import com.lostandfoundsystem.LAFS.dto.request.ItemDataSaveDTO;
import com.lostandfoundsystem.LAFS.dto.request.LocationDataSaveDTO;
import com.lostandfoundsystem.LAFS.entity.Item;
import com.lostandfoundsystem.LAFS.entity.LocationDetails;
import com.lostandfoundsystem.LAFS.entity.User;
import com.lostandfoundsystem.LAFS.entity.enums.Category;
import com.lostandfoundsystem.LAFS.entity.enums.ItemStatus;
import com.lostandfoundsystem.LAFS.repository.ItemRepo;
import com.lostandfoundsystem.LAFS.repository.LocationRepo;
import com.lostandfoundsystem.LAFS.repository.UserRepo;
import com.lostandfoundsystem.LAFS.service.interfaces.ItemService;
import com.lostandfoundsystem.LAFS.utility.mappers.ItemMapper;
import com.lostandfoundsystem.LAFS.utility.mappers.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private LocationMapper locationMapper;

    @Override
    @Transactional
    public String addItem(ItemDataSaveDTO itemDataSaveDTO) {
        LocationDetails locationDetails = locationMapper.LocationDTOToLocationEntity(itemDataSaveDTO.getLocationData());
        locationRepo.save(locationDetails);
        if (locationRepo.existsById(locationDetails.getLocationId())) {
            LocationDetails location = locationRepo.getReferenceById(locationDetails.getLocationId());
            User user = new User();
            if(userRepo.existsById(itemDataSaveDTO.getUser())) {
                user= userRepo.getReferenceById(itemDataSaveDTO.getUser());
            }else {
            throw new EmptyResultDataAccessException(1);
            }
            Item item = new Item(
                    itemDataSaveDTO.getItemName(),
                        itemDataSaveDTO.getItemDescription(),
                        itemDataSaveDTO.getCategory(),
                        itemDataSaveDTO.getItemStatus(),
                        itemDataSaveDTO.getReportedDate(),
                        user,
                        location
            );
            itemRepo.save(item);
            // Return success message
            return "Item added successfully with ID: " + item.getItemId();

            } else {
                return "Failed to add item: User not found with ID " + itemDataSaveDTO.getUser();
            }
        }

}
