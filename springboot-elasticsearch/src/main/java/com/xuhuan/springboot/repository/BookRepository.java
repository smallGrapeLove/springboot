package com.xuhuan.springboot.repository;

import com.xuhuan.springboot.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author huan.xu
 * @Time 2019-05-08 22:10
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    public List<Book> findByBookName(String bookName);

}
