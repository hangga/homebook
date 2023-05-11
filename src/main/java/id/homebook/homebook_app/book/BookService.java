package id.homebook.homebook_app.book;

import id.homebook.homebook_app.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAll() {
        final List<Book> books = bookRepository.findAll(Sort.by("id"));
        return books.stream()
                .map((book) -> mapToDTO(book, new BookDTO()))
                .toList();
    }

    public BookDTO get(final Long id) {
        return bookRepository.findById(id)
                .map(book -> mapToDTO(book, new BookDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final BookDTO bookDTO) {
        final Book book = new Book();
        mapToEntity(bookDTO, book);
        return bookRepository.save(book).getId();
    }

    public void update(final Long id, final BookDTO bookDTO) {
        final Book book = bookRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(bookDTO, book);
        bookRepository.save(book);
    }

    public void delete(final Long id) {
        bookRepository.deleteById(id);
    }

    private BookDTO mapToDTO(final Book book, final BookDTO bookDTO) {
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setSummary(book.getSummary());
        return bookDTO;
    }

    private Book mapToEntity(final BookDTO bookDTO, final Book book) {
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setSummary(bookDTO.getSummary());
        return book;
    }

}
