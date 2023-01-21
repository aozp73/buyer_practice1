package shop.mtcoding.buyer3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer3.dto.PurchaseAllDto;
import shop.mtcoding.buyer3.model.Purchase;
import shop.mtcoding.buyer3.model.PurchaseRepository;
import shop.mtcoding.buyer3.model.User;
import shop.mtcoding.buyer3.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    HttpSession session;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @PostMapping("/purchase/insert")
    public String insert(int productId, int count) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        int res = purchaseService.구매하기(principal.getId(), productId, count);
        if (res == -1) {
            return "redirect:/notfound";
        }

        return "redirect:/";
    }

    @GetMapping("/purchase")
    public String purchase(Model model) {
        User principal = (User) session.getAttribute("principal");

        if (principal == null) {
            return "redirect:/notfound";
        } else {
            List<PurchaseAllDto> purchaseList = purchaseRepository.findByUserId(principal.getId());
            model.addAttribute("purchaseList", purchaseList);
            return "purchase/list";
        }

    }
}
