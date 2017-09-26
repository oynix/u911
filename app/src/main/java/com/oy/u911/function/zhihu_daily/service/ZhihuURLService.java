package com.oy.u911.function.zhihu_daily.service;

import com.oy.u911.function.zhihu_daily.model.DailyNewsJson;
import com.oy.u911.function.zhihu_daily.model.NewsDetailJson;
import com.oy.u911.function.zhihu_daily.model.StartImageJson;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 15:53
 * Describe : 请求数据的URL
 * <p>
 * url取自该篇文章 : <a href="http://blog.csdn.net/fanpeihua123/article/details/51210499">知乎日报API分析</a>
 * <pre>
 *     Retrofit五步走:
 *     需要写至少一个接口
 *     |-然后定义至少一个接口方法
 *       |-然后构建Retrofit
 *        |-然后调用create方法生成接口类
 *         |-然后调用enqueue或者 execute方法发送一个异步或同步请求(请求返回为Call类型时)
 * </pre>
 */

public interface ZhihuURLService {

    /** 获取启动图片 */
    @GET("start-image/1080*1776")
    Observable<StartImageJson> getStartImage();

    /** 获取最新消息 */
    @GET("news/latest")
    Observable<DailyNewsJson> getLatestNews();

    /**
     * 获取历史消息
     * <pre>
     * 知乎日报的生日为2013年5月19日，若 before 后数字小于 20130520，只会接收到空消息
     * 输入的今日之后的日期仍然获得今日内容，但是格式不同于最新消息的JSON 格式, 无top_stories项
     * </pre>
     *
     * @param date : 要获取的日期 8位数字
     */
    @GET("news/before/{date}")
    Observable<DailyNewsJson> getHistoryNews(@Path("date") String date);

    /**
     * 获取某条新闻的详细内容
     *
     * @param id 即{@link NewsDetailJson#getId()}
     */
    @GET("news/{id}")
    Observable<NewsDetailJson> getNewsDetail(@Path("id") String id);
}
