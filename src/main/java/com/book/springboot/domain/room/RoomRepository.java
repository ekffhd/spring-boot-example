package com.book.springboot.domain.room;
import com.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {
        @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
        List<Posts> findAllDesc();
}
