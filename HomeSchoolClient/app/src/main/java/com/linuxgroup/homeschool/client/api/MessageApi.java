package com.linuxgroup.homeschool.client.api;

import com.linuxgroup.homeschool.client.domain.Message;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by tan on 14-9-23.
 */
public interface MessageApi {
    @GET(Api.PATH_MESSAGE)
    Message getMessage(@Path("id") Integer id);
}
