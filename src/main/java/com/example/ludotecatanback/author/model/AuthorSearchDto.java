package com.example.ludotecatanback.author.model;


import com.example.ludotecatanback.common.pagination.PageableRequest;

public class AuthorSearchDto {

    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }
}
