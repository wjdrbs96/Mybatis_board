package com.example.mybatis.controller;

import com.example.mybatis.dto.Member;
import com.example.mybatis.dto.Post;
import com.example.mybatis.mapper.MemberMapper;
import com.example.mybatis.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired PostMapper postMapper;
    @Autowired MemberMapper memberMapper;

    @RequestMapping(value = "post/list", method = RequestMethod.GET)
    public String postMain(Model model,
                           @RequestParam(value = "page", defaultValue = "1") int page,                    // defaultValue : 파라미터 값이 없을 때 default 값
                           @RequestParam(value = "pageSize", defaultValue = "7") int pageSize) {

        // 페이지네이션 포함
        int totalPostCount = postMapper.postAllCount();               // 전체 게시글 수
        int totalCount = totalPostCount / pageSize + 1;            // 총 페이지 수
        page = (page - 1) * pageSize;
        List<Post> postList = postMapper.postFindAll(page, pageSize);

        model.addAttribute("posts", postList);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("page", page);
        model.addAttribute("totalPage", totalCount);
        return "post/postMain";
    }

    @RequestMapping(value = "post/list", method = RequestMethod.POST)
    public String postMain(Model model,
                           @RequestParam("select") String select,
                           @RequestParam("search") String search) {

        model.addAttribute("select", select);

        if (select.equals("title")) {
            List<Post> posts = postMapper.postFindByTitle(search, 0, 7);
            model.addAttribute("posts", posts);
            return "post/postMainTitle";
        }

        List<Post> posts = postMapper.postFindByNickName(search, 0, 7);
        model.addAttribute("posts", posts);
        return "post/postMainNickName";
    }

    @RequestMapping(value = "post/view", method = RequestMethod.GET)
    public String postView(Model model,
                           @RequestParam("postId") int postId) {

        Post post = postMapper.findByPostId(postId);
        post.setCount(post.getCount() + 1);
        postMapper.postUpdate(post);
        model.addAttribute("posts", post);
        return "post/postView";
    }

    @RequestMapping(value = "post/write", method = RequestMethod.GET)
    public String postWrite(Model model, HttpSession session) {
        String loginId = (String)session.getAttribute("userId");
        Member member = memberMapper.findMemberByLoginId(loginId);
        model.addAttribute("member", member);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return "post/writePost";
    }

    @RequestMapping(value = "post/write", method = RequestMethod.POST)
    public String postWrite(@RequestParam("title") String title,
                            @RequestParam("content") String content,
                            @RequestParam("nickname") String nickname,
                            @RequestParam("memberId") int memberId) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Post post = new Post(memberId, title, content, nickname, 1, sdf.format(new Date()));
        postMapper.insertPost(post);

        return "redirect:/post/list";
    }
}
