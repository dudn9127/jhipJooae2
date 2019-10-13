package com.mycompany.myapp.service.dto;


import com.mycompany.myapp.domain.Board;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class BoardDTO {

    private Long id;

    @NotBlank
    @Size(min=1,max=50)
    private String title;

    @Size(max=1000)
    private String content;

    @Size(max=256)
    private String imageUrl;

    private Date createdTime;

    private Date modifiedDate = null;

    public BoardDTO(){
        //Empty constructor
    }

    public BoardDTO(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.imageUrl = board.getImageUrl();
        this.createdTime=board.getCreatedTime();
        this.modifiedDate=board.getModifiedDate();
    }


    public Long getId() {return id;}

    public void setId(Long id) {this.id=id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title=title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content=content;}

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl=imageUrl;}

    public Date getCreatedTime() {return createdTime;}

    public Date getModifiedDate() {return modifiedDate;}

    public void setModifiedDate(Date modifiedDate) {this.modifiedDate=modifiedDate;}

    @Override
    public String toString() {
        return "BoardDTO{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", createdTime=" + createdTime + '\'' +
            ", modifiedDate" + modifiedDate + '\'' +
            "}";
    }

}
