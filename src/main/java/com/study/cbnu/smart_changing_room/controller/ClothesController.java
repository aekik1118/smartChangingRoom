package com.study.cbnu.smart_changing_room.controller;

import com.study.cbnu.smart_changing_room.model.Clothes;
import com.study.cbnu.smart_changing_room.model.ClothesDTO;
import com.study.cbnu.smart_changing_room.model.Tag;
import com.study.cbnu.smart_changing_room.service.ClothesService;
import com.study.cbnu.smart_changing_room.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/clothes")
@CrossOrigin("*")
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

    @GetMapping(path = "list")
    public ResponseEntity getClothesList(Long id){
        List<Clothes> clothes_list = clothesService.get_clothes_list(id);
        return ResponseEntity.ok(clothes_list);
    }

    @GetMapping(path = "listWithTag")
    public ResponseEntity getClothesListWithTag(Long id, String tag){
        List<Clothes> clothes_list = clothesService.get_clothes_list_with_tag(id, tag);
        return ResponseEntity.ok(clothes_list);
    }

    @GetMapping
    public ResponseEntity getClothes(Long id){
        Optional<Clothes> clothes = clothesService.getClothes(id);
        if(clothes.isPresent()){
            return ResponseEntity.ok(clothes);
        }
        return ResponseEntity.notFound().build();
    }

}
