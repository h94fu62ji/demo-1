package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.News;

@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

	public List<News> findTop5ByIdGreaterThanOrderByDateDesc(int id);
}
