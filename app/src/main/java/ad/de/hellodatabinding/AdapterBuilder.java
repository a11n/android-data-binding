package ad.de.hellodatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class AdapterBuilder {

  public static RawAdapterBuilder adapt(List<?> items) {
    return new Adapter(items);
  }

  private static class Adapter extends BaseAdapter
      implements RawAdapterBuilder, FinalAdapterBuilder {

    private List<?> items;
    private int variable;
    private int layoutId;

    @Override public FinalAdapterBuilder on(int variable) {
      this.variable = variable;
      return this;
    }

    @Override public BaseAdapter with(@LayoutRes int layoutId) {
      this.layoutId = layoutId;
      return this;
    }

    private Adapter(List<?> items) {
      this.items = items;
    }

    @Override public int getCount() {
      return items.size();
    }

    @Override public Object getItem(int position) {
      return items.get(position);
    }

    @Override public long getItemId(int position) {
      return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
      convertView = initConvertViewIfNotNull(convertView, parent);

      bindView(convertView, position);

      return convertView;
    }

    private View initConvertViewIfNotNull(View convertView, ViewGroup parent) {
      if (convertView == null) {
        convertView = initView(parent);
      }
      return convertView;
    }

    private void bindView(View view, int position) {
      ViewDataBinding binding = (ViewDataBinding) view.getTag();

      binding.setVariable(variable, getItem(position));
      binding.executePendingBindings();
    }

    private View initView(ViewGroup parent) {
      Context context = parent.getContext();
      LayoutInflater inflater = LayoutInflater.from(context);

      ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);

      View view = binding.getRoot();
      view.setTag(binding);

      return view;
    }
  }

  public interface RawAdapterBuilder {
    FinalAdapterBuilder on(int variable);
  }

  public interface FinalAdapterBuilder {
    BaseAdapter with(int layoutId);
  }
}
