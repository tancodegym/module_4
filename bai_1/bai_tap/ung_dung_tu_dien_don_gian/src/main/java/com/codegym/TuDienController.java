package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class TuDienController {
    @RequestMapping("/translate")
    public String showResult(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String> dictonary = new HashMap<>();
        dictonary.put("hello", "Xin chào ");
        dictonary.put("how", "Như thế nào  ");
        dictonary.put("who", "Ai");
        dictonary.put("friend", "Bạn");
        dictonary.put("what", "Cái gì");
        String word = request.getParameter("word");
        String result = word + " Not found in my dictionary !";
        for (String key : dictonary.keySet()) {
            if (word.equals(key)) {
                result = dictonary.get(key);
                break;
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("word", word);

        return "result";

    }
}
