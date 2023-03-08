package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.form.SampleForm;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	 @GetMapping("/index")
	 //@ResponseBody
	 public String index(Model model) {
		 String text = "hello spring boot";
		 model.addAttribute("message",text);
		 return "index";
	 }

	 @GetMapping("/request_test")
	 @ResponseBody
	 public String getTest(@RequestParam("name") String name,
			 @RequestParam("bloodType") String blood_Type)
	 {
		 return "名前" + name + "<br>血液型" + blood_Type;
	 }

	 @PostMapping("/request_test")
	 @ResponseBody
	 public String postTest(SampleForm sampleForm) {
		 return "名前: " + sampleForm.getName() + "<br>血液型: " + sampleForm.getBloodType();
	 }

	 @GetMapping("/form_test")
	 public String formTest(SampleForm sampleForm, Model model) {
		 model.addAttribute("sampleForm",sampleForm);
		 return "form_test";
	 }



}
