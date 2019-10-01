package tutorial.spring5.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tutorial.spring5.spring5webapp.model.Author;
import tutorial.spring5.spring5webapp.model.Book;
import tutorial.spring5.spring5webapp.repositories.AuthorRepository;
import tutorial.spring5.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author brandon = new Author("Brandon", "Sanderson");
        Book theFinalEmpire = new Book("The Final Empire", "1234", "Harper Collins");
        brandon.getBooks().add(theFinalEmpire);
        theFinalEmpire.getAuthors().add(brandon);
        authorRepository.save(brandon);
        bookRepository.save(theFinalEmpire);


        Author leigh = new Author("Leigh", "Bardugo");
        Book sixOfCrows = new Book("Six Of Crows", "2345", "Worx");
        leigh.getBooks().add(sixOfCrows);
        authorRepository.save(leigh);
        bookRepository.save(sixOfCrows);
    }
}
