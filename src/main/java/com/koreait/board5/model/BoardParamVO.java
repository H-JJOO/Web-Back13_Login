package com.koreait.board5.model;

public class BoardParamVO {
    private int recordCnt;
    private int page;
    private int sIdx;

    public int getRecordCnt() {
        return recordCnt;
    }

    public int getPage() {
        return page;
    }

    public int getsIdx() {
        return sIdx;
    }

    public void setRecordCnt(int recordCnt) {
        this.recordCnt = recordCnt;
    }

    public void setPage(int page) {
        this.page = page;
        this.sIdx = (page -1) * recordCnt;
    }
}
