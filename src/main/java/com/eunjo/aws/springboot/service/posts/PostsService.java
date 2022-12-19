package com.eunjo.aws.springboot.service.posts;

import com.eunjo.aws.springboot.domain.posts.PostsRepository;
import com.eunjo.aws.springboot.web.dto.PostsSaveRequestDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
