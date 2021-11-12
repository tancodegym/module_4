package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    IBlogService iBlogService;

    //Xem danh sách blog
    @GetMapping("/blog")
    public List<Blog> getListBlog() {
        List<Blog> blogList = iBlogService.findAll();
        return blogList;
    }

    //Xem chi tiết 1 blog
    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<?> getDetailBlog(@PathVariable("id") Long id) {
        Blog blog = iBlogService.findById(id).get();
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //Xem danh sách các bài viết của 1 category
    @GetMapping("/blog/findByCategory/{idCategory}")
    public ResponseEntity<?> getListBlogByCategoryId(@PathVariable("idCategory") Long id) {
        List<Blog> bloglist = iBlogService.findByIdCategory(id);
        if (bloglist.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bloglist, HttpStatus.OK);
    }

    //Thêm mới 1 blog
    @PostMapping("/blog/create")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        iBlogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    //Update 1 blog
    @PatchMapping("/blog/update")
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        iBlogService.update(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete Blog
    @DeleteMapping("/blog/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
    //phân trang bằng web service
    //page: số trang hiện tại
    // size: số record trả về
    //PageRequest.of() trả về 1 đối tượng Pageable
    @GetMapping("/blog/getPage") // /blog/getPage?page=0&size=1
    public ResponseEntity<Page<Blog>> getPage( @RequestParam int page,int size
                                              ) {
        Page<Blog> blogList = iBlogService.findAll(PageRequest.of(page,size)); // Pageable pageable
        return   new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    //tìm kiếm bằng web service
    @GetMapping("/blog/search/{idCategory}/{title}/{page}/{size}")
    public ResponseEntity<Page<Blog>> search(@PathVariable("idCategory") String id,
                                             @PathVariable("title") String title,
                                             @PathVariable("page") int page,
                                             @PathVariable("size") int size){
        Page<Blog> blogList = iBlogService.findAll(PageRequest.of(page,size),title,id);
        if (blogList.getSize()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return   new ResponseEntity<>(blogList, HttpStatus.OK);

    }
}
