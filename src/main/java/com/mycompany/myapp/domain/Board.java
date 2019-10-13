package com.mycompany.myapp.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="jooae_board")
public class Board implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1,max=50)
    @Column(length = 50, nullable =false)
    private String title;

    @Size(max=1000)
    @Column(length=1000)
    private String content;

    @Size(max=256)
    @Column(name="image_url",length=256)
    private String imgUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_time")
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_date")
    private Date modifiedDate = null;


    public Long getId() {return id;}

    public void setId(Long id) {this.id=id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title=title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content=content;}

    public String getImageUrl() {return imgUrl;}

    public void setImageUrl(String imageUrl) {this.imgUrl=imageUrl;}

    public Date getCreatedTime() {return createdTime;}

    public Date getModifiedDate() {return modifiedDate;}

    public void setModifiedDate(Date modifiedDate) {this.modifiedDate=modifiedDate;}

    @Override
    public String toString() {
        return "Board{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", imageUrl='" + imgUrl + '\'' +
            ", createdTime=" + createdTime + '\'' +
            ", modifiedDate" + modifiedDate + '\'' +
            "}";
    }
}
