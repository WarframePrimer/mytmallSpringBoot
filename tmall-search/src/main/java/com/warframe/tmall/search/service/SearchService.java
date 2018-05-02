package com.warframe.tmall.search.service;


import com.warframe.tmall.common.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String keyword, int page, int size, String sort, int priceGt, int priceLte);
}
