package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.News;
import com.example.demo.repository.NewsDao;
import com.example.demo.service.impl.NewsServiceImpl;

@Controller
public class NewsController {

	@Autowired
	private NewsServiceImpl newsServiceImpl;
	@Autowired
	private NewsDao newsDao;

	@GetMapping("/news") // 對應的網址
	public String news(Model model) {
		List<News> newss = newsServiceImpl.getMesg();
		model.addAttribute("news", newss); // （變數名稱，變數值)
		List<News> news = new ArrayList<News>(newss);
		for (News item : news) {
			if (item.getText().length() > 20) {
				item.setText(item.getText().substring(0, 20) + "...");
			}
			if (item.getTitle().length() > 6) {
				item.setTitle(item.getTitle().substring(0, 6));
			}
		}
		model.addAttribute("News", news); // （變數名稱，變數值)
		return "news";
	}

	@PostMapping("/process")
	public String processValue(int id, Model model) {
		Optional<News> newss = newsDao.findById(id);
		News news = newss.get();
		model.addAttribute("result", news);
		return "result";
	}

}