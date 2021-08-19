package com.ou.controller;

import com.ou.pojo.Books;
import com.ou.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    //添加一本书
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>" +books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }


    //查询全部书籍，返回展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list =
                bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }

    @RequestMapping("updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookid}")
    public String deleteBook(@PathVariable("bookid") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryName")
    public String queryBookByName(String queryName,Model model){
        List<Books> list = bookService.queryName(queryName);

        //如果没有查询到，则返回所有书籍
        if(list.size()==0){
            list = bookService.queryAllBook();
            model.addAttribute("error","没有查询到！");
        }
        model.addAttribute("list",list);
        return "allBook";
    }

//    @RequestMapping("login")
//    public String Login(String username, String pwd){
//
//        if ("ou".equals(username) && "123".equals(pwd)) {
//            return "redirect:/book/allBook";
//
//        }else{
//            return "loginfail";
//        }
//    }

}
