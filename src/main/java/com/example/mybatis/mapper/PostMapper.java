package com.example.mybatis.mapper;

import com.example.mybatis.dto.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    int postAllCount();
    List<Post> postFindAll(@Param("page") int page, @Param("pageSize") int pageSize);
    Post findByPostId(@Param("postId") int postId);
    void postUpdate(Post post);
}
