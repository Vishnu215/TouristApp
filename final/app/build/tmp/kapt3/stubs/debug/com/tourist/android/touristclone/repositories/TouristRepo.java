package com.tourist.android.touristclone.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tourist/android/touristclone/repositories/TouristRepo;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "redditDatabase", "Landroidx/room/RoomDatabase;", "redditService", "Lcom/tourist/android/touristclone/networking/TouristService;", "kotlin.jvm.PlatformType", "fetchPosts", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/tourist/android/touristclone/models/TouristPost;", "app_debug"})
public final class TouristRepo {
    private final com.tourist.android.touristclone.networking.TouristService redditService = null;
    private final androidx.room.RoomDatabase redditDatabase = null;
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.tourist.android.touristclone.models.TouristPost>> fetchPosts() {
        return null;
    }
    
    public TouristRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}