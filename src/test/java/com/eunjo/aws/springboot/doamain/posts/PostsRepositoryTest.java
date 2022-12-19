package com.eunjo.aws.springboot.doamain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import com.eunjo.aws.springboot.domain.posts.Posts;
import com.eunjo.aws.springboot.domain.posts.PostsRepository;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //Junit 에서 단위 테스트 끝날 때마다 수행되는 메소드 지정
    @After
    public void cleanup(){
        //여러 테스트를 동시에 수행하면 H2에 데이터가 그대로 남아 다음 테스트가 실패할 수 있어 지움
        postsRepository.deleteAll();
    }

    @Test
    public void loadBoard(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
            .title(title)
            .content(content)
            .author("eunjoying27@gmail.com")
            .build());

        //when
        //findAll() -> 테이블 posts 에 있는 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
