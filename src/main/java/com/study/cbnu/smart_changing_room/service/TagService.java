package com.study.cbnu.smart_changing_room.service;

import com.study.cbnu.smart_changing_room.model.Tag;
import com.study.cbnu.smart_changing_room.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag create(Tag test_tag) {
        Long result = tagRepository.save(test_tag);
        return test_tag;
    }

    public Optional<Tag> get_tag(Long id) {
        return tagRepository.get_tag(id);
    }

    public void delete(Long id) {
        tagRepository.delete(id);
    }

    public List<Tag> get_list_by_clothes_id(long id) {
        return tagRepository.select_by_clothes_id(id);
    }

    public List<String> get_list_by_user_id_no_duplication(long id) {
        return tagRepository.select_by_user_id_no_duplication(id);
    }
}
