package com.bootcamp.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.models.BookList;
import com.bootcamp.models.Books;
import com.bootcamp.repositories.BookListRepository;
import com.bootcamp.repositories.BooksRepository;
import com.bootcamp.repositories.UserRepository;


@Controller    
public class MyBookListController {
	
	
	@Autowired
	private BookListRepository bookListRepository;

	
	
	
	@RequestMapping(value="/mybooks", method = RequestMethod.GET)
		public ModelAndView debts(@RequestParam(value="username")String username){
		
			ModelAndView modelAndView = new ModelAndView();
			
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			long time = cal.getTimeInMillis();
			
			List<BookList> bookList = bookListRepository.findByBookStatusAndUsernameIgnoreCase("owned",username);
			
			modelAndView.addObject("booklist", bookList);
			modelAndView.setViewName("mybooks");
			
			

			return modelAndView;
			
	}
	
	@RequestMapping(value={"/givebackthisbook"}, method = RequestMethod.POST)
	public ModelAndView takeBook(@RequestParam(value = "isbn") String isbn){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		System.out.println("giving book with isbn: " + isbn);
		System.out.println("giving book for user: " + username);
		
		bookListRepository.setBookstatusFor("take", isbn, username); //change book status to "owned"
	    
	    System.out.println("Book has been given back");
	    
	    ModelAndView mav = new ModelAndView("redirect:/mybooks");
	    mav.addObject("books", bookListRepository.findByBookStatusIgnoreCase("ordered"));
	    mav.addObject("books1", bookListRepository.findByBookStatusIgnoreCase("take"));
	    mav.setViewName("redirect:/mybooks?username=" + username);
	    
	    
		return mav;	//TODO show message if there isn't book with given isbn number
	}

}