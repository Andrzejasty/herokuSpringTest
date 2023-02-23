package com.andrzej_szpit.spring_first_project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.andrzej_szpit.spring_first_project.data.BooksRepository;
import com.andrzej_szpit.spring_first_project.models.Book;
import com.bugsnag.Bugsnag;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


@Controller
@RequestMapping("/books")
public class BooksController{
    @Autowired
    private BooksRepository booksData;
    Bugsnag bugsnag = new Bugsnag("becf737121d92acf64d1d69f00506005");
    
    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public ModelAndView addNewBook(){
        Book book = new Book();
        return new ModelAndView("newBook", "form", book);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView books(){
        List<Book> allBooks = booksData.findAll();
        Client client = ClientBuilder.newClient();
    Response response = client.target("https://webtopdf.expeditedaddons.com/?api_key=D341A50899MX6Z5THINEV2207ORGB7K3LQWCY18U6P4FJS&content=http://www.wikipedia.org&margin=10&html_width=1024&title=My PDF Title")
    .request(MediaType.TEXT_PLAIN_TYPE)
    .get();

    System.out.println("status: " + response.getStatus());
    System.out.println("headers: " + response.getHeaders());
    System.out.println("body:" + response.readEntity(String.class));

        return new ModelAndView("allBooks", "books", allBooks);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable long id){
        Optional<Book> book = booksData.findById(id);
        if(book!=null)
        {
            booksData.delete(book.get());
        }
        return ("redirect:/books/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable long id){
        
        Optional<Book> book = booksData.findById(id);
        if(book!=null)
        {
            return new ModelAndView("editBook", "form", book.get());
        }
        else
        {
            return books();
        }        
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        if(book!=null)
        {
            booksData.save(book);
        }
        return ("redirect:/books/list");
    }
}

    