package ad.de.hellodatabinding;

import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DataBinding {
  @android.databinding.BindingAdapter("watcher")
  public static void addTextChangedListener(EditText view, TextWatcher watcher) {
    view.addTextChangedListener(watcher);
  }

  @android.databinding.BindingAdapter("listener")
  public static void setTextChangedListener(CompoundButton view,
      CompoundButton.OnCheckedChangeListener listener) {
    view.setOnCheckedChangeListener(listener);
  }

  @android.databinding.BindingAdapter("adapter")
  public static void setAdapter(ListView view, ListAdapter adapter) {
    view.setAdapter(adapter);
  }

  @android.databinding.BindingAdapter("listener")
  public static void setOnItemClickListener(ListView view,
      AdapterView.OnItemClickListener listener) {
    view.setOnItemClickListener(listener);
  }
}
