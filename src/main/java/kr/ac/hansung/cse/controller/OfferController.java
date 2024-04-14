package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OfferController {

    //Controller -> Service -> Dao
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers(); // OfferService를 통해 모든 교과목 정보를 가져옵니다.
        model.addAttribute("id_offers", offers);

        return "offers";
    }

    @GetMapping("/createoffer")
    public String createOffer(Model model) {

        model.addAttribute("offer", new Offer()); // 모델에 offer 속성을 추가하여 새로운 Offer 객체를 전달합니다.

        return "createoffer";
    }

    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

        // System.out.println(offer);

        if(result.hasErrors()) { // 만약 입력 데이터에 유효성 검사 오류가 있다면
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors(); // 모든 오류를 가져와서 처리합니다.

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer";
        }

        // Controller -> Service -> Dao
        offerService.insert(offer); // Service를 통해 새 교과목을 삽입합니다.

        return "home";
    }
}
