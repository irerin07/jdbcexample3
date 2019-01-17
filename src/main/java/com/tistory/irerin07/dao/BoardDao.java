package com.tistory.irerin07.dao;

import com.tistory.irerin07.dto.Board;

import java.util.List;

public interface BoardDao {
    public Board getBoard(Long id);
    public List<Board> getBoards(int start, int limit);

    void addBoard(Board board);

    void deleteBoard(Long id);

    void updateReadCount(long id);

    void modifyBoard(Long id);
}