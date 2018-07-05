package com.example.pixiv.pixiv.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pixiv.pixiv.book.entity.Book;

/**
 * dao
 * @author hutao
 *
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

	List<Book> findByReader(String reader);
	
	List<Book> findByTitle(String title);
}
