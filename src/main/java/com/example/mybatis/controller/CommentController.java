package com.example.mybatis.controller;

import com.example.mybatis.dto.Comment;
import com.example.mybatis.dto.Member;
import com.example.mybatis.dto.Post;
import com.example.mybatis.mapper.CommentMapper;
import com.example.mybatis.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired CommentMapper commentMapper;
    @Autowired MemberMapper memberMapper;

    @RequestMapping(value = "comment/view", method = RequestMethod.POST)
    public String insertAndAllCommentView(Model model,
                                          @RequestParam("postId") int postId,
                                          @RequestParam("content") String content,
                                          HttpSession session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loginId = (String)session.getAttribute("userId");
        Member member = memberMapper.findMemberByLoginId(loginId);
        Comment comment = new Comment(postId, member.getMemberId(), content, sdf.format(new Date()), sdf.format(new Date()));
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

    @RequestMapping(value = "comment/update", method = RequestMethod.GET)
    public String commentUpdate(Model model,
                                @RequestParam("commentId") int commentId) {
        Comment comment = commentMapper.findOneComment(commentId);
        model.addAttribute("comment", comment);
        return "comment/commentUpdate";
    }

    @RequestMapping(value = "comment/update", method = RequestMethod.POST)
    public String commentUpdate(@RequestParam("content") String content,
                                @RequestParam("postId") int postId,
                                @RequestParam("commentId") int commentId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        commentMapper.commentUpdate(content, sdf.format(new Date()), commentId);
        return "redirect:/comment/list?postId=" + postId;
    }
}
