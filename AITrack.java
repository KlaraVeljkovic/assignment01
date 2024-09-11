package assignment01;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class AITrack implements TrackCheck 
{
    private static final Set<String> aiElectiveSet = Set.of(
        "CS515", "CS517X", "CS524", "CS535", "CS555", "CS556", 
        "CS580D", "CS580P", "CS580E"
    );
    // Define the sets of required courses and elective courses
    private static final String REQUIRED_COURSE_536 = "CS536";
    private static final String REQUIRED_COURSE_565 = "CS565";
    
   

    @Override
    public boolean check(ArrayList<String> list) 
    {
        // Convert list to a Set for easier operations
        Set<String> takenSet = new TreeSet<>(list);
        
        // Check for required courses
        boolean hasCS536 = list.contains(REQUIRED_COURSE_536);
        boolean hasCS565 = list.contains(REQUIRED_COURSE_565);

        // Ensure both required courses are taken
        if (!(hasCS536 && hasCS565)) 
        {
            return false; // both 436 and 465 are required
        }
        
        // Get the intersection with AI electives
        takenSet.retainAll(aiElectiveSet);
        
        // Check if at least 2 AI electives are taken
        return takenSet.size() >= 2;
    }
}
