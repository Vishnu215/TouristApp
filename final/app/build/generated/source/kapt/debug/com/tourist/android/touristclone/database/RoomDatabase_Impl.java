package com.tourist.android.touristclone.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.tourist.android.touristclone.database.dao.RemoteKeysDao;
import com.tourist.android.touristclone.database.dao.RemoteKeysDao_Impl;
import com.tourist.android.touristclone.database.dao.RemotePostsDao;
import com.tourist.android.touristclone.database.dao.RemotePostsDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDatabase_Impl extends RoomDatabase {
  private volatile RemotePostsDao _remotePostsDao;

  private volatile RemoteKeysDao _remoteKeysDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tourist` (`id` INTEGER NOT NULL, `tourist_name` TEXT NOT NULL, `tourist_email` TEXT NOT NULL, `tourist_location` TEXT NOT NULL, `createdat` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `redditKeys` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `after` TEXT, `before` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '42a1c77152a739bb173dfd280ffd0f73')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `tourist`");
        _db.execSQL("DROP TABLE IF EXISTS `redditKeys`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTourist = new HashMap<String, TableInfo.Column>(5);
        _columnsTourist.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTourist.put("tourist_name", new TableInfo.Column("tourist_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTourist.put("tourist_email", new TableInfo.Column("tourist_email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTourist.put("tourist_location", new TableInfo.Column("tourist_location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTourist.put("createdat", new TableInfo.Column("createdat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTourist = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTourist = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTourist = new TableInfo("tourist", _columnsTourist, _foreignKeysTourist, _indicesTourist);
        final TableInfo _existingTourist = TableInfo.read(_db, "tourist");
        if (! _infoTourist.equals(_existingTourist)) {
          return new RoomOpenHelper.ValidationResult(false, "tourist(com.tourist.android.touristclone.models.TouristPost).\n"
                  + " Expected:\n" + _infoTourist + "\n"
                  + " Found:\n" + _existingTourist);
        }
        final HashMap<String, TableInfo.Column> _columnsRedditKeys = new HashMap<String, TableInfo.Column>(3);
        _columnsRedditKeys.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedditKeys.put("after", new TableInfo.Column("after", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedditKeys.put("before", new TableInfo.Column("before", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRedditKeys = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRedditKeys = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRedditKeys = new TableInfo("redditKeys", _columnsRedditKeys, _foreignKeysRedditKeys, _indicesRedditKeys);
        final TableInfo _existingRedditKeys = TableInfo.read(_db, "redditKeys");
        if (! _infoRedditKeys.equals(_existingRedditKeys)) {
          return new RoomOpenHelper.ValidationResult(false, "redditKeys(com.tourist.android.touristclone.models.RemoteKeys).\n"
                  + " Expected:\n" + _infoRedditKeys + "\n"
                  + " Found:\n" + _existingRedditKeys);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "42a1c77152a739bb173dfd280ffd0f73", "4b5695ad7794bc0dd637ae6f9de18f7b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tourist","redditKeys");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tourist`");
      _db.execSQL("DELETE FROM `redditKeys`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public RemotePostsDao redditPostsDao() {
    if (_remotePostsDao != null) {
      return _remotePostsDao;
    } else {
      synchronized(this) {
        if(_remotePostsDao == null) {
          _remotePostsDao = new RemotePostsDao_Impl(this);
        }
        return _remotePostsDao;
      }
    }
  }

  @Override
  public RemoteKeysDao redditKeysDao() {
    if (_remoteKeysDao != null) {
      return _remoteKeysDao;
    } else {
      synchronized(this) {
        if(_remoteKeysDao == null) {
          _remoteKeysDao = new RemoteKeysDao_Impl(this);
        }
        return _remoteKeysDao;
      }
    }
  }
}
