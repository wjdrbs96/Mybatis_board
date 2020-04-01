package com.example.mybatis.controller;

import com.example.mybatis.dto.Post;
import com.example.mybatis.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {

    @Autowired PostMapper postMapper;
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
}
