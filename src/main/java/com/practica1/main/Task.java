package com.practica1.main;

import javax.persistence.*;

@Entity
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", nullable = false, length = 140)
    private String title;

    @Column(name = "body", nullable = false, length = 2048)
    private String body;

    @Column(name = "colorTitle", nullable = false, length = 11)
    private String colorTitle;

    @Column(name = "colorBody", nullable = false, length = 11)
    private String colorBody;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public String getColorTitle()
    {
        return colorTitle;
    }

    public void setColorTitle(String colorTitle)
    {
        this.colorTitle = colorTitle;
    }

    public String getColorBody()
    {
        return colorBody;
    }

    public void setColorBody(String colorBody)
    {
        this.colorBody = colorBody;
    }
}
