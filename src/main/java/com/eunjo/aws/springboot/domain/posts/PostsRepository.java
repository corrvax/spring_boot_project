package com.eunjo.aws.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //JpaRepository<Entity 클래스, PK 타입> -> CRUD 자동 생성
    //Entity & Repository 는 함께 위치해야함


}
