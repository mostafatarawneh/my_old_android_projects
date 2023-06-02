package com.mos.examlble4adaptor;

public class Pofile {
    private String name , bio;
    private int following,followers,posts,Img;

    public Pofile(String name, String bio, int following, int followers, int posts,int Img) {
        this.name = name;
        this.bio = bio;
        this.following = following;
        this.followers = followers;
        this.posts = posts;
        this.Img=Img;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }
}
