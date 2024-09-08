package assignment01;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class AITrack implements TrackCheck {
    private static final Set<String> aiElectiveSet = Set.of("CS515", "CS517", "CS517X", "CS524", "CS555", "CS556", "CS580E", "CS580P", "CS580N");

    @Override
    public boolean check(ArrayList<String> list) {
        Set<String> takenSet = new TreeSet<>(list);
        takenSet.retainAll(aiElectiveSet);  // Get intersection with AI electives
        return takenSet.size() >= 2;  // Minimum of 2 AI electives required
    }
}
