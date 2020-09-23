package com.book.springboot.service.room;

import com.book.springboot.domain.room.Room;
import com.book.springboot.domain.room.RoomRepository;
import com.book.springboot.web.dto.PostsListResponseDto;
import com.book.springboot.web.dto.PostsResponseDto;
import com.book.springboot.web.dto.PostsUpdateRequestDto;
import com.book.springboot.web.dto.room.RoomSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public Long save(RoomSaveRequestDto requestDto){
        return roomRepository.save(requestDto.toEntity()).getId();
    }
/*
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Room room = roomRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        room.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return roomRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostsResponseDto findById (Long id){
        Room entity = roomRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }*/

}
