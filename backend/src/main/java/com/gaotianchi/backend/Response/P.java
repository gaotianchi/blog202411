package com.gaotianchi.backend.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class P<T> {
    private List<T> data;
    private Integer currentPage;
    private Integer totalPage;
}
