package com.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String content;
    private Long date = System.currentTimeMillis();

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;



    public Blog() {
    }

    public Blog(Long id, String name, String description, String content) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.content = content;
        this.date = System.currentTimeMillis();
    }



    public Blog(String name, String description, String content) {
        this.name = name;
        this.description = description;
        this.content = content;
        this.date = System.currentTimeMillis();
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
