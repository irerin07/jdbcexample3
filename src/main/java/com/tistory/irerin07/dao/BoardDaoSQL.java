package com.tistory.irerin07.dao;

public class BoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT f.post_id, f.title, u.nickname, f.content, f.regdate, f.view,f.fam_num, f.fam_lev, f.fam_seq, u.user_id FROM freepost f LEFT JOIN user u ON f.nickname = u.nickname WHERE f.post_id=?";
    public static final String SELECT_BY_PAGING =
            "SELECT f.post_id, f.title, u.nickname, f.content, f.regdate, f.view,f.fam_num, f.fam_lev, f.fam_seq, u.user_id FROM freepost f LEFT JOIN user u ON f.nickname = u.nickname ORDER BY f.post_id DESC LIMIT ?, ?";
    public static final String INSERT =
            "insert into freepost (title, nickname, content, user_id) values(?,?,?,?);";
    public static final String UPDATE_VIEW =
            "UPDATE freepost SET view = view + 1 WHERE post_id=?";
    public static final String DELETE =
            "DELETE FROM freepost WHERE post_id=?";
    public static final String MODIFY =
            "UPDATE freepost f SET f.title = title, f.content = content WHERE post_id=?";
}
