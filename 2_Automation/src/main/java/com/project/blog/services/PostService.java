package com.project.blog.services;

import com.project.blog.entities.Post;
import com.project.blog.payload.PostDto;
import com.project.blog.payload.PostResponse;

import java.util.List;

public interface PostService {

    //Create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //Update
    PostDto updatePost(PostDto postDto,Integer postId);

    //Delete
    void deletePost(Integer postId);

    //Get all post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize ,String sortBy, String sortDir);

    //Get Single Post
    PostDto getPostById(Integer PostId);

    //Get all post by Category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //Get app Post by user
    List<PostDto> getPostsByUser(Integer userId);

    //Search post
    List<PostDto> searchPost(String keyword);

}
