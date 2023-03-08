package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Library;
import com.example.entity.User;
import com.example.service.LibraryService;
import com.example.service.LogService;
import com.example.service.LoginUser;

@Controller
@RequestMapping("/library")
public class LibraryController{

	private final LibraryService libraryService;
	private final LogService logService;

	@Autowired
	public LibraryController(LibraryService libraryService, LogService logService) {
		this.libraryService = libraryService;
		this.logService = logService;
	}

	@GetMapping
	public String index(Model model, @AuthenticationPrincipal LoginUser loginUser) {
		List<Library> libraries = this.libraryService.findAll();
		User user = loginUser.getUser();
		model.addAttribute("libraries", libraries);
		model.addAttribute("user",user);
		return "library/index";
	}

	@GetMapping("/borrow")
	public String borrowingForm(Model model,@RequestParam Integer id) {
		Optional<Library> library = this.libraryService.findById(id);
		model.addAttribute("library",library.get());
		//System.out.println("borrowing done!!!!!!");
		return "library/borrowingForm";
	}

	@PostMapping("/borrow")
	public String borrow(
			@RequestParam("id") Integer id,
			@RequestParam("return_due_date") String returnDueDate,
			@AuthenticationPrincipal LoginUser loginUser)
	{
		//System.out.println("borrowing done!!!!!!");
		Library library = libraryService.findById(id).get();
		library.setUserId(loginUser.getUser().getId());
		logService.insert(library, returnDueDate);

		return "redirect:/library";
	}

	@PostMapping("/return")
	public String returnBook(@RequestParam("id") Integer libraryId,@AuthenticationPrincipal LoginUser loginUser) {
		Library library = this.libraryService.findById(libraryId).get();
		library.setUserId(0);
		this.libraryService.save(library);
		this.logService.returnUpdate(loginUser.getUser().getId(), libraryId);

		return "redirect:/library";

	}

	@GetMapping("/history")
	public String history(Model model, @AuthenticationPrincipal LoginUser loginUser) {
		Integer userId = loginUser.getUser().getId();
		model.addAttribute("logs", this.logService.findByUserId(userId));
		return "library/borrowHistory";
	}

}