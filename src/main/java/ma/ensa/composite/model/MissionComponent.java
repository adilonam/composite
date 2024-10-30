package ma.ensa.composite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class MissionComponent {
    private String name;
    public abstract void execute();
}