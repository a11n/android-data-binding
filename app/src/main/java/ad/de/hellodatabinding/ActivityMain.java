package ad.de.hellodatabinding;

import ad.de.hellodatabinding.databinding.ActivityMainBinding;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Toast;
import java.util.Arrays;


public class ActivityMain extends AppCompatActivity {

  private ActivityMainBinding binding;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setCheckedChangeListener(new MyOnCheckedChangeListener());
    binding.setItems(Arrays.asList("Item #1", "Item #2"));
    binding.setItemClickListener(new MyOnItemClickListener());
  }

  @Override protected void onResume() {
    super.onResume();

    binding.setName("World");
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
