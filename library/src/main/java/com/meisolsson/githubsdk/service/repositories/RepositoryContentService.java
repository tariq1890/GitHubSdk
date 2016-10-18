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

package com.meisolsson.githubsdk.service.repositories;

import com.meisolsson.githubsdk.model.Content;
import com.meisolsson.githubsdk.model.ContentCommit;
import com.meisolsson.githubsdk.model.request.repository.CreateContent;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface RepositoryContentService {

    @GET("repos/{owner}/{repo}/readme")
    Observable<Content> getReadme(@Path("owner") String owner, @Path("repo") String repo, @Query("ref") String ref);

    @GET("repos/{owner}/{repo}/contents/{path}")
	Observable<Content> getContents(@Path("owner") String owner, @Path("repo") String repo, @Path("path") String path, @Query("ref") String ref);

    @GET("repos/{owner}/{repo}/contents/{path}")
    Observable<List<Content>> getDirectoryContents(@Path("owner") String owner, @Path("repo") String repo, @Path("path") String path, @Query("ref") String ref);

    @PUT("repos/{owner}/{repo}/contents/{path}")
	Observable<ContentCommit> createFile(@Path("owner") String owner, @Path("repo") String repo, @Path("path") String path, @Body CreateContent body);

    @PUT("repos/{owner}/{repo}/contents/{path}")
	Observable<ContentCommit> editFile(@Path("owner") String owner, @Path("repo") String repo, @Path("path") String path, @Body CreateContent body);

    @DELETE("repos/{owner}/{repo}/contents/{path}")
	Observable<ContentCommit> deleteFile(@Path("owner") String owner, @Path("repo") String repo, @Path("path") String path, @Body CreateContent body);

    @HEAD("repos/{owner}/{repo}/readme")
    Observable<Response<Void>> hasReadme(@Path("owner") String owner, @Path("repo") String repo);
}