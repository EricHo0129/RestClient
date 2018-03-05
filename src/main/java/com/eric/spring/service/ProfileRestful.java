package com.eric.spring.service;

import com.eric.spring.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ProfileRestful {

	@GET("profiles")
	public Call<ResponseModel> getProfiles(@Query("pids") Long[] pids, @Query("fields") String[] fields);
}
