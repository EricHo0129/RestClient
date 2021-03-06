package com.eric.spring.controller;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.spring.model.ProfileModel;
import com.eric.spring.model.ResponseModel;
import com.eric.spring.service.ProfileRestful;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.Interceptor.Chain;import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@RestController
public class RetrofitProfile {

	static final String BASE_URL = "https://apis.104dc-dev.com/individual/1.0/";
	@Value("${FP_API_KEY}")
	private String apiKey;
	
	@GetMapping("/retrofit")
	public ResponseEntity<Map<Long, ProfileModel>> getProfileList() throws Exception {
		OkHttpClient client = new OkHttpClient.Builder()
				.readTimeout(200, TimeUnit.MILLISECONDS)
				.connectTimeout(200, TimeUnit.MILLISECONDS)
				.addInterceptor(new Interceptor() {
					@Override
					public okhttp3.Response intercept(Chain chain) throws IOException {
						Request request = chain.request().newBuilder()
								.addHeader("104-API-Key", apiKey)
								.build();
						try {							
							return chain.proceed(request);
						} catch (SocketTimeoutException ste) {
							return new okhttp3.Response.Builder()
									.protocol(Protocol.HTTP_1_1)
									.message("timeout")
									.body(ResponseBody.create(MediaType.parse("application/json"), "{}"))
									.request(request).code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
						}
					}
				})
				.build();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();
		ProfileRestful profileAPI = retrofit.create(ProfileRestful.class);
		Call<ResponseModel> call = profileAPI.getProfiles(new Long[] {100024L, 103473L}, new String[] {"userName"});			
		Response<ResponseModel> resp = call.execute();
		Map<Long, ProfileModel> result = new HashMap<Long, ProfileModel>();
		if (resp.code() == 200) {
			ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
			result = mapper.readValue(mapper.writeValueAsBytes(resp.body().getResponse()), Map.class);
			return new ResponseEntity<Map<Long, ProfileModel>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Map<Long, ProfileModel>>(result, HttpStatus.GATEWAY_TIMEOUT);
		}
	}
}
