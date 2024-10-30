package ma.ensa.composite.model;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission extends MissionComponent {
    private List<MissionComponent> missionComponents = new ArrayList<>();

    public Mission(String name) {
        super(name);
    }

    public void addMissionComponent(MissionComponent missionComponent) {
        missionComponents.add(missionComponent);
    }

    public void removeMissionComponent(MissionComponent missionComponent) {
        missionComponents.remove(missionComponent);
    }


@Override
    public void execute() {
        System.out.println("Executing mission: " + getName());
        for (MissionComponent missionComponent : missionComponents) {
            missionComponent.execute();
        }
    }
}