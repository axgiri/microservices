package axgiri.github.REST_API_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import axgiri.github.REST_API_library.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
    
}
