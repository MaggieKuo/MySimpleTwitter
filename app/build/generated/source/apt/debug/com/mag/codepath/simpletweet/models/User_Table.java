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
public final class User_Table extends ModelAdapter<User> {
  /**
   * Primary Key */
  public static final LongProperty uid = new LongProperty(User.class, "uid");

  public static final Property<String> name = new Property<String>(User.class, "name");

  public static final Property<String> screenName = new Property<String>(User.class, "screenName");

  public static final Property<String> profileImageUrl = new Property<String>(User.class, "profileImageUrl");

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{uid,name,screenName,profileImageUrl};

  public User_Table(DatabaseHolder holder, DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<User> getModelClass() {
    return User.class;
  }

  public final String getTableName() {
    return "`User`";
  }

  @Override
  public final BaseProperty getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch (columnName)  {
      case "`uid`":  {
        return uid;
      }
      case "`name`":  {
        return name;
      }
      case "`screenName`":  {
        return screenName;
      }
      case "`profileImageUrl`":  {
        return profileImageUrl;
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
  public final void bindToInsertValues(ContentValues values, User model) {
    values.put("`uid`", model.uid);
    values.put("`name`", model.name != null ? model.name : null);
    values.put("`screenName`", model.screenName != null ? model.screenName : null);
    values.put("`profileImageUrl`", model.profileImageUrl != null ? model.profileImageUrl : null);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, User model, int start) {
    statement.bindLong(1 + start, model.uid);
    if (model.name != null)  {
      statement.bindString(2 + start, model.name);
    } else {
      statement.bindNull(2 + start);
    }
    if (model.screenName != null)  {
      statement.bindString(3 + start, model.screenName);
    } else {
      statement.bindNull(3 + start);
    }
    if (model.profileImageUrl != null)  {
      statement.bindString(4 + start, model.profileImageUrl);
    } else {
      statement.bindNull(4 + start);
    }
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, User model) {
    bindToInsertStatement(statement, model, 0);
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `User`(`uid`,`name`,`screenName`,`profileImageUrl`) VALUES (?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `User`(`uid`,`name`,`screenName`,`profileImageUrl`) VALUES (?,?,?,?)";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `User`(`uid` INTEGER,`name` TEXT,`screenName` TEXT,`profileImageUrl` TEXT, PRIMARY KEY(`uid`)" + ");";
  }

  @Override
  public final void loadFromCursor(Cursor cursor, User model) {
    int index_uid = cursor.getColumnIndex("uid");
    if (index_uid != -1 && !cursor.isNull(index_uid)) {
      model.uid = cursor.getLong(index_uid);
    } else {
      model.uid = (long) 0;
    }
    int index_name = cursor.getColumnIndex("name");
    if (index_name != -1 && !cursor.isNull(index_name)) {
      model.name = cursor.getString(index_name);
    } else {
      model.name = null;
    }
    int index_screenName = cursor.getColumnIndex("screenName");
    if (index_screenName != -1 && !cursor.isNull(index_screenName)) {
      model.screenName = cursor.getString(index_screenName);
    } else {
      model.screenName = null;
    }
    int index_profileImageUrl = cursor.getColumnIndex("profileImageUrl");
    if (index_profileImageUrl != -1 && !cursor.isNull(index_profileImageUrl)) {
      model.profileImageUrl = cursor.getString(index_profileImageUrl);
    } else {
      model.profileImageUrl = null;
    }
  }

  @Override
  public final boolean exists(User model, DatabaseWrapper wrapper) {
    return SQLite.selectCountOf()
    .from(User.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final ConditionGroup getPrimaryConditionClause(User model) {
    ConditionGroup clause = ConditionGroup.clause();
    clause.and(uid.eq(model.uid));
    return clause;
  }

  @Override
  public final User newInstance() {
    return new User();
  }
}
