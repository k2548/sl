package com.example.entity;

import java.util.List;

public class Course {
	private int id;
    private String name;
    private CourseDetail courseDetail;
    private List<Chapter> chapters;

    public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	public CourseDetail getCourseDetail() {
		return courseDetail;
	}
	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
