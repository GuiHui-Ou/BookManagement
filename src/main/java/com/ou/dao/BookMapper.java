package com.ou.dao;

import com.ou.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //add a book
    int addBook(Books books);

    //delete a book
    int deleteBookById(@Param("bookID") int id);

    //update a book
    int updateBook(Books books);

    //search a book
    Books queryBookById(@Param("bookID") int id);

    //search books
    List<Books> queryAllBook();

    List<Books> queryName(@Param("Name")String bookName);
}
