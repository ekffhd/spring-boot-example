package com.book.springboot.web.dto.room;

import com.book.springboot.domain.room.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomSaveRequestDto {
    private String title;
    private String description;
    private int professor_id;

    @Builder
    public RoomSaveRequestDto(String title, String description, int professor_id){
        this.title = title;
        this.description = description;
        this.professor_id = professor_id;
    }


    public Room toEntity(){
        return Room.builder()
                .title(title)
                .description(description)
                .professor_id(professor_id)
                .build();
    }


}
