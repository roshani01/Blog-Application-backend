package com.dl.blog_app.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Column(name = "post_title", length = 100, nullable = false)
    private String title;

    private String content;
    private String imageName;
    private Date addedDate;

    // Many-to-one relationship with Category entity
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)  // Foreign key to Category table
    private Category category;

    // Many-to-one relationship with User entity
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key to User table
    private User user;
    
    
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments=new HashSet<>();

    // Getters and Setters
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Constructors
    public Post() {
        super();
    }

    public Post(Long postId, String title, String content, String imageName, Date addedDate, Category category, User user) {
        super();
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.imageName = imageName;
        this.addedDate = addedDate;
        this.category = category;
        this.user = user;
    }
}
