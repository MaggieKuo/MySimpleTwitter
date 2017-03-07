// Generated code from Butter Knife. Do not modify!
package com.mag.codepath.simpletweet.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mag.codepath.simpletweet.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TweetsRecyclerAdapter$ViewHolder_ViewBinding implements Unbinder {
  private TweetsRecyclerAdapter.ViewHolder target;

  @UiThread
  public TweetsRecyclerAdapter$ViewHolder_ViewBinding(TweetsRecyclerAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.imgUsr = Utils.findRequiredViewAsType(source, R.id.imgUsr, "field 'imgUsr'", ImageView.class);
    target.txtUserName = Utils.findRequiredViewAsType(source, R.id.txtUserName, "field 'txtUserName'", TextView.class);
    target.txtBody = Utils.findRequiredViewAsType(source, R.id.txtBody, "field 'txtBody'", TextView.class);
    target.txtTwitter = Utils.findRequiredViewAsType(source, R.id.txtTwitter, "field 'txtTwitter'", TextView.class);
    target.txtRelativeTime = Utils.findRequiredViewAsType(source, R.id.txtRelativeTime, "field 'txtRelativeTime'", TextView.class);
    target.imgTweetPic = Utils.findRequiredViewAsType(source, R.id.imgTweetPic, "field 'imgTweetPic'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TweetsRecyclerAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgUsr = null;
    target.txtUserName = null;
    target.txtBody = null;
    target.txtTwitter = null;
    target.txtRelativeTime = null;
    target.imgTweetPic = null;
  }
}
