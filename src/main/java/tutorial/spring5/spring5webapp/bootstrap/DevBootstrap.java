package tutorial.spring5.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tutorial.spring5.spring5webapp.model.Author;
import tutorial.spring5.spring5webapp.model.Book;
import tutorial.spring5.spring5webapp.model.Publisher;
import tutorial.spring5.spring5webapp.repositories.AuthorRepository;
import tutorial.spring5.spring5webapp.repositories.BookRepository;
import tutorial.spring5.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author brandon = new Author("Brandon", "Sanderson");
        Publisher harper = new Publisher("Harper Colins", "Fake Street");
        publisherRepository.save(harper);
        Book theFinalEmpire = new Book("The Final Empire", "1234", harper);
        brandon.getBooks().add(theFinalEmpire);
        theFinalEmpire.getAuthors().add(brandon);
        authorRepository.save(brandon);
        bookRepository.save(theFinalEmpire);



        Author leigh = new Author("Leigh", "Bardugo");
        Publisher worx = new Publisher("Worx", "A testing street.");
        publisherRepository.save(worx);
        Book sixOfCrows = new Book("Six Of Crows", "2345", worx);
        leigh.getBooks().add(sixOfCrows);
        authorRepository.save(leigh);
        bookRepository.save(sixOfCrows);

    }
}
