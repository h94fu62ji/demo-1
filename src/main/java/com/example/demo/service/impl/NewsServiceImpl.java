package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.News;
import com.example.demo.repository.NewsDao;
import com.example.demo.service.ifs.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Override
	public List<News> getMesg() {
		List<News> res = newsDao.findTop5ByIdGreaterThanOrderByDateDesc(0);
		return res;
	}

}
