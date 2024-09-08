package assignment01;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class CyberTrack implements TrackCheck {
    private static final Set<String> cyberElectiveSet = Set.of("CS515", "CS517", "CS561", "CS556", "CS580E", "CS580P", "CS580N");
    private static final String COURSE_536 = "CS536";
    private static final String COURSE_580E = "CS580E";

    @Override
    public boolean check(ArrayList<String> list) {
        Set<String> takenSet = new TreeSet<>(list);
        takenSet.retainAll(cyberElectiveSet);  // Get intersection with Cyber electives

        boolean hasCS536 = list.contains(COURSE_536);
        boolean hasCS580E = list.contains(COURSE_580E);

        if (hasCS536 && hasCS580E) {
            return false;  // Only one of CS536 and CS580E can be used
        }

        return takenSet.size() >= 2;  // Minimum of 2 Cyber electives required
    }
}
