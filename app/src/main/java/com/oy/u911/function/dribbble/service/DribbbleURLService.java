package com.oy.u911.function.dribbble.service;

import com.oy.u911.function.dribbble.model.ShotJson;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 11:52
 * Describe :
 */

public interface DribbbleURLService {

    String DRIBBBLE_BASE_URL = "https://api.dribbble.com/v2/";
    String ACCESS_TOKEN = "fc564af80a70b81dd492d151967e0451e74cdf43f22266ddcf54f8509b8fbd0f";

    /**
     * possible value of the first parameter in{@link #getShots(String, String, Date, String, int, int)}
     */
    String PARAM_LIST_ANIMATED = "animated";
    String PARAM_LIST_ATTACHMENTS = "attachments";
    String PARAM_LIST_DEBUTS = "debuts";
    String PARAM_LIST_PLAYOFFS = "playoffs";
    String PARAM_LIST_REBOUNDS = "rebounds";
    String PARAM_LIST_TEAMS = "teams";

    /**
     * possible value of the second parameter in{@link #getShots(String, String, Date, String, int, int)}
     */
    String PARAM_TIME_FRAME_WEEK = "week";
    String PARAM_TIME_FRAME_MONTH = "month";
    String PARAM_TIME_FRAME_YEAR = "year";
    String PARAM_TIME_FRAME_EVER = "ever";

    /**
     * possible value of the fourth parameter in{@link #getShots(String, String, Date, String, int, int)}
     */
    String PARAM_SORT_COMMENTS = "comments";
    String PARAM_SORT_RECENT = "recent";
    String PARAM_SORT_VIEWS = "views";
    /**
     * Request shots.
     *
     * @param list      possible value
     *                  <pre>
     *                      <ul>
     *                      <li>animated</li>
     *                      <li>attachments</li>
     *                      <li>debuts</li>
     *                      <li>playoffs</li>
     *                      <li>rebounds</li>
     *                      <li>teams</li>
     *                      </ul>
     *                  </pre>
     * @param timeframe possible value
     *                  <pre>
     *                      <ul>
     *                      <li>week</li>
     *                      <li>month</li>
     *                      <li>year</li>
     *                      <li>ever</li>
     *                      </ul>
     *                  </pre>
     * @param date limit timeframe to a specific date, week, month or year.<br>
     *             Must be in the format of YYYY-MM-DD.
     * @param sort possible value.<br>
     *             <ul>
     *             <li>comments</li>
     *             <li>recent</li>
     *             <li>views</li>
     *             </ul>
     * @return result
     */
    @Headers("Authorization: Bearer fc564af80a70b81dd492d151967e0451e74cdf43f22266ddcf54f8509b8fbd0f")
    @GET("shots")
    Observable<List<ShotJson>> getShots(@Query("list") String list,
                                        @Query("timeframe") String timeframe,
                                        @Query("date") Date date,
                                        @Query("sort") String sort,
                                        @Query("page") int page,
                                        @Query("per_page") int perPage);

}
