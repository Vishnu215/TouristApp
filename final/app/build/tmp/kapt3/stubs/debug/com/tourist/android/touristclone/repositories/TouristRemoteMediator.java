package com.tourist.android.touristclone.repositories;

import java.lang.System;

@kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0013\u0010\t\u001a\u0004\u0018\u00010\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ-\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tourist/android/touristclone/repositories/TouristRemoteMediator;", "Landroidx/paging/RemoteMediator;", "", "Lcom/tourist/android/touristclone/models/TouristPost;", "redditService", "Lcom/tourist/android/touristclone/networking/TouristService;", "redditDatabase", "Lcom/tourist/android/touristclone/database/RoomDatabase;", "(Lcom/tourist/android/touristclone/networking/TouristService;Lcom/tourist/android/touristclone/database/RoomDatabase;)V", "getRedditKeys", "Lcom/tourist/android/touristclone/models/RemoteKeys;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/RemoteMediator$MediatorResult;", "loadType", "Landroidx/paging/LoadType;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TouristRemoteMediator extends androidx.paging.RemoteMediator<java.lang.Integer, com.tourist.android.touristclone.models.TouristPost> {
    private final com.tourist.android.touristclone.networking.TouristService redditService = null;
    private final com.tourist.android.touristclone.database.RoomDatabase redditDatabase = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object load(@org.jetbrains.annotations.NotNull()
    androidx.paging.LoadType loadType, @org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<java.lang.Integer, com.tourist.android.touristclone.models.TouristPost> state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.MediatorResult> p2) {
        return null;
    }
    
    public TouristRemoteMediator(@org.jetbrains.annotations.NotNull()
    com.tourist.android.touristclone.networking.TouristService redditService, @org.jetbrains.annotations.NotNull()
    com.tourist.android.touristclone.database.RoomDatabase redditDatabase) {
        super();
    }
}