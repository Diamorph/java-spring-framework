package com.diamorph.rest.webservices.restfulwebservices.post;

import com.diamorph.rest.webservices.restfulwebservices.exceptions.PostNotFoundException;
import com.diamorph.rest.webservices.restfulwebservices.jpa.PostRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return repository.findAll();
    }

    @GetMapping("/posts/{id}")
    public EntityModel<Post> retrievePost(@PathVariable("id") int id) {
        Optional<Post> post = repository.findById(id);
        if (post.isEmpty()) {
            System.out.println("Not found post");
            throw new PostNotFoundException("id: " + id);
        }
        EntityModel<Post> entityModel = EntityModel.of(post.get());

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).getPosts()
        );

        entityModel.add(link.withRel("all-posts"));

        return entityModel;
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") int id) {
        repository.deleteById(id);
    }
}
