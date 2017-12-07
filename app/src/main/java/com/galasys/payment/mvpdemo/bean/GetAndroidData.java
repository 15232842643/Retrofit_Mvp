package com.galasys.payment.mvpdemo.bean;

import java.util.List;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：
 * 创建人：zxh
 * 创建时间：2017/11/30 15:46
 * 修改人：zxh
 * 修改时间：2017/11/30 15:46
 * 修改备注：
 */

public class GetAndroidData {

    /**
     * error : false
     * results : [{"_id":"5a1f5fd2421aa90fe2f02c98","createdAt":"2017-11-30T09:33:06.290Z","desc":"GitHub年度报告，2017年编程语言之争，谁与争锋？","publishedAt":"2017-11-30T13:11:10.665Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU3NzA0ODQzMw==&mid=2247483675&idx=1&sn=b6f0a4e71d5164cf2201bcd8b6df8969","used":true,"who":"陈宇明"}]
     */

    public boolean error;
    public List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5a1f5fd2421aa90fe2f02c98
         * createdAt : 2017-11-30T09:33:06.290Z
         * desc : GitHub年度报告，2017年编程语言之争，谁与争锋？
         * publishedAt : 2017-11-30T13:11:10.665Z
         * source : web
         * type : Android
         * url : https://mp.weixin.qq.com/s?__biz=MzU3NzA0ODQzMw==&mid=2247483675&idx=1&sn=b6f0a4e71d5164cf2201bcd8b6df8969
         * used : true
         * who : 陈宇明
         */

        public String _id;
        public String createdAt;
        public String desc;
        public String publishedAt;
        public String source;
        public String type;
        public String url;
        public boolean used;
        public String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
