package com.diamorph.rest.webservices.restfulwebservices.jpa;

import com.diamorph.rest.webservices.restfulwebservices.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
