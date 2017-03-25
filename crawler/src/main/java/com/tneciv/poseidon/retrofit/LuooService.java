package com.tneciv.poseidon.retrofit;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tneciv on 2017/3/25.
 */
public interface LuooService {
    
    @GET("music/{id}")
    Flowable<String> getJournalById(@Path("id") int id);

    @GET("musician/{id}")
    Flowable<String> getMusicianById(@Path("id") int id);

}
