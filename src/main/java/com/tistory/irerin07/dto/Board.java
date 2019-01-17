package com.tistory.irerin07.dto;

import java.util.Date;

public class Board {
    private Long postId;
    private String title;
    private String nickname;
    private String content;
    private Date regdate;
    private int view;
    private long famNum;
    private long famLev;
    private long famSeq;
    private Long userId;

    public Board(){
        this.regdate = new Date();
        this.view = 0;
    }

    public Board(String title, String content, String nickname) {
        this();
        this.title = title;
        this.content = content;
        this.nickname = nickname;
    }

    public Board(Long postId, String title, String content, String nickname, Date regdate, int readCount) {
        this(title, content, nickname);
        this.postId = postId;
        this.regdate = regdate;
        this.view = readCount;
    }

    public Board(String title, String content, String nickname, Long userId) {
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.userId = userId;
    }

    public Board(long postId, String title, String content, String nickname, Date regdate, int view, Long userId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.regdate = regdate;
        this.view = view;
        this.userId = userId;

    }

    public Board(long postId, String title, String content, String nickname, Date regdate, int view, long famNum, long famLev, long famSeq, Long userId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.regdate = regdate;
        this.view = view;
        this.famNum = famNum;
        this.famLev = famLev;
        this.famSeq = famSeq;
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public long getFamNum() {
        return famNum;
    }

    public void setFamNum(int famNum) {
        this.famNum = famNum;
    }

    public long getFamLev() {
        return famLev;
    }

    public void setFamLev(int famLev) {
        this.famLev = famLev;
    }

    public long getFamSeq() {
        return famSeq;
    }

    public void setFamSeq(int famSeq) {
        this.famSeq = famSeq;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Board{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", view=" + view +
                ", famNum=" + famNum +
                ", famLev=" + famLev +
                ", famSeq=" + famSeq +
                ", userId=" + userId +
                '}';
    }
}
