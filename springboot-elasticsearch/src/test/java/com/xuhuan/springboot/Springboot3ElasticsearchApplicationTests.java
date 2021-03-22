package com.xuhuan.springboot;

import com.xuhuan.springboot.bean.Article;
import com.xuhuan.springboot.bean.Book;
import com.xuhuan.springboot.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot3ElasticsearchApplicationTests {

	@Autowired
	JestClient jestClient;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void test2(){
		Book book=new Book();
		book.setId(1);
		book.setAuthor("zs");
		book.setBookName("book1");
		bookRepository.index(book);
	}

	@Test
	public void contextLoads() {
		Article article=new Article();
		article.setId(1);
		article.setAuthor("zs");
		article.setTitle("hello");
		article.setContent("I'm content");

		Index index = new Index.Builder(article).index("db").type("table").build();

		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void search(){
		String json="";
		Search search = new Search.Builder(json).addIndex("db").addType("table").build();
		try {
			SearchResult searchResult = jestClient.execute(search);
			System.out.println(searchResult.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
