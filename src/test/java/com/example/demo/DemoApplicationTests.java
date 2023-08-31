package com.example.demo;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.News;
import com.example.demo.repository.NewsDao;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private NewsDao newsDao;

	@Test
	public void test() {
		List<News> res = newsDao.findTop5ByIdGreaterThanOrderByDateDesc(0);
//		System.out.println(res);
		for (News item : res) {
			System.out.println(item.getId());
			System.out.println(item.getText());
			System.out.println(item.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		}
	}

}
