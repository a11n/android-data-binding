package ad.de.hellodatabinding;

import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class BindingAdapter {
  @android.databinding.BindingAdapter("watcher")
  public static void addTextChangedListener(EditText view, TextWatcher watcher) {
    view.addTextChangedListener(watcher);
  }

  @android.databinding.BindingAdapter("listener")
  public static void addTextChangedListener(CompoundButton view,
      CompoundButton.OnCheckedChangeListener listener) {
    view.setOnCheckedChangeListener(listener);
  }

  @android.databinding.BindingAdapter("adapter")
  public static void addOnItemClickListener(ListView view, ListAdapter adapter) {
    view.setAdapter(adapter);
  }

  @android.databinding.BindingAdapter("listener")
  public static void addOnItemClickListener(ListView view,
      AdapterView.OnItemClickListener listener) {
    view.setOnItemClickListener(listener);
  }
}
