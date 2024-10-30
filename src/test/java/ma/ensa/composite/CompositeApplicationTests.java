package ma.ensa.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ma.ensa.composite.model.Mission;
import ma.ensa.composite.model.Path;

@SpringBootTest
class CompositeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMissionWithSubMissionsAndPaths() {
        // Create paths using Lombok builder
        Path path1 = Path.builder().distance(5.0f).build();
        Path path2 = Path.builder().distance(3.0f).build();
        Path path3 = Path.builder().distance(7.0f).build();
		path1.setName("Path 1");
		path2.setName("Path 2");
		path3.setName("Path 3");
        // Create sub-missions and add paths to them
        Mission subMission1 = new Mission("Sub Mission 1");
        subMission1.addMissionComponent(path1);

        Mission subMission2 = new Mission("Sub Mission 2");
        subMission2.addMissionComponent(path2);

        // Create main mission and add sub-missions and an additional path
        Mission mainMission = new Mission("Main Mission");
        mainMission.addMissionComponent(subMission1);
        mainMission.addMissionComponent(subMission2);
        mainMission.addMissionComponent(path3);

        // Execute the main mission
        mainMission.execute();

        // Assertions to verify the structure
        assertEquals(3, mainMission.getMissionComponents().size());
        assertEquals(subMission1, mainMission.getMissionComponents().get(0));
        assertEquals(subMission2, mainMission.getMissionComponents().get(1));
        assertEquals(path3, mainMission.getMissionComponents().get(2));
        assertEquals(1, subMission1.getMissionComponents().size());
        assertEquals(path1, subMission1.getMissionComponents().get(0));
        assertEquals(1, subMission2.getMissionComponents().size());
        assertEquals(path2, subMission2.getMissionComponents().get(0));
    }
}