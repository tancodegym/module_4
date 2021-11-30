package com.example.demo.controller;

import com.example.demo.dto.TradeDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Trade;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ITradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/trade")
public class TradeController {
    @Autowired
    ICustomerService iCustomerService;
    @ModelAttribute("customerList")
    public List<Customer> getCustomerList(){
        return   iCustomerService.findAll();
    }
    @Autowired
    ITradeService iTradeService;

    @GetMapping(value={"","/search"})
    public String showList(Pageable pageable,
                           @RequestParam(value="customerName",defaultValue = "",required = false) String customerName,
                           @RequestParam(value="type",defaultValue = "",required = false) String type,
                           Model model){
        Page<Trade> tradeList =  iTradeService.searchAll(pageable,customerName,type);
        model.addAttribute("tradeList",tradeList);
        return "list";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        TradeDTO tradeDTO =new TradeDTO();
        model.addAttribute("tradeDTO", tradeDTO);
        return "/create";

    }

    @PostMapping("/save")
    public String saveTrade(@ModelAttribute @Validated TradeDTO tradeDTO,
                               BindingResult bindingResult,
                               Model model) {
        List<Trade> tradeList = iTradeService.findAll();
        tradeDTO.setTradeList(tradeList);
        new TradeDTO().validate(tradeDTO,bindingResult);

        if (!bindingResult.hasFieldErrors()) {
            Trade trade = new Trade();
            BeanUtils.copyProperties(tradeDTO, trade);
            iTradeService.save(trade);
            model.addAttribute("success", "Thêm giao dịch thành công!");
        }
        return "/create";

    }
    @GetMapping("/detail/{id}")
    public String showDetail (@PathVariable("id") Long id,Model model){
        Trade trade = iTradeService.findById(id);
        model.addAttribute("trade", trade);
        return "/detail";

    }
    @GetMapping("/delete")
    public String delTrade(@RequestParam(value="idDel") Long id,Model model,Pageable pageable){
        iTradeService.delete(id);
        String customerName = "";
        String type ="";
        Page<Trade> tradeList =  iTradeService.searchAll(pageable,customerName,type);
        model.addAttribute("tradeList",tradeList);
        model.addAttribute("success", "Xóa giao dịch thành công!");
        return "list";
    }

}
