package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 1) return true;
        intervals.sort(Comparator.comparingInt(a -> a.start));

        for(int i = 1; i< intervals.size(); i++){
            Interval currMeeting = intervals.get(i);
            if(currMeeting.start < intervals.get(i-1).end) {
                return false;
            }
        }

        return true;
    }
}
