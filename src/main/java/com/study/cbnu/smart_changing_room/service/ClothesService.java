package com.study.cbnu.smart_changing_room.service;

import com.study.cbnu.smart_changing_room.model.Clothes;
import com.study.cbnu.smart_changing_room.model.ClothesDTO;
import com.study.cbnu.smart_changing_room.model.Tag;
import com.study.cbnu.smart_changing_room.model.User;
import com.study.cbnu.smart_changing_room.repository.ClothesRepository;
import com.study.cbnu.smart_changing_room.repository.TagRepository;
import com.study.cbnu.smart_changing_room.repository.UserRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {

    private final ClothesRepository clothesRepository;

    private final UserRepository userRepository;

    private final TagRepository tagRepository;

    public ClothesService(ClothesRepository clothesRepository, UserRepository userRepository, TagRepository tagRepository) {
        this.clothesRepository = clothesRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    public Clothes create(Clothes clothes) {

        if(!userRepository.getUser(clothes.getUser_id()).isPresent()){
            return null;
        }

        Long result = clothesRepository.save(clothes);
        return clothes;
    }

    public Clothes create(ClothesDTO clothesDTO) {
        Clothes clothes = new Clothes(clothesDTO);

        Clothes created_clothes = create(clothes);

        clothesDTO.getTag_list().forEach(e->{
            Tag tag = Tag.builder()
                    .clothes_id(created_clothes.getId())
                    .category(e)
                    .build();
            tagRepository.save(tag);
        });
        return created_clothes;
    }

    public Optional<Clothes> getClothes(Long id) {
        return clothesRepository.get_clothes(id);
    }

    public Clothes updateClothes(Clothes clothes) {
        Long result = clothesRepository.update(clothes);
        return clothes;
    }

    public void delete(Long id) {
        clothesRepository.delete(id);
    }

    public List<Clothes> get_clothes_list(Long id) {
        return clothesRepository.get_clothes_list(id);
    }



    //최근 사용날짜 갱신 작업
}
