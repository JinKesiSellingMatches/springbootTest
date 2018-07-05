package com.example.pixiv.pixiv.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pixiv.pixiv.book.dao.ReadingListRepository;
import com.example.pixiv.pixiv.book.entity.Book;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {
	
	@Autowired
	private ReadingListRepository readingListRepository;
	
	@RequestMapping(value="/{reader}",method=RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader,Model model){
		
		List<Book> readingList=readingListRepository.findByReader(reader);
		List<Book> readingTitle=readingListRepository.findByTitle(reader);
		if (readingList!=null) {
			model.addAttribute("book",readingList);
		}
		return "readingList123";
	}
	
	@RequestMapping(value="/{reader}",method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader,Book book){
		
		book.setReader(reader);
		readingListRepository.save(book);
		return null;
	}
	

}
