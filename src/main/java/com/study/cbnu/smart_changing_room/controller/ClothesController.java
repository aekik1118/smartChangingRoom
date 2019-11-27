package com.study.cbnu.smart_changing_room.controller;

import com.study.cbnu.smart_changing_room.model.Clothes;
import com.study.cbnu.smart_changing_room.model.ClothesDTO;
import com.study.cbnu.smart_changing_room.model.Tag;
import com.study.cbnu.smart_changing_room.service.ClothesService;
import com.study.cbnu.smart_changing_room.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    private final TagService tagService;

    public ClothesController(ClothesService clothesService, TagService tagService) {
        this.clothesService = clothesService;
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity createClothes(@RequestBody ClothesDTO clothesDTO){

        try {
            Clothes clothes = clothesService.create(clothesDTO);
            return ResponseEntity.ok(clothes);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.toString());
        }


    }

}
