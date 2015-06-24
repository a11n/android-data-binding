package de.ad.databinding.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import de.ad.databinding.BR;
import de.ad.databinding.R;
import de.ad.databinding.databinding.ActivityContactsBinding;
import de.ad.databinding.util.AdapterBuilder;
import java.util.Arrays;
import java.util.List;

public class ActivityContacts extends AppCompatActivity {

  private ActivityContactsBinding binding;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_contacts);
  }

  @Override protected void onResume() {
    super.onResume();

    List<?> contacts = loadContacts();
    binding.setAdapter(AdapterBuilder.adapt(contacts).on(BR.text).with(R.layout.item_contact));
  }

  private List<?> loadContacts() {
    return Arrays.asList("Michael", "Peter", "Robbie", "Bruno");
  }
}
