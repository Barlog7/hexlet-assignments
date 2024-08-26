package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var authors = bookRepository.findAll();
        var result = authors.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO create(BookCreateDTO data) {
        var book = bookMapper.map(data);
        bookRepository.save(book);
        var bookDto = bookMapper.map(book);
        return bookDto;
    }

    public BookDTO findById(Long id) {
        var author =  bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        var bookDto = bookMapper.map(author);
        return bookDto;
    }

    public BookDTO update(BookUpdateDTO data, Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        bookMapper.update(data, book);
        bookRepository.save(book);
        var bookDto = bookMapper.map(book);
        return bookDto;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
