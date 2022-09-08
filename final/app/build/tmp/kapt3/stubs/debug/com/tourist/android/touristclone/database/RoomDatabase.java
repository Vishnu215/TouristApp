package com.tourist.android.touristclone.database;

import java.lang.System;

@androidx.room.Database(entities = {com.tourist.android.touristclone.models.TouristPost.class, com.tourist.android.touristclone.models.RemoteKeys.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tourist/android/touristclone/database/RoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "redditKeysDao", "Lcom/tourist/android/touristclone/database/dao/RemoteKeysDao;", "redditPostsDao", "Lcom/tourist/android/touristclone/database/dao/RemotePostsDao;", "Companion", "app_debug"})
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    public static final com.tourist.android.touristclone.database.RoomDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tourist.android.touristclone.database.dao.RemotePostsDao redditPostsDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tourist.android.touristclone.database.dao.RemoteKeysDao redditKeysDao();
    
    public RoomDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tourist/android/touristclone/database/RoomDatabase$Companion;", "", "()V", "create", "Landroidx/room/RoomDatabase;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.RoomDatabase create(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}