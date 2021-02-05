package projektor.projekt;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
class Zeitraum {

  private  LocalDate von;
  private  LocalDate bis;

  public Zeitraum(LocalDate von, LocalDate bis) {
    this.von = von;
    this.bis = bis;
  }

  public LocalDate getVon() {
    return von;
  }

  public LocalDate getBis() {
    return bis;
  }

  @Override
  public String toString() {
    return "Zeitraum{" +
        "von=" + von +
        ", bis=" + bis +
        '}';
  }
}
