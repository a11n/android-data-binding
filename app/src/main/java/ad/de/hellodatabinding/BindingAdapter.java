package ad.de.hellodatabinding;

import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;

public class BindingAdapter {
  @android.databinding.BindingAdapter("watcher")
  public static void addTextChangedListener(EditText view, TextWatcher watcher) {
    view.addTextChangedListener(watcher);
  }

  @android.databinding.BindingAdapter("listener")
  public static void addTextChangedListener(CompoundButton view, CompoundButton.OnCheckedChangeListener listener) {
    view.setOnCheckedChangeListener(listener);
  }
}
