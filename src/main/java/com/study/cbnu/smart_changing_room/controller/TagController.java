package com.study.cbnu.smart_changing_room.controller;

import com.study.cbnu.smart_changing_room.model.Tag;
import com.study.cbnu.smart_changing_room.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api/tag")
@CrossOrigin("*")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(path = "list")
    public ResponseEntity getClothesList(Long id){
        List<String> tag_list = tagService.get_list_by_user_id_no_duplication(id);
        return ResponseEntity.ok(tag_list);
    }

    @GetMapping(path = "clothes_tag_list")
    public ResponseEntity get_clothes_tag_list(Long id){
        List<Tag> list_by_clothes_id = tagService.get_list_by_clothes_id(id);
        return ResponseEntity.ok(list_by_clothes_id);
    }
}
