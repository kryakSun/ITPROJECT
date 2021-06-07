package com.ma.Shop.ShopApplication.repositories;

import com.ma.Shop.ShopApplication.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {}
