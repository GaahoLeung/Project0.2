package cn.edu.cqu.caijimovie.entities;

public class Movie {

    //电影id
    private int id;

    // 电影名
    private String title;

    //电影网址
    private String url;

    //电影海报网址
    private String cover;

    //电影评分
    private float rate;

    //电影导演
    private String director;

    //电影编剧
    private String composer;

    //电影主演
    private String actor;

    //地区
    private String district;

    //语言
    private String language;

    //上映年份
    private int showtime;

    //片长
    private int duration;

    //别名
    private String othername;

    //简介
    private String description;

    //粉丝数量
    private int follownum;

    public Movie() {
    }

    public Movie(int id, String title) {
        super();
        this.id = id;
        this.title = title;
        this.url = url;
        this.cover = cover;
        this.rate = rate;
        this.director = director;
        this.composer = composer;
        this.actor = actor;
        this.district = district;
        this.language = language;
        this.showtime = showtime;
        this.duration = duration;
        this.othername = othername;
        this.description = description;
        this.follownum = follownum;
    }

    //电影id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // 电影名

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    //设置电影网址

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    //设置电影海报网址

    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getCover() {
        return cover;
    }

    //设置电影评分

    public void setRate(float rate) {
        this.rate = rate;
    }
    public float getRate() {
        return rate;
    }

    //设置电影导演

    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return director;
    }

    //设置电影编剧

    public void setComposer(String composer) {
        this.composer = composer;
    }
    public String getComposer() {
        return composer;
    }

    //设置电影主演

    public void setActor(String actor) {
        this.actor = actor;
    }
    public String getActor() {
        return actor;
    }

    //设置电影地区

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getDistrict() {
        return district;
    }

    //设置电影语言

    public void setLanguage(String language) {
        this.language = language;
    }
    public String getLanguage() {
        return language;
    }

    //设置电影年份
    void setShowtime(int showtime) {
        this.showtime = showtime;
    }
    public int getShowtime() {
        return showtime;
    }

    //设置电影片长

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }

    //获取电影别名
    public String getOthername() {
        return othername;
    }
    public void setOthername(String othername) {
        this.othername = othername;
    }

    //设置电影简介

    public void setDescription(String description) {
        this.description = description;
    }

    //获取电影简介

    public String getDescription() {
        return description;
    }

    //设置粉丝数
    public void setFollownum(int follownum) {
        this.follownum = follownum;
    }

    //获取粉丝数
    public int getFollownum() {
        return follownum;
    }
}
