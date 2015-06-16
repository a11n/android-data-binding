package ad.de.hellodatabinding;

import android.text.TextWatcher;
import android.widget.EditText;

public class BindingAdapter {
  @android.databinding.BindingAdapter("watcher")
  public static void addTextChangedListener(EditText view, TextWatcher watcher) {
    view.addTextChangedListener(watcher);
  }
}
