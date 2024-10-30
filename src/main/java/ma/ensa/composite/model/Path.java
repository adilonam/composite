package ma.ensa.composite.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Path extends MissionComponent {
    private float distance;


    @Override
    public void execute() {
        System.out.println("Executing path: " + getName() + " with distance: " + getDistance() + " km");
    }
}