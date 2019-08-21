package net.messi.early.dto;

import net.messi.early.pojo.NideshopComment;

import java.io.Serializable;
import java.util.List;

public class CommentAll implements Serializable {

    private List<NideshopComment> commentList;
    private Integer currentPage;

    public List<NideshopComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<NideshopComment> commentList) {
        this.commentList = commentList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
