package cn.edu.cqu.caijimovie.entities;

public class Movie {

    /**
     * 电影id
     **/
    private int id;
    /**
     * 电影名
     **/
    private String title;
    /**
     * 电影网址
     **/
    private String url;
    /**
     * 电影海报网址
     **/
    private String cover;
    /**
     * 电影评分
     **/
    private float rate;
    /**
     * 电影导演
     **/
    private String director;
    /**
     * 电影编剧
     **/
    private String composer;
    /**
     * 电影主演
     **/
    private String actor;
    /**
     * 上映地区
     **/
    private String district;
    /**
     * 语言
     **/
    private String language;
    /**
     * 上映年份
     **/
    private int showtime;
    /**
     * 片长
     **/
    private int duration;
    /**
     * 别名
     **/
    private String othername;
    /**
     * 简介
     **/
    private String description;
    /**
     * 粉丝数量
     **/
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

    /**
     * 获取电影id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置电影id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 设置电影名
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取电影名
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置电影网址
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取电影网址
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置电影海报网址
     *
     * @param cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取电影海报网址
     *
     * @return cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置电影评分
     *
     * @param rate
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    /**
     * 获取电影评分
     *
     * @return rate
     */
    public float getRate() {
        return rate;
    }

    /**
     * 设置电影导演
     *
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 获取电影导演
     *
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 设置电影编剧
     *
     * @param composer
     */
    public void setComposer(String composer) {
        this.composer = composer;
    }

    /**
     * 获取电影编剧
     *
     * @return composer
     */
    public String getComposer() {
        return composer;
    }

    /**
     * 设置电影主演
     *
     * @param actor
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * 获取电影主演
     *
     * @return actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * 设置电影上映地区
     *
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取电影上映地区
     *
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置电影语言
     *
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取电影语言
     *
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置电影上映年份
     *
     * @param showtime
     */
    public void setShowtime(int showtime) {
        this.showtime = showtime;
    }

    /**
     * 获取电影上映年份
     *
     * @return showtime
     */
    public int getShowtime() {
        return showtime;
    }

    /**
     * 设置电影片长
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * 获取电影片长
     *
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 获取电影别名
     *
     * @return othername
     */
    public String getOthername() {
        return othername;
    }

    /**
     * 设置电影别名
     *
     * @param othername
     */
    public void setOthername(String othername) {
        this.othername = othername;
    }

    /**
     * 设置电影简介
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取电影简介
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置粉丝数
     *
     * @param follownum
     */
    public void setFollownum(int follownum) {
        this.follownum = follownum;
    }

    /**
     * 获取粉丝数
     *
     * @return follownum
     */
    public int getFollownum() {
        return follownum;
    }
}
