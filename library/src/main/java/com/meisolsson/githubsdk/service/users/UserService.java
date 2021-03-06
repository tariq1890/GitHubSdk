/*
 * Copyright 2015 Henrik Olsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meisolsson.githubsdk.service.users;

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.User;
import com.meisolsson.githubsdk.model.request.user.EditUser;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface UserService {

    @GET("users/{username}")
    Observable<User> getUser(@Path("username") String username);

    @GET("/user")
	Observable<User> getUser();

    @PATCH("/user")
	Observable<User> editUser(@Body EditUser body);

    @GET("/users")
	Observable<Page<User>> getUsers(@Query("page") long page);
}
