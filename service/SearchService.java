package net.messi.early.service;

import net.messi.early.dto.Search2DTO;
import net.messi.early.dto.SearchDTO;

public interface SearchService {

    SearchDTO searchNavigation(Integer userId);

    Search2DTO searchByKeyword(String keyword, Integer page, Integer size, String sort, String order, Integer categoryId, Integer userId);

    void deleteHistorySearch(Integer userId);
}
