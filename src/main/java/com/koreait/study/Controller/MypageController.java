package com.koreait.study.Controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.koreait.study.mapper.StudyMapper;
import com.koreait.study.mapper.ApplicationMapper;
import com.koreait.study.model.Study;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired private StudyMapper studyMapper;
    @Autowired private ApplicationMapper applicationMapper;

    @GetMapping
    public String mypage(Principal principal, Model model) {
        String userId = principal.getName();
        List<Study> created = studyMapper.findAll("", 0, 1000)
                .stream()
                .filter(s -> s.getAuthor().equals(userId))
                .collect(Collectors.toList());
        List<Study> applied = applicationMapper.findByUserId(userId);
        model.addAttribute("created", created);
        model.addAttribute("applied", applied);
        return "mypage";
    }
}
