package ad.de.hellodatabinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DataBinding {
  @android.databinding.BindingAdapter("bind")
  public static void addTextChangedListener(EditText view, final int variable) {
    final ViewDataBinding binding = DataBindingUtil.findBinding(view);

    view.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        binding.setVariable(variable, s.toString());
        binding.executePendingBindings();
      }

      @Override public void afterTextChanged(Editable s) {

      }
    });
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
