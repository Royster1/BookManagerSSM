package book.manager.controller.api;

import book.manager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/admin")
public class AdminApiController {

    @Resource
    BookService service;

    @RequestMapping(value = "/del-book", method = RequestMethod.GET)
    public String deleteBook(@RequestParam("id") int id) {
        service.deleteBook(id);
        return "redirect:/page/admin/book";
    }

    // 添加书籍
    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("desc") String desc,
                          @RequestParam("price") double price) {
        service.addBook(title, desc, price);
        return "redirect:/page/admin/book";
    }
}
