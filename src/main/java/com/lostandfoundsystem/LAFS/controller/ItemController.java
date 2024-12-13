package com.lostandfoundsystem.LAFS.controller;

import com.lostandfoundsystem.LAFS.dto.request.ItemDataSaveDTO;
import com.lostandfoundsystem.LAFS.repository.ItemRepo;
import com.lostandfoundsystem.LAFS.service.interfaces.ItemService;
import com.lostandfoundsystem.LAFS.utility.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = "/add-lost-item"
    )
    public ResponseEntity<StandardResponse> addItem(
            @RequestBody ItemDataSaveDTO itemDataSaveDTO
    ){
        String message =itemService.addItem(itemDataSaveDTO);
        StandardResponse standardResponse = new StandardResponse(
                200, "success", message
        );
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                standardResponse,
                HttpStatus.CREATED
        );
        return response;

    }
}
