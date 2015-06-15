package ad.de.hellodatabinding;

import android.databinding.ObservableField;

public class ViewModelMain {
  public final ObservableField<String> name = new ObservableField<>();

  public ViewModelMain(String name) {
    this.name.set(name);
  }
}
