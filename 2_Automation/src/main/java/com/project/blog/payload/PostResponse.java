package com.project.blog.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor

public class PostResponse {

    private List<PostDto> content;

    private int pageSize;

    private int pageNumber;

    private int totalPages;

    private long totalElements;

    private boolean lastPage;

}
