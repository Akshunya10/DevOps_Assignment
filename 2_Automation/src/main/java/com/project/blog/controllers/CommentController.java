package com.project.blog.controllers;

import com.project.blog.entities.Comment;
import com.project.blog.payload.ApiResponse;
import com.project.blog.payload.CommentDto;
import com.project.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> create(@RequestBody CommentDto comment, @PathVariable Integer postId, @PathVariable Integer userId){
        CommentDto createComment = this.commentService.createComment(comment, postId, userId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) throws Throwable {
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully",true), HttpStatus.OK);
    }
}
