package com.productapp.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.productapp.demo.dao.BookDao;
@ExtendWith(MockitoExtension.class)//tell junit to integrate with mockito
class BookServiceImplTest {

	@Mock
	private BookDao bookDao;
	
	@InjectMocks
	private BookServiceImpl bookService;
	
	@BeforeEach
	void setUp() throws Exception {
		when(bookDao.getBooks())
		.thenReturn(List.of("java","effective java","think and grow rich"));
	}

	@Test
	void testJavaBooks() {
		System.out.println(bookDao.getClass());
		Assertions.assertEquals(2, bookService.getBooks("java").size());
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}


}
