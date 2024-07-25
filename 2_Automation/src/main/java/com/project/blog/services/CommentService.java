package com.project.blog.services;

import com.project.blog.payload.CommentDto;

import javax.persistence.criteria.CriteriaBuilder;


public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);

    void deleteComment(Integer commentId);

}
