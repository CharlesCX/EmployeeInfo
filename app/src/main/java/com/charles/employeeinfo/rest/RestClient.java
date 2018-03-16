package com.charles.employeeinfo.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by charles on 15/03/2018.
 */

public class RestClient {
    //http://navjacinth9.000webhostapp.com/json/retrofit-demo.php?company_no=123
    public static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";

    public static Retrofit retrofit = null;

    public static Retrofit getGateWay() {
        if(retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
