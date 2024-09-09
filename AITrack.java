package assignment01;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class AITrack implements TrackCheck 
{
    private static final Set<String> aiElectives = Set.of("CS515", "CS517", "CS517X", "CS524", "CS555", "CS556", "CS580E", "CS580P", "CS580N");
    @Override
    public boolean check(ArrayList<String> list) 
    {
        Set<String> finished = new TreeSet<>(list);
        finished.retainAll(aiElectives);  
        return finished.size() >= 2;
    }
}