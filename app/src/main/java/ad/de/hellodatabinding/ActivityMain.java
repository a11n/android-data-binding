package ad.de.hellodatabinding;

import ad.de.hellodatabinding.databinding.ActivityMainBinding;
import ad.de.hellodatabinding.databinding.ListItemBinding;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;

public class ActivityMain extends AppCompatActivity {

  private ActivityMainBinding binding;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setWatcher(new MyTextWatcher());
    binding.setCheckedChangeListener(new MyOnCheckedChangeListener());
    binding.setAdapter(new MyBaseAdapter(Arrays.asList("Item #1", "Item #2")));
    binding.setItemClickListener(new MyOnItemClickListener());

  }

  @Override protected void onResume() {
    super.onResume();

    binding.setName("World");
  }

  private class MyBaseAdapter extends BaseAdapter {

    private List<String> items;

    private MyBaseAdapter(List<String> items) {
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
      ListItemBinding binding =
          DataBindingUtil.inflate(getLayoutInflater(), R.layout.list_item, parent, false);

      binding.setText(items.get(position));

      return binding.getRoot();
    }
  }

  private class MyTextWatcher implements TextWatcher {

    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
      binding.setName(s.toString());
    }

    @Override public void afterTextChanged(Editable s) {

    }
  }

  private class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

    @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
      binding.setHideSection(isChecked);
    }
  }

  private static class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(view.getContext(), "Item #" + (position + 1), Toast.LENGTH_SHORT).show();
    }
  }
}
