package ad.de.hellodatabinding;

import ad.de.hellodatabinding.databinding.ActivityMainBinding;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.Arrays;

public class ActivityMain extends AppCompatActivity {

  private ActivityMainBinding binding;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setItems(Arrays.asList("Item #1", "Item #2"));
    binding.setItemClickListener(new MyOnItemClickListener());
  }

  @Override protected void onResume() {
    super.onResume();
  }

  private static class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(view.getContext(), "Item #" + (position + 1), Toast.LENGTH_SHORT).show();
    }
  }
}
