package com.koreait.study.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import com.koreait.study.mapper.StudyMapper;
import com.koreait.study.mapper.ApplicationMapper;
import com.koreait.study.model.Study;

@Controller
@RequestMapping("/studies")
public class StudyController {

    @Autowired private StudyMapper studyMapper;
    @Autowired private ApplicationMapper applicationMapper;

    @GetMapping
    public String list(@RequestParam(defaultValue="") String search,
                       @RequestParam(defaultValue="0") int page,
                       Model model) {
        int size = 10;
        int offset = page * size;
        List<Study> list = studyMapper.findAll(search, offset, size);
        model.addAttribute("studies", list);
        model.addAttribute("search", search);
        model.addAttribute("page", page);
        return "study_list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("study", new Study());
        return "study_form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Study study, Principal principal) {
        study.setAuthor(principal.getName());
        studyMapper.insert(study);
        return "redirect:/studies";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model	model,
                         @ModelAttribute("msg") String msg) {
        Study study = studyMapper.findById(id);
        model.addAttribute("study", study);
        return "study_detail";
    }

    @PostMapping("/{id}/apply")
    public String apply(@PathVariable int id, Principal principal,
                        RedirectAttributes ra) {
        String userId = principal.getName();
        Study study = studyMapper.findById(id);
        if (applicationMapper.exists(userId, id) > 0) {
            ra.addFlashAttribute("msg", "이미 신청했습니다.");
        } else if (study.getCurrentMembers() >= study.getMaxMembers()) {
            ra.addFlashAttribute("msg", "정원이 초과되었습니다.");
        } else {
            applicationMapper.insert(userId, id);
            ra.addFlashAttribute("msg", "신청 완료");
        }
        return "redirect:/studies/" + id;
    }
}
