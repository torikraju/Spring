package org.torikraju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.torikraju.domain.UserInfo;
import org.torikraju.repository.UserInfoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/user-list")
    public String getUserList(@PageableDefault(sort = "id") Pageable pageable, Model model) {

        Page<UserInfo> page = userInfoRepository.findAll(pageable);
        List<Sort.Order> sortOrders = page.getSort().stream().collect(Collectors.toList());

        if (sortOrders.size() > 0) {
            Sort.Order order = sortOrders.get(0);
            model.addAttribute("sortProperty", order.getProperty());
            model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
        }
        
        model.addAttribute("page", page);
        return "user-list";
    }


}
