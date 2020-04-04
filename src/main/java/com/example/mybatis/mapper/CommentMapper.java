package com.example.mybatis.mapper;

import com.example.mybatis.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void commentInsert(Comment comment);
    List<Comment> findAllComment(int postId);
    void postCommentAllDelete(int postId);
    void commentDelete(int commentId);
    Comment findOneComment(int commentId);
    void commentUpdate(String content, String updateTime, int commentId);
}
