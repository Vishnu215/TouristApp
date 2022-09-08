package com.tourist.android.touristclone.networking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tourist/android/touristclone/networking/TouristService;", "", "fetchPosts", "Lretrofit2/Response;", "Lcom/tourist/android/touristclone/models/TouristApiResponse;", "page", "", "loadSize", "after", "", "before", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface TouristService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/Tourist")
    public abstract java.lang.Object fetchPosts(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int loadSize, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "after")
    java.lang.String after, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "before")
    java.lang.String before, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.tourist.android.touristclone.models.TouristApiResponse>> p4);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}