package io.github.accessun.bean;

import java.util.Arrays;

public class MongoInfo {

    private String _id;
    private String title;
    private String description;
    private String by_user;
    private String url;
    private int likes;
    private String[] tags;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBy_user() {
        return by_user;
    }

    public void setBy_user(String by_user) {
        this.by_user = by_user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "MongoInfo [_id=" + _id + ", title=" + title + ", description=" + description + ", by_user=" + by_user
                + ", url=" + url + ", likes=" + likes + ", tags=" + Arrays.toString(tags) + "]";
    }

}
