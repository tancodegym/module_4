package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Student;
import com.codegym.service.IBookService;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IStudentService iStudentService;

    @ModelAttribute("studentList")
    public Iterable<Student> findAllStudent() {
        return iStudentService.findAll();

    }

    @ModelAttribute("bookList")
    public Iterable<Book> findAllB() {
        return iBookService.findAll();

    }

    @GetMapping("")
    public String showList(Model model) {
        return "/book/list";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrowPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("bookFound", iBookService.findById(id));
        Random rand = new Random();
        int ranNum = rand.nextInt(100000) + 1;
        String code = "" + ranNum;
        model.addAttribute("code", code);
        return "/book/borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam("code") String code
            , Model model, @ModelAttribute("book") Book book) {
        String outOfBook = "";
        if (book.getQuantity() == 0) {
            outOfBook = "Library not enough book for borrow !";
            model.addAttribute("outOfBook", outOfBook);
            return "/book/list";
        }
        iStudentService.save(new Student(""+book.getId(), code));
        int quantity = book.getQuantity();
        book.setQuantity(quantity - 1);
        iBookService.update(book);
//        model.addAttribute("outOfBook",outOfBook);
        return "/book/list";
    }

    @GetMapping("/pay/{id}")
    public String showPayPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("bookPay", iBookService.findById(id));
        return "/book/pay";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam("codePay") String code
            , Model model, @ModelAttribute("bookPay") Book book) {
        List<Student> studentList = iStudentService.findAll();
        boolean flag = false;

        String bookId = ""+book.getId();
        for (Student student : studentList) {
            if ((bookId.equals(student.getIdBook())) && (student.getCode().equals(code))) {
                flag = true;
                iStudentService.remove(student.getId());
                break;
            }
        }
        if (flag) {
            int quantity=book.getQuantity();
            book.setQuantity(quantity+1);
            iBookService.update(book);
            model.addAttribute("success", "Pay Successfully !");
            return "/book/list";
        }
        model.addAttribute("errorCode", "Code Pay Wrong !");
        return "/book/pay";
    }
}
