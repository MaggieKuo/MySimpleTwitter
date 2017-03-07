// Generated code from Butter Knife. Do not modify!
package com.mag.codepath.simpletweet.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mag.codepath.simpletweet.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TimelineActivity2_ViewBinding implements Unbinder {
  private TimelineActivity2 target;

  @UiThread
  public TimelineActivity2_ViewBinding(TimelineActivity2 target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TimelineActivity2_ViewBinding(TimelineActivity2 target, View source) {
    this.target = target;

    target.recyclerTimeline = Utils.findRequiredViewAsType(source, R.id.recycler_timeline, "field 'recyclerTimeline'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TimelineActivity2 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerTimeline = null;
  }
}
