package com.book.springboot.web;

import com.book.springboot.domain.room.Room;
import com.book.springboot.domain.room.RoomRepository;
import com.book.springboot.web.dto.room.RoomSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoomControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RoomRepository roomRepository;

    @Test public void Room_등록() throws  Exception {
        //given
        String title = "title";
        String description = "description";
        RoomSaveRequestDto requestDto = RoomSaveRequestDto.builder()
                .title(title)
                .description(description)
                .professor_id(1)
                .build();

        String url = "http://localhost:"+port+"/api/v1/room";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Room> all = roomRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getDescription()).isEqualTo(description);

    };

}
