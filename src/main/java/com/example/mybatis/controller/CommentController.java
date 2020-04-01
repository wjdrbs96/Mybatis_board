package com.example.mybatis.controller;

import com.example.mybatis.dto.Comment;
import com.example.mybatis.dto.Post;
import com.example.mybatis.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired CommentMapper commentMapper;

    @RequestMapping(value = "comment/view", method = RequestMethod.GET)
    public String insertAndAllCommentView(Model model,
                                          @RequestParam("postId") int postId,
                                          @RequestParam("content") String content) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Comment comment = new Comment(postId, content, sdf.format(new Date()));
        commentMapper.commentInsert(comment);
        List<Comment> list = commentMapper.findAllComment(postId);
        model.addAttribute("postId", postId);
        model.addAttribute("list", list);
        return "comment/commentView";
    }

    @RequestMapping(value = "comment/list", method = RequestMethod.GET)
    public String commentAllList(Model model,
                                 @RequestParam("postId") int postId) {
        List<Comment> list = commentMapper.findAllComment(postId);
        model.addAttribute("postId", postId);
        model.addAttribute("list", list);
        return "comment/commentView";
    }

    @RequestMapping(value = "comment/delete", method = RequestMethod.GET)
    public String commentDelete(@RequestParam("commentId") int commentId) {
        Comment comment = commentMapper.findOneComment(commentId);
        commentMapper.commentDelete(commentId);
        return "redirect:/comment/list?postId=" + comment.getPostId();
    }
}
