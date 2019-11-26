package com.study.cbnu.smart_changing_room.service;

import com.study.cbnu.smart_changing_room.model.Clothes;
import com.study.cbnu.smart_changing_room.model.User;
import com.study.cbnu.smart_changing_room.repository.ClothesRepository;
import com.study.cbnu.smart_changing_room.repository.UserRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {

    private final ClothesRepository clothesRepository;

    private final UserRepository userRepository;

    public ClothesService(ClothesRepository clothesRepository, UserRepository userRepository) {
        this.clothesRepository = clothesRepository;
        this.userRepository = userRepository;
    }

    public Clothes create(Clothes clothes) {

        if(!userRepository.getUser(clothes.getUser_id()).isPresent()){
            return null;
        }

        Long result = clothesRepository.save(clothes);
        return clothes;
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
}
