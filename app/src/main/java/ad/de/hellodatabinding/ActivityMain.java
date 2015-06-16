package ad.de.hellodatabinding;

import ad.de.hellodatabinding.databinding.ActivityMainBinding;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;

public class ActivityMain extends AppCompatActivity {

  private ActivityMainBinding binding;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setWatcher(new MyTextWatcher());
    binding.setListener(new MyOnCheckedChangeListener());
  }

  @Override protected void onResume() {
    super.onResume();

    binding.setName("World");
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
}
