package com.thomas.bookster.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thomas.bookster.models.Book;
import com.thomas.bookster.models.User;
import com.thomas.bookster.services.BookService;
import com.thomas.bookster.services.UserService;

@Controller
	@RequestMapping("/books")

	public class BookController {
		@Autowired
		private UserService uService;
		@Autowired
		private BookService bService;
		
		
		@GetMapping("")
		public String courses(HttpSession session, Model viewModel) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("books", this.bService.getBooks());
			viewModel.addAttribute("user", this.uService.findOneUser(userId));
			return "books.jsp";
		}
		
		@GetMapping("/new")
		public String newBook(@ModelAttribute("book") Book book, HttpSession session, Model viewModel) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "new.jsp";
		}	
		



		@PostMapping("/new")
		public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model viewModel) {
			if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "new.jsp";
			}
		this.bService.create(book);
		return "redirect:/books";
		}
		
		@GetMapping("{id}")
		public String display(@PathVariable("id") Long id, Model viewModel) {
			viewModel.addAttribute("book", this.bService.findById(id));
			return "edit.jsp";
		}
		@GetMapping("/add/{id}")
		public String addReader(@PathVariable("id") Long id, HttpSession session) {
			Long userId = (Long)session.getAttribute("user_id");
			Book bookAdd = this.bService.findById(id);
			User userToAdd = this.uService.findOneUser(userId);
			System.out.println(userToAdd);
			this.bService.addReader(bookAdd, userToAdd);
			return "redirect:/books";
		}
		
		@GetMapping("/drop/{id}")
		public String removeReader(@PathVariable("id") Long id, HttpSession session) {
			Long userId = (Long)session.getAttribute("user_id");
			Book bookDrop = this.bService.findById(id);
			User userToDrop = this.uService.findOneUser(userId);
			this.bService.removeReader(bookDrop, userToDrop);
			return "redirect:/books";
		}
		
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Book book) {
			this.bService.delete(book);
			return "redirect:/books";
		}
	}


