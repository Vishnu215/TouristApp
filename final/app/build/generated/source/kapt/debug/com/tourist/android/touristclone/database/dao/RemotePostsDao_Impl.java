package com.tourist.android.touristclone.database.dao;

import android.database.Cursor;
import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tourist.android.touristclone.models.TouristPost;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RemotePostsDao_Impl implements RemotePostsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TouristPost> __insertionAdapterOfTouristPost;

  public RemotePostsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTouristPost = new EntityInsertionAdapter<TouristPost>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tourist` (`id`,`tourist_name`,`tourist_email`,`tourist_location`,`createdat`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TouristPost value) {
        stmt.bindLong(1, value.getId());
        if (value.getTourist_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTourist_name());
        }
        if (value.getTourist_email() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTourist_email());
        }
        if (value.getTourist_location() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTourist_location());
        }
        if (value.getCreatedat() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreatedat());
        }
      }
    };
  }

  @Override
  public Object savePosts(final List<TouristPost> redditPosts,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTouristPost.insert(redditPosts);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public PagingSource<Integer, TouristPost> getPosts() {
    final String _sql = "SELECT * FROM tourist";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, TouristPost>() {
      @Override
      public LimitOffsetDataSource<TouristPost> create() {
        return new LimitOffsetDataSource<TouristPost>(__db, _statement, false , "tourist") {
          @Override
          protected List<TouristPost> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfTouristName = CursorUtil.getColumnIndexOrThrow(cursor, "tourist_name");
            final int _cursorIndexOfTouristEmail = CursorUtil.getColumnIndexOrThrow(cursor, "tourist_email");
            final int _cursorIndexOfTouristLocation = CursorUtil.getColumnIndexOrThrow(cursor, "tourist_location");
            final int _cursorIndexOfCreatedat = CursorUtil.getColumnIndexOrThrow(cursor, "createdat");
            final List<TouristPost> _res = new ArrayList<TouristPost>(cursor.getCount());
            while(cursor.moveToNext()) {
              final TouristPost _item;
              final int _tmpId;
              _tmpId = cursor.getInt(_cursorIndexOfId);
              final String _tmpTourist_name;
              _tmpTourist_name = cursor.getString(_cursorIndexOfTouristName);
              final String _tmpTourist_email;
              _tmpTourist_email = cursor.getString(_cursorIndexOfTouristEmail);
              final String _tmpTourist_location;
              _tmpTourist_location = cursor.getString(_cursorIndexOfTouristLocation);
              final String _tmpCreatedat;
              _tmpCreatedat = cursor.getString(_cursorIndexOfCreatedat);
              _item = new TouristPost(_tmpId,_tmpTourist_name,_tmpTourist_email,_tmpTourist_location,_tmpCreatedat);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    }.asPagingSourceFactory().invoke();
  }
}
