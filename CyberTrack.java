package assignment01;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class CyberTrack implements TrackCheck 
{
    private static final Set<String> cyberElectiveSet = Set.of("CS527", "CS528", "CS536", "CS580A", "CS580T", "CS553X", "CS680P", "CS580E");
    private static final String COURSE_536 = "CS536";
    private static final String COURSE_580E = "CS580E";
    private static final String COURSE_558 = "CS558";
    private static final String COURSE_559 = "CS559";

    @Override
    public boolean check(ArrayList<String> list) 
    {
        // Convert list to a Set for easier operations
        Set<String> takenSet = new TreeSet<>(list);
        
        // Get intersection with Cyber electives
        takenSet.retainAll(cyberElectiveSet);

        // Check mutual exclusivity of CS536 and CS580E and Inclusivity of both CS558 and CS559
        boolean hasCS536 = list.contains(COURSE_536);
        boolean hasCS580E = list.contains(COURSE_580E);
        boolean hasCS558 = list.contains(COURSE_558);
        boolean hasCS559 = list.contains(COURSE_559);

        // Ensure only one of CS536 or CS580E is used
        if (hasCS536 && hasCS580E) 
        {
            return false;  // Only one of CS536 and CS580E can be used
        }
        
        // Ensure both CS558 and CS559 are taken
        if (!(hasCS558 && hasCS559)) 
        {
            return false; // both 558 and 559 are needed
        }
        // Check if at least 2 Cyber electives are taken
        return takenSet.size() >= 2;
    }
}
