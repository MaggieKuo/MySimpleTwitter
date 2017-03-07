package com.mag.codepath.simpletweet.models;

import android.content.ContentValues;
import android.database.Cursor;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.ConditionGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.LongProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class Tweet_Table extends ModelAdapter<Tweet> {
  /**
   * Primary Key */
  public static final LongProperty uid = new LongProperty(Tweet.class, "uid");

  public static final Property<String> body = new Property<String>(Tweet.class, "body");

  public static final Property<String> createAt = new Property<String>(Tweet.class, "createAt");

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{uid,body,createAt};

  public Tweet_Table(DatabaseHolder holder, DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<Tweet> getModelClass() {
    return Tweet.class;
  }

  public final String getTableName() {
    return "`Tweet`";
  }

  @Override
  public final BaseProperty getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch (columnName)  {
      case "`uid`":  {
        return uid;
      }
      case "`body`":  {
        return body;
      }
      case "`createAt`":  {
        return createAt;
      }
      default:  {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return ALL_COLUMN_PROPERTIES;
  }

  @Override
  public final void bindToInsertValues(ContentValues values, Tweet model) {
    values.put("`uid`", model.uid);
    values.put("`body`", model.body != null ? model.body : null);
    values.put("`createAt`", model.createAt != null ? model.createAt : null);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, Tweet model, int start) {
    statement.bindLong(1 + start, model.uid);
    if (model.body != null)  {
      statement.bindString(2 + start, model.body);
    } else {
      statement.bindNull(2 + start);
    }
    if (model.createAt != null)  {
      statement.bindString(3 + start, model.createAt);
    } else {
      statement.bindNull(3 + start);
    }
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, Tweet model) {
    bindToInsertStatement(statement, model, 0);
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `Tweet`(`uid`,`body`,`createAt`) VALUES (?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `Tweet`(`uid`,`body`,`createAt`) VALUES (?,?,?)";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `Tweet`(`uid` INTEGER,`body` TEXT,`createAt` TEXT, PRIMARY KEY(`uid`)" + ");";
  }

  @Override
  public final void loadFromCursor(Cursor cursor, Tweet model) {
    int index_uid = cursor.getColumnIndex("uid");
    if (index_uid != -1 && !cursor.isNull(index_uid)) {
      model.uid = cursor.getLong(index_uid);
    } else {
      model.uid = (long) 0;
    }
    int index_body = cursor.getColumnIndex("body");
    if (index_body != -1 && !cursor.isNull(index_body)) {
      model.body = cursor.getString(index_body);
    } else {
      model.body = null;
    }
    int index_createAt = cursor.getColumnIndex("createAt");
    if (index_createAt != -1 && !cursor.isNull(index_createAt)) {
      model.createAt = cursor.getString(index_createAt);
    } else {
      model.createAt = null;
    }
  }

  @Override
  public final boolean exists(Tweet model, DatabaseWrapper wrapper) {
    return SQLite.selectCountOf()
    .from(Tweet.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final ConditionGroup getPrimaryConditionClause(Tweet model) {
    ConditionGroup clause = ConditionGroup.clause();
    clause.and(uid.eq(model.uid));
    return clause;
  }

  @Override
  public final Tweet newInstance() {
    return new Tweet();
  }
}
