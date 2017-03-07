package com.mag.codepath.simpletweet.db;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.BaseContentProvider;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class TwitterDatabase_Provider extends BaseContentProvider {
  private static final int Tweet_CONTENT_URI = 0;

  private static final int User_CONTENT_URI = 1;

  private final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

  @Override
  public final boolean onCreate() {
    final String AUTHORITY = "com.codepath.codepath.mysimpletweets.twittercontentprovider";
    MATCHER.addURI(AUTHORITY, "Tweet", Tweet_CONTENT_URI);
    MATCHER.addURI(AUTHORITY, "User", User_CONTENT_URI);
    return super.onCreate();
  }

  @Override
  public final String getDatabaseName() {
    return "TwitterDatabase";
  }

  @Override
  public final String getType(Uri uri) {
    String type = null;
    switch(MATCHER.match(uri)) {
      case Tweet_CONTENT_URI: {
        type = "vnd.android.cursor.dir/Tweet";
        break;
      }
      case User_CONTENT_URI: {
        type = "vnd.android.cursor.dir/User";
        break;
      }
      default: {
        throw new IllegalArgumentException("Unknown URI" + uri);
      }
    }
    return type;
  }

  @Override
  public final Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
      String sortOrder) {
    android.database.Cursor cursor = null;
    switch(MATCHER.match(uri)) {
      case Tweet_CONTENT_URI: {
        cursor = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().query("Tweet", projection, selection, selectionArgs, null, null, sortOrder);
        break;
      }
      case User_CONTENT_URI: {
        cursor = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().query("User", projection, selection, selectionArgs, null, null, sortOrder);
        break;
      }
    }
    if (cursor != null) {
      cursor.setNotificationUri(getContext().getContentResolver(), uri);
    }
    return cursor;
  }

  @Override
  public final Uri insert(Uri uri, ContentValues values) {
    switch(MATCHER.match(uri)) {
      case Tweet_CONTENT_URI: {
        ModelAdapter adapter = FlowManager.getModelAdapter(FlowManager.getTableClassForName("TwitterDatabase", "Tweet"));
        final long id = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().insertWithOnConflict("Tweet", null, values, ConflictAction.getSQLiteDatabaseAlgorithmInt(adapter.getInsertOnConflictAction()));
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
      }
      case User_CONTENT_URI: {
        ModelAdapter adapter = FlowManager.getModelAdapter(FlowManager.getTableClassForName("TwitterDatabase", "User"));
        final long id = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().insertWithOnConflict("User", null, values, ConflictAction.getSQLiteDatabaseAlgorithmInt(adapter.getInsertOnConflictAction()));
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
      }
      default: {
        throw new IllegalArgumentException("Unknown URI" + uri);
      }
    }
  }

  @Override
  protected final int bulkInsert(Uri uri, ContentValues values) {
    switch(MATCHER.match(uri)) {
      case Tweet_CONTENT_URI: {
        ModelAdapter adapter = FlowManager.getModelAdapter(FlowManager.getTableClassForName("TwitterDatabase", "Tweet"));
        final long id = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().insertWithOnConflict("Tweet", null, values, ConflictAction.getSQLiteDatabaseAlgorithmInt(adapter.getInsertOnConflictAction()));
        getContext().getContentResolver().notifyChange(uri, null);
        return id > 0 ? 1 : 0;
      }
      case User_CONTENT_URI: {
        ModelAdapter adapter = FlowManager.getModelAdapter(FlowManager.getTableClassForName("TwitterDatabase", "User"));
        final long id = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().insertWithOnConflict("User", null, values, ConflictAction.getSQLiteDatabaseAlgorithmInt(adapter.getInsertOnConflictAction()));
        getContext().getContentResolver().notifyChange(uri, null);
        return id > 0 ? 1 : 0;
      }
      default: {
        throw new IllegalArgumentException("Unknown URI" + uri);
      }
    }
  }

  @Override
  public final int delete(Uri uri, String selection, String[] selectionArgs) {
    switch(MATCHER.match(uri)) {
      case Tweet_CONTENT_URI: {
        long count = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().delete("Tweet", selection, selectionArgs);
        if (count > 0) {
          getContext().getContentResolver().notifyChange(uri, null);
        }
        return (int) count;
      }
      case User_CONTENT_URI: {
        long count = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().delete("User", selection, selectionArgs);
        if (count > 0) {
          getContext().getContentResolver().notifyChange(uri, null);
        }
        return (int) count;
      }
      default: {
        throw new IllegalArgumentException("Unknown URI" + uri);
      }
    }
  }

  @Override
  public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
    switch(MATCHER.match(uri)) {
      case Tweet_CONTENT_URI: {
        ModelAdapter adapter = FlowManager.getModelAdapter(FlowManager.getTableClassForName("TwitterDatabase", "Tweet"));
        long count = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().updateWithOnConflict("Tweet", values, selection, selectionArgs, ConflictAction.getSQLiteDatabaseAlgorithmInt(adapter.getUpdateOnConflictAction()));
        if (count > 0) {
          getContext().getContentResolver().notifyChange(uri, null);
        }
        return (int) count;
      }
      case User_CONTENT_URI: {
        ModelAdapter adapter = FlowManager.getModelAdapter(FlowManager.getTableClassForName("TwitterDatabase", "User"));
        long count = FlowManager.getDatabase("TwitterDatabase").getWritableDatabase().updateWithOnConflict("User", values, selection, selectionArgs, ConflictAction.getSQLiteDatabaseAlgorithmInt(adapter.getUpdateOnConflictAction()));
        if (count > 0) {
          getContext().getContentResolver().notifyChange(uri, null);
        }
        return (int) count;
      }
      default: {
        throw new IllegalArgumentException("Unknown URI" + uri);
      }
    }
  }
}
