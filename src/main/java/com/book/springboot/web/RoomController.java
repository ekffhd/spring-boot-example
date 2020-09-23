package com.book.springboot.web;

import com.book.springboot.service.room.RoomService;
import com.book.springboot.web.dto.room.RoomSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/api/v1/room")
    public Long save(@RequestBody RoomSaveRequestDto requestDto){
        return roomService.save(requestDto);
    }
    /*/
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return roomService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
    */
}
