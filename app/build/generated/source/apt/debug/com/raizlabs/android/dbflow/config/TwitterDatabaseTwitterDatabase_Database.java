package com.raizlabs.android.dbflow.config;

import com.mag.codepath.simpletweet.db.TwitterDatabase;
import com.mag.codepath.simpletweet.models.SampleModel;
import com.mag.codepath.simpletweet.models.SampleModel_Table;
import com.mag.codepath.simpletweet.models.Tweet;
import com.mag.codepath.simpletweet.models.Tweet_Table;
import com.mag.codepath.simpletweet.models.User;
import com.mag.codepath.simpletweet.models.User_Table;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class TwitterDatabaseTwitterDatabase_Database extends DatabaseDefinition {
  public TwitterDatabaseTwitterDatabase_Database(DatabaseHolder holder) {
    holder.putDatabaseForTable(Tweet.class, this);
    holder.putDatabaseForTable(SampleModel.class, this);
    holder.putDatabaseForTable(User.class, this);
    models.add(Tweet.class);
    modelTableNames.put("Tweet", Tweet.class);
    modelAdapters.put(Tweet.class, new Tweet_Table(holder, this));
    models.add(SampleModel.class);
    modelTableNames.put("SampleModel", SampleModel.class);
    modelAdapters.put(SampleModel.class, new SampleModel_Table(holder, this));
    models.add(User.class);
    modelTableNames.put("User", User.class);
    modelAdapters.put(User.class, new User_Table(holder, this));
  }

  @Override
  public final Class<?> getAssociatedDatabaseClassFile() {
    return TwitterDatabase.class;
  }

  @Override
  public final boolean isForeignKeysSupported() {
    return false;
  }

  @Override
  public final boolean isInMemory() {
    return false;
  }

  @Override
  public final boolean backupEnabled() {
    return false;
  }

  @Override
  public final boolean areConsistencyChecksEnabled() {
    return false;
  }

  @Override
  public final int getDatabaseVersion() {
    return 1;
  }

  @Override
  public final String getDatabaseName() {
    return "TwitterDatabase";
  }
}
