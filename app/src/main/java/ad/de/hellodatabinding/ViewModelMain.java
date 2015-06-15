package ad.de.hellodatabinding;

import android.databinding.ObservableField;

public class ViewModelMain {
  public final ObservableField<String> name;

  public ViewModelMain(String name) {
    this.name = new ObservableField<>();

    this.name.set(name);
  }
}
